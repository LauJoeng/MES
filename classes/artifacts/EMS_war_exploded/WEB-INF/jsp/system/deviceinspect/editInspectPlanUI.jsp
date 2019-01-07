<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/deviceinspect/editInspectPlan.js">
</script>
<link href="${ctx}/js/date/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/js/date/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/js/date/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
	$(function(){
		$("#plantime").datetimepicker({
			language:"zh-CN",
			startDate:"2018-01-01",
			todayBtn:'linked',//显示当前时间且被选中
			todayHighlight:true,//高亮显示当前时间
			keyboardNavigation:true//是否是否允许通过方向键改变日期
		});
	})
</script>
<style type="text/css">
input{
   		font-size: 18px;
   		border-color: #4876FF;
   		color: black;
   		
     }  
	#addDevice tr td{
		border:1px solid black;
		text-align: center;
	}
	.removeDevice{
		text-decoration: underline;
		color:blue;
		cursor: pointer;
	}
	.dnumber{
		color:black;
	}
	.dname{
		color:black;
	}
</style>

</head>
<body>
 <form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/inspect/editInspectPlanEntity.shtml">
		<input type="hidden" class="form-control checkacc"
			value="${inspectPlan.id}" name="deviceInspectPlanFormMap.id" id="id">
	<div>
		<table   style="height:300px; border-collapse: collapse;font-size: 18px;">
			<tbody>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;计划名称:&nbsp;</td>
					<td><input class=".input" type="text" id="name" name="deviceInspectPlanFormMap.name" value="${inspectPlan.name}"/></td>		
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;计划时间:&nbsp;</td>
					<td><input type="text" name="deviceInspectPlanFormMap.plantime" id="" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" placeholder="请选择计划开始时间" value="${inspectPlan.plantime}"/></td>		
				</tr>	
				<tr>
					<td>&nbsp;&nbsp;&nbsp;点检人员:&nbsp;</td>
					<td><input type="text" style="color:black;width:73%;" name="deviceInspectPlanFormMap.inspectman" id="repairman"  readonly="readonly" value="${inspectPlan.inspectman}" /><input type="button"  id="selrpman" value="···"/></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;点检周期:&nbsp;</td>
					<td><input type="number" name="deviceInspectPlanFormMap.inspectcycle" id="inspectcycle" value="${inspectPlan.inspectcycle}"/>天</td>
				</tr>	
				<tr>
					<td>&nbsp;&nbsp;&nbsp;计划状态:&nbsp;</td>
					<td>
						<select  name="deviceInspectPlanFormMap.status" id="status" style="font-size: 18px;border: 2px solid blue;">
							<option value="1" selected="selected">启用</option>
							<option value="0">停用</option>
						</select>
					</td>
				</tr>	
				<tr style="display:none;">
					<td><input type="text" name="deviceInspectPlanFormMap.dname" id="dname" style="width: 180%;"/></td>		
					<td><input type="text" name="deviceInspectPlanFormMap.dnumber" id="dnumber" style="width: 180%;"/></td>						
				</tr>
			</tbody>
		</table>
		
	</div>
	<div style="height:150px;overflow: scroll;border:1px solid black;width:97%;margin:auto;">
		<table id="addDevice"  style="margin:auto;font-size: 18px;border:2px solid blue;width: 100%;border-collapse:collapse;">
			<thead>
				<tr>
					<td><input id="seldevice" type="button" value="点检设备"  style="border:1px solid grey;color:blue;font-weight: bold;"/></td>
					<td>设备编号</td>
					<td>设备名称</td>
					<td>设备型号</td>
				</tr>
			</thead>
			<tbody>	
					  
			</tbody>
		</table>
	</div>
		
	<input type="submit" value="保存" style="width: 80px;color:black;margin-left: 85%;margin-top: 5px;"/>
				
	</form>
</body>
</html>