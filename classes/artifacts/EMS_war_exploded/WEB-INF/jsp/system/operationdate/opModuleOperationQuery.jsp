<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<%-- <title>员工操作数据查询</title>
<link href="${pageContext.request.contextPath}/js/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.css" rel="stylesheet"> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
 --%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/operationdate/opModuleOperationQuery.js"></script>

	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				<label class="control-label"> 
				<span class="h4 font-thin v-middle" style="width: 80px;display:inline-block;height: 25px;" >操作时间:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="begintime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="begintime">
				 <span class="h4 font-thin v-middle" style="width: 60px;display:inline-block;height: 25px;" >到:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="endtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="endtime">
				 <span class="h4 font-thin v-middle" style="width: 60px;display:inline-block;height: 25px;">订单号:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="order_no" name="order_no">
				  <br/>
				 <span class="h4 font-thin v-middle" style="width: 80px;display:inline-block;height: 25px;">组件条码:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="module_code" name="module_code">
				 <span class="h4 font-thin v-middle" style="width: 60px;display:inline-block;height: 25px;">员工号:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="op" name="op">
				  
				 
				
				 
				<!-- <br/> -->
				 
			</div>
			<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
			<a href="javascript:grid.exportData('/operationData/selectOpModuleDataExport.shtml')" class="btn btn-info" id="search">导出excel</a>
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


