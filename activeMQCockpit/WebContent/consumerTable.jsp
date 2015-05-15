<%@include file="header.jsp"%>
<!-- the bootstrap container -->
<div class="container">
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <div class="row">
    <%@ include file="sideMenu.jsp"%>
    <div class="col-sm-9 col-md-9">
      <h2 class="sub-header">
        Consumer of queue:
        <s:property value="queueName" />
      </h2>
      <p>&nbsp;</p>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>ID</th>
              <th>User</th>
              <th>#Enqueued</th>
              <th>Network</th>
              <th>Slow</th>
              <th>ConnectionId</th>
              <th colspan="3">Action</th>
            </tr>
          </thead>
          <tbody>
            <s:iterator value="consumer">
              <tr>
                <td><s:property value="clientId" /></td>
                <td><s:property value="userName" /></td>
                <td><s:property value="enqueueCounter" /></td>
                <td><s:property value="network" /></td>
                <td><s:property value="slowConsumer" /></td>
                <td><s:property value="connectionId" /></td>
                <td><a
                    href=<s:url action="consumerDetail">
                    <s:param name="queueName">
                      <s:property value="queueName" />
                    </s:param>
                    <s:param name="clientId">
                      <s:property value="clientId" />
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