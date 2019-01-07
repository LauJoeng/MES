<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/devicerepair/addDocument.js"></script>
<script type="text/javascript"src="${ctx}/js/system/devicerepair/add.js"></script>
<style type="text/css">
.col-sm-3 {
	width: 15%;
	float: left;
	text-align: right;
}

.col-sm-9 {
	width: 85%;
	float: left;
	text-align: left;
}

label[class^="btn btn-default"] {
	margin-top: -4px;
}
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/devicerepair/addEntity.shtml">
		<section class="panel panel-default">
		<div class="panel-body">
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">报修单号</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class=".input" readonly="readonly" style="border-style:none"
						name="DeviceRepairFormMap.rp_number" id="rp_number" >
						
				</div>
			</div>
			
			<div class="line line-dashed line-lg pull-in"></div>
			<input type="hidden" class="form-control checkacc" 
					name="DeviceRepairFormMap.device_id" id="id">
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">设备名称</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class=".input" readonly="readonly"
						name="DeviceRepairFormMap.dname" id="dname" required="required">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">设备编号</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class=".input" readonly="readonly"
						name="DeviceRepairFormMap.dnumber" id="number" required="required">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">设备类型</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class=".input" readonly="readonly"
						name="typeid" id="typeid" required="required">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">规格型号</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class=".input" readonly="readonly"
						name="standard" id="standard" required="required">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">所在部门</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class=".input" readonly="readonly"
						name="userdept" id="userdept" required="required">
						<button type="button" id="devicelist">选择设备</button>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">报修人</label>
				<div class="col-sm-9">
					<input type="text" class=".input" placeholder="请输入报修人" readonly="readonly"
						name="DeviceRepairFormMap.reportman" id="reportman" required="required">
				</div>
			</div>
		
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">电话</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control" required="required"
						name="DeviceRepairFormMap.tel" id="tel">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">确认状态</label>
				<div class="col-sm-9">
					<div class="btn-group m-r">
						<select required="required" class="form-control"  
						name="DeviceRepairFormMap.confirm_status" readonly="readonly"> 
							<option value = 0>待维修</option>
						</select>
					</div>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">故障描述</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入故障描述"
						name="DeviceRepairFormMap.trouble" id="trouble" required="required">
				</div>
			</div>
		</div>
		<footer class="panel-footer text-right bg-light lter">
		<button type="submit" class="btn btn-success btn-s-xs">提交</button>
		</footer> </section>
	</form>
	<script type="text/javascript">
	$(document).ready(function(){
	$.ajax({
	    async : false,
	    dataType:'json',
	    type : 'POST',
	    url : rootPath + '/devicerepair/selectRpnumber.shtml',
	    error : function(){
	        alert('失败');
	    },
	    success : function(data) {
	    	$("#rp_number").val(data.rp_number);
	    	$("#reportman").val(data.userFormMap.accountName);
	    }
	});
	});
	</script>
	<script type="text/javascript"
		src="${ctx}/notebook/notebook_files/bootstrap-filestyle.min.js"></script>
</body>
</html>