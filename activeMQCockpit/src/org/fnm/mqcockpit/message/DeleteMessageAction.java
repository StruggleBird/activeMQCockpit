package org.fnm.mqcockpit.message;

import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.fnm.mqcockpit.JMXAction;

public class DeleteMessageAction extends JMXAction {

	private String queueName;
	private String jmsMessageId;

	private List<MessageBean> messages = new ArrayList<>();

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() throws Exception {
		
		if (!checkJMXSettings())
			return "missingJmxSettings";

		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+jmxPort+"/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(url, null);
		MBeanServerConnection connection = connector.getMBeanServerConnection();
		ObjectName objectName = new ObjectName(
				"org.apachemq:type=Broker,brokerName="+jmxBrokerName+",destinationType=Queue,destinationName=" + queueName);
		QueueViewMBean queueViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection, objectName,
				QueueViewMBean.class, true);
		queueViewMBean.removeMessage(jmsMessageId);

		connector.close();

		MessageFinder finder = new MessageFinder(); 
		messages = finder.findMessages(queueName);

		return "success";
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public void setJmsMessageId(String jmsMessageId) {
		this.jmsMessageId = jmsMessageId;
	}

	public List<MessageBean> getMessages() {
		return messages;
	}

}
