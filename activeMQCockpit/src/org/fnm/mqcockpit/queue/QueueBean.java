package org.fnm.mqcockpit.queue;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.QueueViewMBean;

public class QueueBean {

	private String name;
	private long size;
	private long enqueueCount;
	private long dequeueCount;
	private long consumerCount;
	private long producerCount;

	private double avarageBlockedTime;
	private double averageEnqueueTime;

	private long cursorMemoryUsage;
	private int cursorPercentUsage;

	private long maxMessageSize;
	private long expiredCount;

	public void build(QueueViewMBean queueMBean) {

		name = queueMBean.getName();

		size = queueMBean.getQueueSize();
		enqueueCount = queueMBean.getEnqueueCount();
		dequeueCount = queueMBean.getDequeueCount();

		consumerCount = queueMBean.getConsumerCount();
		producerCount = queueMBean.getProducerCount();

		avarageBlockedTime = queueMBean.getAverageBlockedTime();
		averageEnqueueTime = queueMBean.getAverageEnqueueTime();

		cursorMemoryUsage = queueMBean.getCursorMemoryUsage();
		cursorPercentUsage = queueMBean.getCursorPercentUsage();

		maxMessageSize = queueMBean.getMaxMessageSize();
		expiredCount = queueMBean.getExpiredCount();
	}

	public void purge(String queueName) throws Exception {
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:2011/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(url, null);
		MBeanServerConnection connection = connector.getMBeanServerConnection();
		ObjectName objectName = new ObjectName(
				"org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=" + queueName);
		QueueViewMBean queueViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection,
				objectName, QueueViewMBean.class, true);
		queueViewMBean.purge();
		connector.close();
	}

	public String getName() {
		return name;
	}

	public long getSize() {
		return size;
	}

	public long getEnqueueCount() {
		return enqueueCount;
	}

	public long getDequeueCount() {
		return dequeueCount;
	}

	public long getConsumerCount() {
		return consumerCount;
	}

	public long getProducerCount() {
		return producerCount;
	}

	public double getAvarageBlockedTime() {
		return avarageBlockedTime;
	}

	public double getAverageEnqueueTime() {
		return averageEnqueueTime;
	}

	public long getCursorMemoryUsage() {
		return cursorMemoryUsage;
	}

	public int getCursorPercentUsage() {
		return cursorPercentUsage;
	}

	public long getMaxMessageSize() {
		return maxMessageSize;
	}

	public long getExpiredCount() {
		return expiredCount;
	}

}
