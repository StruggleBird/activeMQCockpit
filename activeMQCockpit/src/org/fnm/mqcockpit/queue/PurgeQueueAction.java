package org.fnm.mqcockpit.queue;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.QueueViewMBean;

public class PurgeQueueAction {

	private String queueName;

	private QueueBean queue;

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() throws Exception {

		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:2011/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(url, null);
		MBeanServerConnection connection = connector.getMBeanServerConnection();
		ObjectName objectName = new ObjectName(
				"org.apachemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=" + queueName);
		QueueViewMBean queueViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection,
				objectName, QueueViewMBean.class, true);
		queueViewMBean.purge();

		queue = new QueueBean();
		queue.build(queueViewMBean);

		connector.close();

		return "success";
	}

	public QueueBean getQueue() {
		return queue;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

}
