# activeMQCockpit
targeted as alternative (which it is not yet) for the activeMQ web console with struts and bootstrap

This in early developement state and still setup as an eclipse web project, tested only with local activeMQ. 
Please note, that it currently requires the broker name to be localhost and the management context in activemq.xml 
to be configured as: 

connectorPort="2011" jmxDomainName="org.apachemq"

Currently the the following views are included: 
- broker detail 
- queues and topics, both with filter support
- queue messages and the message details
with actions: 
- purge and delete a queue 
- delete a topic 
- post a new message to a queue, currently with limited properties settings only

