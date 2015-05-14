package org.fnm.mqcockpit.message;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.QueueBrowser;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQQueue;

public class MessageDetailAction {

	private String queueName;
	private String commandId;
	private MessageBean message;

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() throws Exception {

		ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection connection = factory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		ActiveMQQueue destination = (ActiveMQQueue) session.createQueue(queueName);

		QueueBrowser browser = session.createBrowser(destination);
		Enumeration<?> enumeration = browser.getEnumeration();

		while (enumeration.hasMoreElements()) {
			ActiveMQMessage mqMessage = (ActiveMQMessage) enumeration.nextElement();
			if (mqMessage.getCommandId() == Integer.parseInt(commandId)) {
				message = new MessageBean();
				message.build(mqMessage);
				message.setQueueName(browser.getQueue().getQueueName());
			}
		}

		connection.stop();
		connection.close();

		return "success";
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public MessageBean getMessage() {
		return message;
	}

	public void setMessage(MessageBean message) {
		this.message = message;
	}

}
