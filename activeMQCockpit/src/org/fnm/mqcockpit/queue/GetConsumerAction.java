package org.fnm.mqcockpit.queue;

import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.activemq.broker.jmx.SubscriptionViewMBean;
import org.fnm.mqcockpit.JMXAction;

public class GetConsumerAction extends JMXAction {

	private String queueName;
	private List<ConsumerBean> consumer = new ArrayList<>();

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

		ObjectName queueObjectName = new ObjectName("org.apachemq:type=Broker,brokerName=" + jmxBrokerName
				+ ",destinationType=Queue,destinationName=" + queueName);

		QueueViewMBean queueMBean = MBeanServerInvocationHandler.newProxyInstance(connection, queueObjectName,
				QueueViewMBean.class, true);

		ObjectName[] objectNames = queueMBean.getSubscriptions();
		for (ObjectName objectName : objectNames) {
			SubscriptionViewMBean subscriptionViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection,
					objectName, SubscriptionViewMBean.class, true);
			ConsumerBean bean = new ConsumerBean();
			bean.build(subscriptionViewMBean);
			bean.setQueueName(queueName);
			consumer.add(bean);
		}

		connector.close();

		return "success";
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public List<ConsumerBean> getConsumer() {
		return consumer;
	}

}
