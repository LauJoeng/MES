<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/11/01
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<%@include file="/common/common.jspf"%>
	<script type="text/javascript" src="${ctx}/js/system/deviceinspect/excuPlan.js"></script>
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
                keyboardNavigation:true//是否是否允许通过方向键改变日期
            });
            $("#endtime").datetimepicker({
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
	  action="${ctx}/inspect/executeWaitInspect.shtml" style="height:900px;">
	<input type="hidden" class="form-control checkacc"
		   name="deviceInspectRecordFormMap.waitInspectPlanId"	value="${waitInspectPlan.id}"  id="id">
	<div>
		<table   style="height:500px; border-collapse: collapse;margin:auto;font-size: 18px;">
			<tbody>
			<tr>
				<td>设备类别：</td>
				<td><input class=".input" type="text"  value="${waitInspectPlan.dtype}" readonly="readonly" style="width: 100%;"/></td>
				<td>&nbsp;&nbsp;&nbsp;设备编号：</td>
				<td><input type="text" name="deviceInspectRecordFormMap.dnumber"  value="${waitInspectPlan.dnumber}" readonly="readonly" style="width: 100%;"/></td>

			</tr>
			<tr>
				<td>设备名称：</td>
				<td><input type="text"  id="dname" name="deviceInspectRecordFormMap.dname"  value="${waitInspectPlan.dname}" readonly="readonly" style="width: 100%;"/></td>
				<td>&nbsp;&nbsp;&nbsp;规格型号：</td>
				<td><input type="text"  value="${waitInspectPlan.standard}" readonly="readonly" style="width: 100%;"/></td>

			</tr>
			<tr>
				<td>所在部门：</td>
				<td><input type="text"value="${waitInspectPlan.userdept}" readonly="readonly" style="width: 100%;"/></td>
				<td>&nbsp;&nbsp;&nbsp;<input type="button" id="seldevice" value="选择设备"  style="font-size: 17px;color:grey;border:0;" disabled="disabled"/></td>
			</tr>
			<tr>
				<td>维护人员：</td>
				<td><input type="text" style="color:black;"  id="inspectman" name="deviceInspectRecordFormMap.inspectman"  value="${waitInspectPlan.inspectman}" readonly="readonly"/><input type="button"  id="inspectmanbtn" value="···"/></td>
				<td>&nbsp;&nbsp;&nbsp;计划名称：</td>
				<td><input type="text"  readonly="readonly" id="inspecname"   value="${waitInspectPlan.name}"/></td>
			</tr>

			<tr>
				<td style="vertical-align: top;">点检项目：</td>
				<td><textarea readonly="readonly" style="font-size: 18px;width: 240%;height: 150px;color:grey;line-height:18px;
        		border:2px solid #4876FF;" id="infoarea">${waitInspectPlan.inspectinfo}</textarea></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">点检标准：</td>
				<td><textarea readonly="readonly" style="font-size: 18px;width: 240%;height: 150px;color:grey;line-height:18px;
        		border:2px solid #4876FF;" id="rulearea" >${waitInspectPlan.inspectrule}</textarea></td>
			</tr>
			<tr>
				<td>开始时间：</td>
				<td><input id="starts"  name="deviceInspectRecordFormMap.starttime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"type="text"  style="width: 100%;color:black;"/></td>
				<td>&nbsp;&nbsp;&nbsp;结束时间：</td>
				<td><input id="stops" name="deviceInspectRecordFormMap.endtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text"  style="width: 100%;color:black;"/></td>
				<td><input type="number" name="deviceInspectRecordFormMap.inspectfee" id="maintainfee" style="display: none;"></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">点检过程：</td>
				<td><textarea style="font-size: 18px;width: 240%;height: 150px;color:black;line-height:18px;
        		border:2px solid #4876FF;" name="deviceInspectRecordFormMap.inspectinfo" id="inspectinfo"></textarea></td>
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