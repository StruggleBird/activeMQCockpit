package org.fnm.mqcockpit.message;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQMessage;

public class MessageBean {

	private String queueName; 
	private String className;
	private int commandId;
	private String correlationId;
	private String replyTo;
	private long timestamp;
	private boolean isPersistent;
	private boolean isResponseRequired;
	private boolean isExpired;
	private boolean isResponse;
	private String text;
	private String jmsMessageId; 
	private long jmsPriority; 
	private Map<String, Object> properties = new HashMap<>(); 

	public void build(ActiveMQMessage msg) throws IOException {
		className = msg.getClass().getSimpleName();
		correlationId = msg.getCorrelationId();
		replyTo = (msg.getReplyTo() != null) ? msg.getReplyTo().getPhysicalName() : "";
		timestamp = msg.getTimestamp();
		isPersistent = msg.isPersistent();
		isResponseRequired = msg.isResponseRequired();
		isResponse = msg.isResponse();
		commandId = msg.getCommandId();
		jmsMessageId = msg.getJMSMessageID(); 
		try {
			text = (msg instanceof TextMessage) ? ((TextMessage) msg).getText() : "Binary Content cannot be shown";
		} catch (Exception e) {
			text = e.getMessage();
		}
		jmsPriority = msg.getJMSPriority(); 
		Map<String, Object> props = msg.getProperties();
		for (Entry<String, Object> entry : props.entrySet()) {
			properties.put(entry.getKey(), entry.getValue()); 
		} 
		
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replayTo) {
		this.replyTo = replayTo;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isPersistent() {
		return isPersistent;
	}

	public void setPersistent(boolean isPersistent) {
		this.isPersistent = isPersistent;
	}

	public boolean isResponseRequired() {
		return isResponseRequired;
	}

	public void setResponseRequired(boolean isRespoonseRequired) {
		this.isResponseRequired = isRespoonseRequired;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public boolean isResponse() {
		return isResponse;
	}

	public void setResponse(boolean isResponse) {
		this.isResponse = isResponse;
	}

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getJmsMessageId() {
		return jmsMessageId;
	}

	public void setJmsMessageId(String messageId) {
		this.jmsMessageId = messageId;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public long getJmsPriority() {
		return jmsPriority;
	}

	public void setJmsPriority(long jmsPriority) {
		this.jmsPriority = jmsPriority;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

}
