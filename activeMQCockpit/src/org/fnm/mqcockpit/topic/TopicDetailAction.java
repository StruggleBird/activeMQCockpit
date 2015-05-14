package org.fnm.mqcockpit.topic;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.TopicViewMBean;
import org.fnm.mqcockpit.JMXAction;

public class TopicDetailAction extends JMXAction {

	private String topicName;
	private TopicBean topic;

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

		ObjectName objectName = new ObjectName("org.apachemq:type=Broker,brokerName=" + jmxBrokerName
				+ ",destinationType=Topic,destinationName=" + topicName);

		TopicViewMBean topicMBean = MBeanServerInvocationHandler.newProxyInstance(connection, objectName,
				TopicViewMBean.class, true);
		topic = new TopicBean();
		topic.build(topicMBean);

		connector.close();

		return "success";
	}

	public TopicBean getTopic() {
		return topic;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
