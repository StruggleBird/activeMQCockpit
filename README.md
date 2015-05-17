# activeMQCockpit
targeted as alternative (which it is not yet) for the activeMQ web console with struts and bootstrap

This in early developement state and still setup as an eclipse web project, running only with local activeMQ. 
Please note, that you need to set the broker name und jmx port to connect at the index page. Th eport has to match the settings defined in the management context in the activemq.xml file of your local installation. 

Currently the the following views are included: 
- broker detail 
- queues and topics, both with filter support
- queue messages and the message details

with actions: 
- set the name and jmx port of the broker to connect
- purge and delete a queue 
- delete a topic 
- delete a message
- post a new message to a queue, currently with limited properties settings only

