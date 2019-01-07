<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/processManagement/componentDetails.js"></script>

	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				<label class="control-label"> 
				<span class="h4 font-thin v-middle" >查询条件</span></label>
				 <select id="selectName" name="selectName" class="input-medium ui-autocomplete-input" style="height: 25px;font-size: 14px;">
						<option id="module_code" selected="selected">组件条码</option>
						<option id="order_no">订单号</option>
	    		</select>
				 <input class="input-medium ui-autocomplete-input" id="select_number" name="module_code">
			</div>
			<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
			<a href="javascript:grid.exportData('/processManagement/componentexport.shtml')" class="btn btn-info" id="search">导出excel</a>
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

