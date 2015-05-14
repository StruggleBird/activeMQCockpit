package org.fnm.mqcockpit.message;

import java.util.ArrayList;
import java.util.List;

public class GetMessagesAction {

	private String queueName;

	private List<MessageBean> messages = new ArrayList<>();

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() throws Exception {
		MessageFinder finder = new MessageFinder(); 
		messages = finder.findMessages(queueName);
		return "success";
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public List<MessageBean> getMessages() {
		return messages;
	}

}
