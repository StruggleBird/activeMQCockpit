package org.fnm.mqcockpit;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class JMXAction {
	
	protected String jmxBrokerName; 
	protected String jmxPort;
	
	protected List<String> errorMessages;
	
	@SuppressWarnings("rawtypes")
	protected boolean checkJMXSettings(){
		
		Map session = (Map) ActionContext.getContext().get("session");
		jmxBrokerName = (String) session.get("brokerName");
		jmxPort = (String) session.get("jmxPort");
		
		if (jmxBrokerName == null || jmxPort == null ||jmxBrokerName.isEmpty() || jmxPort.isEmpty())
			return false; 
		else 
			return true; 
		
	}
	
	public List<String> getErrorMessages() {
		return errorMessages;
	}

}
