<%@include file="header.jsp"%>
<!-- the bootstrap container -->
<div class="container">
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <div class="row">
    <%@ include file="sideMenu.jsp"%>
    <p>&nbsp;</p>
    <div class="col-sm-9">
      <h2 class="sub-header">Post Message</h2>
      <p>&nbsp;</p>
      <div class="col-sm-12">
        <!-- struts form -->
        <s:form action="postMessage" theme="bootstrap">
          <s:textfield name="message.queueName" label="Destination Queue *" />
          <s:textfield name="message.replyTo" label="Reply To Queue" />
          <s:textfield name="message.correlationId" label="Correlation Id" />
          <s:checkbox name="message.isPersistent" label="Is Persistent" />
          <s:checkbox name="message.isResponse" label="Is Response" />
          <s:checkbox name="message.isResponseRequired" label="Is Response Required" />
          <s:textarea name="message.text" label="Message Text"/>
          <s:submit cssClass="btn btn-default" />
        </s:form>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>