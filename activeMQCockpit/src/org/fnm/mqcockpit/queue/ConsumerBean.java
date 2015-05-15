package org.fnm.mqcockpit.queue;

import org.apache.activemq.broker.jmx.SubscriptionViewMBean;

public class ConsumerBean {

	private String queueName;
	private String clientId;
	private String userName;
	private long enqueueCounter;
	private boolean isNetwork;
	private boolean isSlowConsumer;
	private String connectionId;

	public void build(SubscriptionViewMBean mBean) {
		clientId = mBean.getClientId();
		userName = mBean.getUserName();
		enqueueCounter = mBean.getEnqueueCounter();
		isNetwork = mBean.isNetwork();
		isSlowConsumer = mBean.isSlowConsumer();
		connectionId = mBean.getConnectionId();
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getQueueName() {
		return queueName;
	}

	public String getUserName() {
		return userName;
	}

	public long getEnqueueCounter() {
		return enqueueCounter;
	}

	public boolean isNetwork() {
		return isNetwork;
	}

	public boolean isSlowConsumer() {
		return isSlowConsumer;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getConnectionId() {
		return connectionId;
	}

}
