<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/processManagement/orderProgressSelect.js"></script>
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				<label class="control-label"> <span
					class="h4 font-thin v-middle">订单号:</span></label> <input
					class="input-medium ui-autocomplete-input" id="order_no"
					name="order_no">
					
					<label class="control-label"> <span
					class="h4 font-thin v-middle">组件条码:</span></label> <input
					class="input-medium ui-autocomplete-input" id="module_code"
					name="module_code">
			</div>
			<!-- <td rowspan="2" style="padding-left: 4px;">
					<input type="button" id="search" value="查询" class="btn btn-default" />
			</td> -->
			<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
			<a href="javascript:grid.exportData('/processManagement/OrderProgressExport.shtml')" class="btn btn-info" id="search">导出excel</a>
		
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
	

