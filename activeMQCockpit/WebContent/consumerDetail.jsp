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
      <h2 class="sub-header">
        Consumer Detail:
      </h2>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Attribute</th>
              <th>Value</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>ID</td>
              <td><s:property value="consumer.clientId" /></td>
            </tr>
            <tr>
              <td>User Name</td>
              <td><s:property value="consumer.userName" /></td>
            </tr>
            <tr>
              <td>#Enqueued</td>
              <td><s:property value="consumer.enqueueCounter" /></td>
            </tr>
            <tr>
              <td>Is Network</td>
              <td><s:property value="consumer.network" /></td>
            </tr>
            <tr>
              <td>Is Slow</td>
              <td><s:property value="consumer.slowConsumer" /></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <p>&nbsp;</p>
</div>
<%@include file="footer.jsp"%>