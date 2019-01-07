<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/deviceinspect/addInspectInfo.js">
</script>
<script type="text/javascript" src="${ctx}/js/date/DataPicker.js"></script>
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
		color:red;
	}
</style>

</head>
<body>
 <form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/inspect/addInspectInfoEntity.shtml">	
	<div>
		<table   style="height:300px; border-collapse: collapse;font-size: 18px;">
			<tbody>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;点检条码:&nbsp;</td>
					<td><input class=".input" type="text" readonly="readonly" value="<自动生成>" style="width: 180%;color:grey;"/></td>		
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;点检项目:&nbsp;</td>
					<td><input type="text" name="deviceInspectInfoFormMap.inspectinfo" id="inspectinfo" placeholder="测量设备运行温度℃" style="width: 180%;"/></td>		
				</tr>	
				<tr>
					<td>&nbsp;&nbsp;&nbsp;点检参考:&nbsp;</td>
					<td><input type="text" name="deviceInspectInfoFormMap.inspectrule" id="inspectrule" placeholder="0-30℃为正常温度" style="width: 180%;"/></td>		
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;点检备注:&nbsp;</td>
					<td><input type="text" name="deviceInspectInfoFormMap.remark" id="inspectremark" style="width: 180%;"/></td>
				</tr>	
				<tr style="display:none;">
				<td><input type="text" name="deviceInspectInfoFormMap.applydevice" id="applydevice" style="width: 180%;"/></td>				
				</tr>
			</tbody>
		</table>
		
	</div>
	<div style="height:150px;overflow: scroll;border:1px solid black;width:97%;margin:auto;">
		<table id="addDevice"  style="margin:auto;font-size: 18px;border:2px solid blue;width: 100%;border-collapse:collapse;">
			<thead>
				<tr>
					<td><input id="seldevice" type="button" value="适用设备"  style="border:1px solid grey;color:blue;font-weight: bold;"/></td>
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