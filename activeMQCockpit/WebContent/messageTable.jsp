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
      <h2 class="sub-header">Messages in queue: <s:property value="queueName" /></h2>
      <p>&nbsp;</p>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Class</th>
              <th>Correlation ID</th>
              <th>Reply To</th>
              <th>Timestamp</th>
              <th>Persistent</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <s:iterator value="messages">
              <tr>
                <td><s:property value="className" /></td>
                <td><s:property value="correlationId" /></td>
                <td><s:property value="replyTo" /></td>
                <td><s:property value="timestamp" /></td>
                <td><s:property value="persistent" /></td>
                <td><a href=
                    <s:url action="messageDetail">
                    <s:param name="queueName">
                      <s:property value="queueName" />
                    </s:param>
                    <s:param name="commandId">
                      <s:property value="commandId" />
                    </s:param>
                    </s:url>>Detail</a>
                </td>
              </tr>
            </s:iterator>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>