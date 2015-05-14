package org.fnm.mqcockpit.message;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.QueueBrowser;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQQueue;

public class MessageFinder {
	
	public List<MessageBean> findMessages(String queueName) throws Exception {
		
		List<MessageBean> messages = new ArrayList<>();

		ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection connection = factory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		ActiveMQQueue destination = (ActiveMQQueue) session.createQueue(queueName);

		QueueBrowser browser = session.createBrowser(destination);
		Enumeration<?> enumeration = browser.getEnumeration();

		while (enumeration.hasMoreElements()) {
			MessageBean bean = new MessageBean();
			bean.build((ActiveMQMessage) enumeration.nextElement());
			bean.setQueueName(queueName);
			messages.add(bean);
		}

		connection.stop();
		connection.close();
		
		return messages;
	}

}
