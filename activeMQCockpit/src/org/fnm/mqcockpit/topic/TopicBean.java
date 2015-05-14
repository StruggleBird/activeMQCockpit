package org.fnm.mqcockpit.topic;

import org.apache.activemq.broker.jmx.TopicViewMBean;

public class TopicBean {

	private String name;
	private long size;
	private long enqueueCount;
	private long dequeueCount;
	private long consumerCount;
	private long producerCount;

	private double avarageBlockedTime;
	private double averageEnqueueTime;

	private long maxMessageSize;
	private long expiredCount;

	public void build(TopicViewMBean mBean) {

		name = mBean.getName();

		size = mBean.getQueueSize();
		enqueueCount = mBean.getEnqueueCount();
		dequeueCount = mBean.getDequeueCount();

		consumerCount = mBean.getConsumerCount();
		producerCount = mBean.getProducerCount();

		avarageBlockedTime = mBean.getAverageBlockedTime();
		averageEnqueueTime = mBean.getAverageEnqueueTime();

		maxMessageSize = mBean.getMaxMessageSize();
		expiredCount = mBean.getExpiredCount();
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

	public long getMaxMessageSize() {
		return maxMessageSize;
	}

	public long getExpiredCount() {
		return expiredCount;
	}

}
