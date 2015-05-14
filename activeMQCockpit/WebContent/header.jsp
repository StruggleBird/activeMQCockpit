<%@page import="org.apache.activemq.broker.jmx.BrokerMBeanSupport"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Active MQ Cockpit</title>
</head>
<body>
  <!-- the top navbar -->
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
          aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.jsp">Active MQ Cockpit</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href=<s:url action="brokerDetail"/>>Broker</a></li>
          <li><a href=<s:url action="getFilteredQueues"/>>Queues</a></li>
          <li><a href=<s:url action="getFilteredTopics"/>>Topics</a></li>
        </ul>
      </div>
    </div>
  </nav>