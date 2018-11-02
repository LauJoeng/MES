<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/repairmanage/addPlan.js">
</script>
<script type="text/javascript" src="${ctx}/js/date/DataPicker.js"></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
input{
   		font-size: 16px;
   		border-color: #4876FF;
   		color: gray;
     }
</style>

</head>
<body>
 <form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/repairmanage/addPlanEntity.shtml">	
	<div>
		<table   style="height:450px; border-collapse: collapse;margin:auto;font-size: 18px;">
			<tbody>
				<tr>
					<td>设备类别：</td>
					<td><input class=".input" type="text" name="repairPlanFormMap.dtype" id="dtype" readonly="readonly" style="width: 100%;"/></td>
					<td>&nbsp;&nbsp;&nbsp;设备编号：</td>
					<td><input type="text" name="repairPlanFormMap.dnumber" id="dnumber" readonly="readonly" style="width: 100%;"/></td>
					
				</tr>
				<tr>
					<td>设备名称：</td>
					<td><input type="text" name="repairPlanFormMap.dname" id="dname" readonly="readonly" style="width: 100%;"/></td>
					<td>&nbsp;&nbsp;&nbsp;规格型号：</td>
					<td><input type="text" name="repairPlanFormMap.dstandard" id="dstandard" readonly="readonly" style="width: 100%;"/></td>
				</tr>
				<tr>
					<td>所在部门：</td>
					<td><input type="text" name="repairPlanFormMap.usedept" id="usedept" readonly="readonly" style="width: 100%;"/></td>
					<td>&nbsp;&nbsp;&nbsp;<input type="button" id="seldevice" value="选择设备"  style="font-size: 17px;color:black;"/></td>
				</tr>
				<tr>
					<td>维护人员：</td>
					<td><input type="text" name="repairPlanFormMap.repairman" id="repairman" readonly="readonly"/><input type="button"  id="selrpman" value="···"/></td>
					<td>&nbsp;&nbsp;&nbsp;维护周期：</td>
					<td><input type="number" name="repairPlanFormMap.repaircycle" id="repaircycle"/>天</td>
				</tr>
				<tr>
					<td>计划时间：</td>
					<td><input id="plantime" name="repairPlanFormMap.plantime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" style="width: 100%;"/></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">计划描述：</td>
					<td><textarea style="font-size: 18px;width: 240%;height: 150px;line-height:18px;
        		border:2px solid #4876FF;" id="planinfo" name="repairPlanFormMap.planinfo"></textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存" style="width: 80px;color:black;margin-left: 625%;"/></td>
				</tr>
			</tbody>
		</table>
		
	</div>
	</form>
</body>
</html>