<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/common/common.jspf"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/system/devicerepair/selDevicelist.js"></script>
<div class="m-b-md">
	<form class="form-inline" role="form" id="searchForm" name="searchForm">
		<div class="form-group">
			<label class="control-label"> <span
				class="h4 font-thin v-middle">设备名称:</span></label> <input
				class="input-medium ui-autocomplete-input" id="dname"
				name="deviceFormMap.dname">
		</div>
		<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
	</form>
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
<footer class="panel-footer text-right bg-light lter">
	<button type="button" id="button" class="btn btn-success btn-s-xs">保存</button>
</footer>
