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
      <h2 class="sub-header">Topics</h2>
      <!-- the filter form -->
      <s:form action="getFilteredTopics" method="post" theme="bootstrap">
        <div class="input-group col-sm-4 col-sm-offset-8">
          <span class="input-group-addon" id="basic-addon1">Filter</span>
          <s:textfield id="pwd" name="match" cssClass="form-control" value="%{match}" />
        </div>
      </s:form>
      <p>&nbsp;</p>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Name</th>
              <th>#Pending</th>
              <th>#Enqueued</th>
              <th>#Dequeued</th>
              <th>Consumer</th>
              <th>Producer</th>
              <th colspan="3">Action</th>
            </tr>
          </thead>
          <tbody>
            <s:iterator value="topics">
              <tr>
                <td><s:property value="name" /></td>
                <td><s:property value="size" /></td>
                <td><s:property value="enqueueCount" /></td>
                <td><s:property value="dequeueCount" /></td>
                <td><s:property value="consumerCount" /></td>
                <td><s:property value="producerCount" /></td>
                <td><a
                    href=<s:url action="topicDetail">
                    <s:param name="topicName"><s:property value="name" /></s:param>
                    </s:url>>Detail</a></td>
              </tr>
            </s:iterator>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>