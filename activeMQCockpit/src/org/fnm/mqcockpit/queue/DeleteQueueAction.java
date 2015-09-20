package org.fnm.mqcockpit.queue;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.fnm.mqcockpit.JMXAction;

public class DeleteQueueAction extends JMXAction {

	private String queueName;

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() throws Exception {
		
		if (!checkJMXSettings())
			return "missingJmxSettings";

		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+jmxPort+"/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(url, null);
		MBeanServerConnection connection = connector.getMBeanServerConnection();
		ObjectName name = new ObjectName("org.apache.activemq:type=Broker,brokerName="+jmxBrokerName);
		BrokerViewMBean brokerViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection, name,
				BrokerViewMBean.class, true);
		brokerViewMBean.removeQueue(queueName);
		connector.close();

		return "success";
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

}
