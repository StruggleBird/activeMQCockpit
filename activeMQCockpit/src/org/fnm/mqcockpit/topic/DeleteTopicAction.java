package org.fnm.mqcockpit.topic;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.fnm.mqcockpit.JMXAction;

public class DeleteTopicAction extends JMXAction {

	private String topicName;

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() throws Exception {
		
		if (!checkJMXSettings())
			return "missingJmxSettings"; 

		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+jmxPort+"/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(url, null);
		MBeanServerConnection connection = connector.getMBeanServerConnection();
		ObjectName name = new ObjectName("org.apachemq:type=Broker,brokerName="+jmxBrokerName);
		BrokerViewMBean brokerViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection, name,
				BrokerViewMBean.class, true);
		brokerViewMBean.removeTopic(topicName);
		connector.close();

		return "success";
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
