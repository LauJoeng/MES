<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/processManagement/process.js"></script>

	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				<label class="control-label"> 
				<span class="h4 font-thin v-middle" >工序</span></label>
				 <!-- <input class="input-medium ui-autocomplete-input" id="Spec" name="processName"> -->
				 <select id="processName" name="processName" onchange="processNameChange()" class="input-medium ui-autocomplete-input" style="width: 100px;height: 25px;font-size: 14px;">
						<option id="CY">层压</option>
						<option id="EL1">前道EL</option>
						<option id="EL3">后道EL</option>
	    		</select> 
	    		<div   class='equipCode' style="display:inline-block;">
				 <span class="h4 font-thin v-middle" class='equipCode'>设备号:</span></label>
				 <input class="input-medium ui-autocomplete-input" class='equipCode' id="equipCode" name="equipCode" style="width: 100px;display:inline-block;height: 25px;">
				</div>
				<!--  <br/> -->
				<div  style="display:none " class='order_no' >
				  <span class="h4 font-thin v-middle" >订单号:</span>
				 <input class="input-medium ui-autocomplete-input" id="order_no" name="order_no" style="width: 100px;display:inline-block;height: 25px;">
				</div>
				 <span class="h4 font-thin v-middle" >开始时间:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="begintime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="begintime">
				 <span class="h4 font-thin v-middle" >结束时间:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="endtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="endtime">
			</div>
			<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
			<a href="javascript:grid.exportData('/processManagement/processExport.shtml')" class="btn btn-info" id="search">导出excel</a>
			
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

