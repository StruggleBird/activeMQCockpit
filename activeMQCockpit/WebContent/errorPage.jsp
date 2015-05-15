
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
      <h2 class="sub-header">Error:</h2>
      <p>&nbsp;</p>
      <s:iterator value="errorMessages">
        <p>
          <s:property />
        </p>
      </s:iterator>
      <p>&nbsp;</p>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>
