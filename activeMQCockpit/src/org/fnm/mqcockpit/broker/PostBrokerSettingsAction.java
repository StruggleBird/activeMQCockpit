package org.fnm.mqcockpit.broker;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;


public class PostBrokerSettingsAction {
	
	private String brokerName = "localhost"; 
	private String jmxPort = "2011";

	/**
	 * called, when the user performs a UI action (see struts.xml)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String execute() throws Exception {
		
		// add settings to the session
		Map session = (Map) ActionContext.getContext().get("session");
		session.put("brokerName", brokerName);
		session.put("jmxPort", jmxPort);
		
		return "success";
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getJmxPort() {
		return jmxPort;
	}

	public void setJmxPort(String jmxPort) {
		this.jmxPort = jmxPort;
	}

}
