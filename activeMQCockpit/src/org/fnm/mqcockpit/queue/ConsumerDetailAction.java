package org.fnm.mqcockpit.queue;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.activemq.broker.jmx.SubscriptionViewMBean;
import org.fnm.mqcockpit.JMXAction;

public class ConsumerDetailAction extends JMXAction {

	private String queueName;
	private String clientId;

	private ConsumerBean consumer;

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() throws Exception {

		if (!checkJMXSettings())
			return "missingJmxSettings";

		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + jmxPort + "/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(url, null);
		connector.connect();

		MBeanServerConnection connection = connector.getMBeanServerConnection();

		ObjectName queueObjectName = new ObjectName("org.apache.activemq:type=Broker,brokerName=" + jmxBrokerName
				+ ",destinationType=Queue,destinationName=" + queueName);

		QueueViewMBean queueMBean = MBeanServerInvocationHandler.newProxyInstance(connection, queueObjectName,
				QueueViewMBean.class, true);

		ObjectName[] objectNames = queueMBean.getSubscriptions();
		for (ObjectName objectName : objectNames) {
			SubscriptionViewMBean subscriptionViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection,
					objectName, SubscriptionViewMBean.class, true);
			if (subscriptionViewMBean.getClientId().equals(clientId)){
				consumer = new ConsumerBean();
				consumer.build(subscriptionViewMBean);
				consumer.setQueueName(queueName);
			}
			
		}

		connector.close();

		return "success";
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public ConsumerBean getConsumer() {
		return consumer;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}
