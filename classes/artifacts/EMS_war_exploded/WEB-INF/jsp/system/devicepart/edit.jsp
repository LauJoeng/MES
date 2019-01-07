<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript"src="${ctx}/js/system/devicepart/edit.js"></script>
<script type="text/javascript" src="${ctx}/js/system/devicepart/drop-down.js"></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>

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
		action="${ctx}/SpareParts/editEntity.shtml">
		<input type="hidden" class="form-control" value="${devicepart.id}"
			name="DevicePartFormMap.id" id="id">
		<section class="panel panel-default">
		<div class="panel-body">
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">配件名称</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入配件名称"
						name="DevicePartFormMap.fname" id="fname" required="required" value="${devicepart.fname}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">配件条码</label>
				<div class="col-sm-9">
					<input type="text" class="form-control"
						placeholder="请输入设备编号" name="DevicePartFormMap.fid" id="fid" required="required" value="${devicepart.fid}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">规格型号</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入配件的规格型号"
						name="DevicePartFormMap.Spec" id="Spec" required="required" required="required" value="${devicepart.Spec}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">配件类型</label>
				<div class="col-sm-9">
					<div class="btn-group m-r">
						<select name="DevicePartFormMap.ftype" value="${devicepart.ftype}" id="type" class="btn btn-sm btn-default dropdown-toggle">
							<option>${devicepart.ftype}</option>
						</select> 
					</div>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">配件单价</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入配件单价"
						name="DevicePartFormMap.fprice" id="fprice" required="required" value="${devicepart.fprice}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">生产商</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入生产商"
						name="DevicePartFormMap.manufacturer" id="manufacturer" value="${devicepart.manufacturer}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">供应商</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入供应商"
						name="DevicePartFormMap.supplier" id="supplier" value="${devicepart.supplier}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">供应商电话</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入供应商电话"
						name="DevicePartFormMap.suptel" id="suptel" value="${devicepart.suptel}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">创建时间</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入采购时间"
						name="DevicePartFormMap.createtime" id="createtime" required="required"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${devicepart.createtime}">
				</div>
			</div>
			
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">备注</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入备注"
						name="DevicePartFormMap.remarks" id="remarks" value="${devicepart.remarks}">
				</div>
			</div>

		</div>
		<footer class="panel-footer text-right bg-light lter">
		<button type="submit" class="btn btn-success btn-s-xs">提交</button>
		</footer> </section>
	</form>
	<script type="text/javascript">
	</script>
	<script type="text/javascript"
		src="${ctx}/notebook/notebook_files/bootstrap-filestyle.min.js"></script>
</body>
</html>