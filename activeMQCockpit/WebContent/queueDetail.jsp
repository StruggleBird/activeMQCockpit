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
        Queue Detail of
        <s:property value="queue.name" />
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
              <td>Name</td>
              <td><s:property value="queue.name" /></td>
            </tr>
            <tr>
              <td>Pending messages</td>
              <td><s:property value="queue.size" /></td>
            </tr>
            <tr>
              <td>#Enqueued</td>
              <td><s:property value="queue.enqueueCount" /></td>
            </tr>
            <tr>
              <td>#Dequeued</td>
              <td><s:property value="queue.dequeueCount" /></td>
            </tr>
            <tr>
              <td>#Expired</td>
              <td><s:property value="queue.expiredCount" /></td>
            </tr>
            <tr>
              <td>#Consumer</td>
              <td><s:property value="queue.consumerCount" /></td>
            </tr>
            <tr>
              <td>#Producer</td>
              <td><s:property value="queue.producerCount" /></td>
            </tr>
            <tr>
              <td>Average Blocked Time</td>
              <td><s:property value="queue.avarageBlockedTime" /></td>
            </tr>
            <tr>
              <td>Average Enqueued Time</td>
              <td><s:property value="queue.averageEnqueueTime" /></td>
            </tr>
            <tr>
              <td>Cursor Memory Usage</td>
              <td><s:property value="queue.cursorMemoryUsage" /></td>
            </tr>
            <tr>
              <td>Cursor Usage %</td>
              <td><s:property value="queue.cursorPercentUsage" /></td>
            </tr>
            <tr>
              <td>Max Message Size</td>
              <td><s:property value="queue.maxMessageSize" /></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <p>&nbsp;</p>
  <div class="col-sm-4 col-sm-offset-8 col-md-4 col-md-offset-8">
    <div class="btn-group" role="group">
      <button type="button" class="btn btn-default btn-warning" data-toggle="modal" data-target="#purgeModal">Purge
        Queue</button>
      <button type="button" class="btn btn-default btn-danger" data-toggle="modal" data-target="#deleteModal">Delete
        Queue</button>
    </div>
  </div>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
<!-- Purge Modal -->
<div class="modal fade" id="purgeModal" tabindex="-1" role="dialog" aria-labelledby="purgeModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">Purge Queue</h4>
      </div>
      <div class="modal-body">
        <p>This will remove all pending messages from the queue.</p>
        <p>If you want that, press the purge button.</p>
        <p>If not, just Cancel.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a
          href=<s:url action="purgeQueue">
            <s:param name="queueName">
              <s:property value="queue.name" />
            </s:param>
        </s:url>
          class="btn btn-warning" role="button">Purge</a>
      </div>
    </div>
  </div>
</div>
<!-- Delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
  aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">Delete Queue</h4>
      </div>
      <div class="modal-body">
        <p>This action will delete the queue.</p>
        <p>If you want that, press the delete button.</p>
        <p>If not, just Cancel.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a
          href=<s:url action="deleteQueue">
            <s:param name="queueName">
              <s:property value="queue.name" />
            </s:param>
        </s:url>
          class="btn btn-danger" role="button">Delete</a>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>