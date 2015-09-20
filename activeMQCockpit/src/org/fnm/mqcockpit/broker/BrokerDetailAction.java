package org.fnm.mqcockpit.broker;

import java.util.ArrayList;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.fnm.mqcockpit.JMXAction;

public class BrokerDetailAction extends JMXAction {

	private String brokerName;
	private String brokerId;
	private String uptime;
	private long totalMessageCount;
	private long totalEnqueueCount;
	private long totalDequeueCount;
	private long totalConsumerCount;
	private long totalProducerCount;

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	public String execute() {

		if (!checkJMXSettings())
			return "missingJmxSettings";

		try {

			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + 1099 + "/jmxrmi");
			JMXConnector connector = JMXConnectorFactory.connect(url, null);
			connector.connect();

			MBeanServerConnection connection = connector.getMBeanServerConnection();
			ObjectName objectName = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost");

			BrokerViewMBean brokerViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection, objectName,
					BrokerViewMBean.class, true);

			brokerName = brokerViewMBean.getBrokerName();
			brokerId = brokerViewMBean.getBrokerId();
			uptime = brokerViewMBean.getUptime();
			totalMessageCount = brokerViewMBean.getTotalMessageCount();
			totalEnqueueCount = brokerViewMBean.getTotalEnqueueCount();
			totalDequeueCount = brokerViewMBean.getTotalDequeueCount();
			totalConsumerCount = brokerViewMBean.getTotalConsumerCount();
			totalProducerCount = brokerViewMBean.getTotalProducerCount();
			connector.close();

			return "success";

		} catch (Exception e) {
		    e.printStackTrace();
			errorMessages = new ArrayList<>(); 
			
			StringBuffer buffer = new StringBuffer(); 
			buffer.append("Could not establish the connection to broker "); 
			buffer.append(jmxBrokerName); 
			buffer.append(" on port "); 
			buffer.append(jmxPort); 
			errorMessages.add(buffer.toString()); 
			
			errorMessages.add("Exception is:");
			errorMessages.add(e.getClass().getSimpleName()); 
			errorMessages.add(e.getMessage()); 
			
			return "error"; 
		}

	}

	public String getBrokerName() {
		return brokerName;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public String getUptime() {
		return uptime;
	}

	public long getTotalMessageCount() {
		return totalMessageCount;
	}

	public long getTotalEnqueueCount() {
		return totalEnqueueCount;
	}

	public long getTotalDequeueCount() {
		return totalDequeueCount;
	}

	public long getTotalConsumerCount() {
		return totalConsumerCount;
	}

	public long getTotalProducerCount() {
		return totalProducerCount;
	}

}
