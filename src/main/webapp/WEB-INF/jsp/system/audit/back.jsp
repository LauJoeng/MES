<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/audit/back.js"></script>

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
		action="${ctx}/audit/back.shtml">
		<input type="hidden" class="form-control checkacc" value="${audit.id}"
			name="DeviceRepairFormMap.id" id="id">
		<section class="panel panel-default">
		<div class="panel-body">
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">报修单号</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control" 
						name="DeviceRepairFormMap.rp_number" id="rp_number"
						readonly="readonly" value="${audit.rp_number}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">设备名称</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						name="DeviceRepairFormMap.dname" id="dname" readonly="readonly" value="${audit.dname}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">设备编号</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" readonly="readonly"
						 name="DeviceRepairFormMap.dnumber" id="dnumber" value="${audit.dnumber}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">报修人</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" 
						name="DeviceRepairFormMap.reportman" id="reportman"
						readonly="readonly" value="${audit.reportman}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">报修时间</label>
				<div class="col-sm-9">
					<input type="text" class="form-control"
						name="DeviceRepairFormMap.reporttime" id="reporttime"
						readonly="readonly" value="${audit.reporttime}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">维修开始时间</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" 
						name="DeviceRepairFormMap.begintime" id="begintime"
						readonly="readonly" value="${audit.begintime}">
				</div>
			</div>
			
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">维修费用</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" 
						name="DeviceRepairFormMap.rp_cost" id="rp_cost"
						readonly="readonly" value="${audit.rp_cost}">
				</div>
			</div>
			
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">维修人员</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" 
						name="DeviceRepairFormMap.repairman" id="rp_cost"
						readonly="readonly" value="${audit.repairman}">
				</div>
			</div>
			
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">工作描述</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" 
						name="DeviceRepairFormMap.workinfo" id="workinfo"
						readonly="readonly" value="${audit.workinfo}">
				</div>
			</div>
		</div>
		<footer class="panel-footer text-right bg-light lter">
			<button type="submit" class="btn btn-success btn-s-xs">退回</button>
		</footer> </section>
	</form>
	<script type="text/javascript">
		onloadurl();
	</script>
	<script type="text/javascript"
		src="${ctx}/notebook/notebook_files/bootstrap-filestyle.min.js"></script>
</body>
</html>