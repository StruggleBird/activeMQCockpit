package org.fnm.mqcockpit.queue;

import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;

public class GetFilteredQueuesAction {

	private List<QueueBean> queues = new ArrayList<>();
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
		BrokerViewMBean mbean = MBeanServerInvocationHandler.newProxyInstance(connection, name,
				BrokerViewMBean.class, true);

		for (ObjectName objectName : mbean.getQueues()) {
			QueueViewMBean queueMBean = MBeanServerInvocationHandler.newProxyInstance(connection,
					objectName, QueueViewMBean.class, true);
			String queueName = queueMBean.getName();
			if (match == null || queueName.contains(match)) {
				QueueBean queueDetail = new QueueBean();
				queueDetail.build(queueMBean);
				queues.add(queueDetail);
			}
		}
		connector.close();

		return "success";
	}

	public List<QueueBean> getQueues() {
		return queues;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public String getMatch() {
		return match;
	}

}
