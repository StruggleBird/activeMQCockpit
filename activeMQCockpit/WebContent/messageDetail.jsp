<%@include file="header.jsp"%>
<!-- the bootstrap container -->
<div class="container">
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <div class="row">
    <%@ include file="sideMenu.jsp"%>
    <div class="col-sm-9">
      <h2 class="sub-header">Message Detail</h2>
      <div class="btn-group col-sm-2 col-sm-offset-9" role="group">
        <button type="button" class="btn btn-default btn-danger" data-toggle="modal" data-target="#deleteModal">Delete
          Message</button>
      </div>
      <p>&nbsp;</p>
      <div class="table-responsive col-sm-12">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Attribute</th>
              <th>Value</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Class</td>
              <td><s:property value="message.className" /></td>
            </tr>
            <tr>
              <td>Command Id</td>
              <td><s:property value="message.commandId" /></td>
            </tr>
            <tr>
              <td>Correlation Id</td>
              <td><s:property value="message.correlationId" /></td>
            </tr>
            <tr>
              <td>Reply To</td>
              <td><s:property value="message.replyTo" /></td>
            </tr>
            <tr>
              <td>Timestamp</td>
              <td><s:property value="message.timestamp" /></td>
            </tr>
            <tr>
              <td>Priority</td>
              <td><s:property value="message.jmsPriority" /></td>
            </tr>
            <tr>
              <td>Is Persistent</td>
              <td><s:property value="message.persistent" /></td>
            </tr>
            <tr>
              <td>Is Response</td>
              <td><s:property value="message.response" /></td>
            </tr>
            <tr>
              <td>Is Response Required</td>
              <td><s:property value="message.responseRequired" /></td>
            </tr>
            <tr>
              <td>Is Expired</td>
              <td><s:property value="message.expired" /></td>
            </tr>
          </tbody>
        </table>
        <!-- the properties -->
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Property</th>
              <th>Value</th>
            </tr>
          </thead>
          <tbody>
            <s:iterator value="message.properties.entrySet()" var="entry">
              <tr>
                <td><s:property value="key" /></td>
                <td><s:property value="value" /></td>
              </tr>
            </s:iterator>
          </tbody>
        </table>
        <!-- the content -->
        <p>&nbsp;</p>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">Text</h3>
          </div>
          <div class="panel-body">
            <p>
              <s:property value="message.text" />
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<p>&nbsp;</p>
<!-- Delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
  aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">Delete Message</h4>
      </div>
      <div class="modal-body">
        <p>This action will delete the message.</p>
        <p>If you want that, press the delete button.</p>
        <p>If not, just Cancel.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a
          href=<s:url action="deleteMessage">
            <s:param name="queueName">
              <s:property value="message.queueName" />
            </s:param>
            <s:param name="jmsMessageId">
              <s:property value="message.jmsMessageId" />
            </s:param>
        </s:url>
          class="btn btn-danger" role="button">Delete</a>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>