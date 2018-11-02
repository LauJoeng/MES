<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/10/28
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<!-- 设备点检 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/deviceinspect/waitInspect.js"></script>
<div class="m-b-md">

</div>
<header class="panel-heading">
    <div class="doc-buttons">
        <c:forEach items="${res}" var="key">
            ${key.description}
        </c:forEach>
    </div>
</header>
<div class="table-responsive">
    <div id="paging" class="pagclass"></div>
</div>

<div class="table-responsive">
    <div id="paging2" class="pagclass"></div>
</div>

