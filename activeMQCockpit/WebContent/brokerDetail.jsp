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
      <h2 class="sub-header">Broker Detail</h2>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>&nbsp;</th>
              <th>&nbsp;</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Name</td>
              <td><s:property value="brokerName" /></td>
            </tr>
            <tr>
              <td>ID</td>
              <td><s:property value="brokerId" /></td>
            </tr>
            <tr>
              <td>Uptime</td>
              <td><s:property value="uptime" /></td>
            </tr>
            <tr>
              <td>Pending Message Count</td>
              <td><s:property value="totalMessageCount" /></td>
            </tr>
            <tr>
              <td>Enqueued Message Count</td>
              <td><s:property value="totalEnqueueCount" /></td>
            </tr>
            <tr>
              <td>Dequeued Message Count</td>
              <td><s:property value="totalDequeueCount" /></td>
            </tr>
            <tr>
              <td>Consumer Count</td>
              <td><s:property value="totalConsumerCount" /></td>
            </tr>
            <tr>
              <td>Producer Count</td>
              <td><s:property value="totalProducerCount" /></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>