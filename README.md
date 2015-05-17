# activeMQCockpit
targeted as alternative (which it is definitely not yet) for the activeMQ web
console with struts2 and bootstrap.

Started as a project to ease the use of active MQ for integration testing, since
the active MQ web console turned out to be not very handy for the purpose of
integration testing.

This is still in an early developement state and running only with local activeMQ
and has limited error handling. Please note, that you need to set the broker name
und jmx port to connect to at the start page. Both must match the settings
defined in the management context in the activemq.xml file of your local
installation.

Currently the the following views are included:
- broker detail
- queues and topics, both with filter
- queue and topic details
- queue messages and message details
- consumers and consumer details

with actions:
- set the name and jmx port of the broker to connect (on localhost)
- purge and delete a queue
- delete a topic
- delete a message
- post message to queue, currently with limited properties settings only

