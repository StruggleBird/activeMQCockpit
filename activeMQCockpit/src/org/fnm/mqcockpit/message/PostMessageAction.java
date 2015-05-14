package org.fnm.mqcockpit.message;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PostMessageAction {

	private MessageBean message = new MessageBean();

	private List<MessageBean> messages = new ArrayList<>();

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() throws Exception {

		ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection connection = factory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(message.getQueueName());
		MessageProducer producer = session.createProducer(destination);

		// TODO set Properties
		TextMessage textMessage = session.createTextMessage();
		textMessage.setText(message.getText());
		if (message.getCorrelationId() != null)
			textMessage.setJMSCorrelationID(message.getCorrelationId());
		if (message.getReplyTo() != null && !message.getReplyTo().isEmpty())
			textMessage.setJMSReplyTo(session.createQueue(message.getReplyTo()));
		producer.send(textMessage);

		connection.stop();
		connection.close();

		// get the messages to be displayed when done
		MessageFinder finder = new MessageFinder();
		messages = finder.findMessages(message.getQueueName());

		return "success";
	}

	public MessageBean getMessage() {
		return message;
	}

	public void setMessage(MessageBean message) {
		this.message = message;
	}

	public List<MessageBean> getMessages() {
		return messages;
	}

}
