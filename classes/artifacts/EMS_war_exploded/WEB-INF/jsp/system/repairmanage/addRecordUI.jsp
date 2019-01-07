<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/repairmanage/excuPlan.js">
</script>
<link href="${ctx}/js/date/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/js/date/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/js/date/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function(){
		$("#plantime").datetimepicker({
			language:"zh-CN",
			startDate:"2018-01-01",
			todayBtn:'linked',//显示当前时间且被选中
			todayHighlight:true,//高亮显示当前时间
			keyboardNavigation:true,//是否是否允许通过方向键改变日期
			format:'yyyy-mm-dd hh:ii'
		});
		$("#endtime").datetimepicker({
			language:"zh-CN",//语言设置
			startDate:"2018-01-01",
			todayBtn:'linked',//显示当前时间且被选中
			todayHighlight:true,//高亮显示当前时间
			keyboardNavigation:true,//是否是否允许通过方向键改变日期
			format:'yyyy-mm-dd hh:ii'
		});
	})
</script>
<style type="text/css">
input{
   		font-size: 16px;
   		border-color: #4876FF;
   		color: grey;
   		vertical-align: middle;
     }
.addBt{
	background-color:blue;
	vertical-align: middle;
}
#addPart tr td{
	border:1px solid black;
	text-align: center;
}
#addConsumable tr td{
	border:1px solid black;
	text-align: center;
}
.removePart{
	text-decoration: underline;
	color:blue;
	cursor: pointer;
}
.removeConsumable{
	text-decoration: underline;
	color:blue;
	cursor: pointer;
}
.partPrice{color:blue;}

.consumablePrice{color:blue;}

.partNumber{
	width:45px;
	border:1px solid grey;
	color:red;
}
.consumableNumber{
	color:red;
	width:45px;
	border:1px solid grey;
}
</style>

</head>
<body>
 <form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/maintain/excuPlanEntity.shtml" style="height:900px;">	
		<input type="hidden" class="form-control checkacc"
			value="${repairPlan.id}"  id="id">
	<div>
		<table   style="height:400px; border-collapse: collapse;margin:auto;font-size: 18px;">
			<tbody>
				<tr>
					<td>设备类别：</td>
					<td><input class=".input" type="text" id="dtype"  readonly="readonly" style="width: 100%;"/></td>
					<td>&nbsp;&nbsp;&nbsp;设备编号：</td>
					<td><input type="text"  id="dnumber" readonly="readonly" style="width: 100%;"/></td>
					
				</tr>
				<tr>
					<td>设备名称：</td>
					<td><input type="text" name="maintainRecordFormMap.dname" id="dname" value="${repairPlan.dname}" readonly="readonly" style="width: 100%;"/></td>
					<td>&nbsp;&nbsp;&nbsp;规格型号：</td>
					<td><input type="text"  id="dstandard" readonly="readonly" style="width: 100%;"/></td>
					
				</tr>
				<tr>
					<td>所在部门：</td>
					<td><input type="text" id="usedept" readonly="readonly" style="width: 100%;"/></td>
					<td>&nbsp;&nbsp;&nbsp;<input type="button" id="seldevice" value="选择设备"  style="font-size: 15px;color:black"/></td>
				</tr>
				<tr>
					<td>维护人员：</td>
					<td><input type="text" style="color:black;" name="maintainRecordFormMap.repairman" id="repairman" value="${repairPlan.repairman}" readonly="readonly"/><input type="button"  id="selrpman" value="···"/></td>
					<td style="display: none">&nbsp;&nbsp;&nbsp;维护周期：</td>
					<td><input type="number" style="display: none" readonly="readonly" id="repaircycle" value="${repairPlan.repaircycle}"/></td>
				</tr>
				<tr>
					<td>开始时间：</td>
					<td><input id="starts" name="maintainRecordFormMap.starttime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="点击选择开始时间" readonly="readonly" type="text" style="width: 100%;color:black;"/></td>
					<td>&nbsp;&nbsp;&nbsp;结束时间：</td>
					<td><input id="stops" name="maintainRecordFormMap.endtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="点击选择结束时间" readonly="readonly" type="text"  style="width: 100%;color:black;"/></td>
					<td><input type="number" name="maintainRecordFormMap.maintainfee" id="maintainfee" style="display: none;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">维护过程：</td>
					<td><textarea style="font-size: 18px;width: 235%;height: 150px;color:black;line-height:18px;
        		border:2px solid #4876FF;" id="workinfo" name="maintainRecordFormMap.workinfo"></textarea></td>
				</tr>
				
			</tbody>
		</table>
	</div>
	
	<div style="height:150px;overflow: scroll;border:1px solid black;width:81%;margin:auto;">
		<table id="addPart"  style="margin:auto;font-size: 18px;border:2px solid blue;width: 100%;border-collapse:collapse;">
			<thead>
				<tr>
					<td><input id="addPartBt" type="button" value="增加配件"  style="border:1px solid grey;color:blue;font-weight: bold;"/></td>
					<td>编号</td>
					<td>名称</td>
					<td>型号</td>
					<td>价格</td>
					<td>数量</td>
				</tr>
			</thead>
			<tbody>	
					  
			</tbody>
		</table>
	</div>
	
	<div style="height:150px;overflow: scroll;border:1px solid black;width:81%;margin:auto;">
		<table id="addConsumable"  style="margin:auto;font-size: 18px;border:2px solid blue;width: 100%; border-collapse:collapse;">
			<thead>
				<tr>
					<td><input id="addConsumableBt" type="button" value="增加消耗品"  style="border:1px solid grey;color:blue;font-weight: bold;"/></td>
					<td>名称</td>
					<td>单位</td>
					<td>价格</td>
					<td>型号</td>
					<td>数量</td>
				</tr>
			</thead>
			<tbody>			  
			</tbody>
		</table>
		
	</div>
	<input type="submit" value="保存" style="width: 80px;color:black;margin-left: 80.5%;margin-top: 10px;"/>
 </form>
</body>
</html>