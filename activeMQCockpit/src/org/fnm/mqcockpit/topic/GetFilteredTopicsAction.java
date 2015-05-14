package org.fnm.mqcockpit.topic;

import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.TopicViewMBean;

public class GetFilteredTopicsAction {

	private List<TopicBean> topics = new ArrayList<>();

	private String match;

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() throws Exception {

		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:2011/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(url, null);
		connector.connect();

		MBeanServerConnection connection = connector.getMBeanServerConnection();
		ObjectName name = new ObjectName("org.apachemq:type=Broker,brokerName=localhost");
		BrokerViewMBean mbean = MBeanServerInvocationHandler
				.newProxyInstance(connection, name, BrokerViewMBean.class, true);
		for (ObjectName objectName : mbean.getTopics()) {
			TopicViewMBean mBean = MBeanServerInvocationHandler.newProxyInstance(connection, objectName,
					TopicViewMBean.class, true);
			String topicName = mBean.getName();
			if (match == null || topicName.contains(match)) {
				TopicBean topicsBean = new TopicBean();
				topicsBean.build(mBean);
				topics.add(topicsBean);
			}
		}
		connector.close();
		return "success";
	}

	public List<TopicBean> getTopics() {
		return topics;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public String getMatch() {
		return match;
	}

}
