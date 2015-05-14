
<%@include file="header.jsp"%>
<!-- the bootstrap container -->
<div class="container">
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <div class="row">
    <%@ include file="sideMenu.jsp"%>
    <div class="col-sm-9 col-md-9 col">
      <h2 class="sub-header">Broker settings</h2>
      <p>&nbsp;</p>
      <p>Please set the broker name and the jmx port to contact the broker.</p>
      <p>&nbsp;</p>
      <!-- struts form -->
      <s:form action="postBrokerSettings" theme="bootstrap">
        <s:textfield name="brokerName" label="Broker Name*" />
        <s:textfield name="jmxPort" label="JMS Port*" />
        <s:submit cssClass="btn btn-default" />
      </s:form>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>
