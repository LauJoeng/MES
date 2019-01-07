<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/devicemanagement/deviceStorageList.js"></script>
<%--<div class="m-b-md">
	<form class="form-inline" role="form" id="searchForm"
		  name="searchForm">
		<div class="form-group">
			<label class="control-label"> <span
					class="h4 font-thin v-middle">设备编号:</span></label> <input
				class="input-medium ui-autocomplete-input" id="number"
				name="deviceFormMap.number">
		</div>
		<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
		<a href="javascript:grid.exportData('/devicem/export.shtml')" class="btn btn-info" id="search">导出excel</a>
	</form>
</div>--%>
<div style="margin-left: 6px;">
	<form action="#" id="form">
		<table>
			<tr>
				<td class="tdh" style="padding-left: 4px;">数量：</td>
				<td style="padding-left: 4px;">
					<select name="numIs"  style="width: 170px;height: 22px;font-size: 14px;border:2px solid blue;border-color: #4876FF;">
						<option value="2">所有</option>
						<option selected="selected" value="1">不等于0</option>
						<option value="0">等于0</option>
					</select>
				</td>

				<td class="tdh" style="padding-left: 4px;">状态：</td>
				<td style="padding-left: 4px;">
					<select name=pState  style="width: 170px;height: 22px;font-size: 14px;border:2px solid blue;border-color: #4876FF;">
						<option selected="selected" value="1">合格品</option>
						<option  value="2">废品</option>
						<option value="4">待检品</option>
						<option value="5">不合格品</option>
					</select>
				</td>
				<td class="tdh" style="padding-left: 4px;">采购合同号：</td>
				<td style="padding-left: 4px;">
					<input name="luHao" type="text" style="width: 170px;height: 22px;"/>
				</td>
			</tr>
			<tr>

				<td class="tdh" style="padding-left: 4px;">物料代号：</td>
				<td style="padding-left: 4px;">
					<input name="itemid" type="text" style="width: 170px;height: 22px;"/>
				</td>
				<td class="tdh" style="padding-left: 4px;">批号：</td>
				<td style="padding-left: 4px;">
					<input name="itemBatch" type="text" style="width: 170px;height: 22px;"/>
				</td>

				<td class="tdh" style="padding-left: 4px;">供应商：</td>
				<td style="padding-left: 4px;">
					<input name="provID" list="provIDs" type="text" style="width: 170px;height: 22px;" onchange="provIDSelect()"/>
					<datalist id="provIDs">
						<option value="请输入供应商ID或名称" selected="selected"></option>
						<select id="provIDs_select">
						</select>
					</datalist>
				</td>
				<td rowspan="2" style="padding-left: 4px;">
					<input type="button" id="button" value="查询" style="height:22px;width:65px;color:blue;font-weight:bold;"/>
				</td>
				<td rowspan="2" style="padding-left: 4px;">
					<input type="button" id="button_export" value="导出" style="height:22px;width:65px;color:blue;font-weight:bold;"/>
				</td>
				<td id="totalNums" rowspan="2" style="padding-left: 60px;color:red;font-weight:bold;font-size:20px;">

				</td>

			</tr>
		</table>
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
