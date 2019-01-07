<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript"src="${ctx}/js/system/consumable/edit.js"></script>
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
		action="${ctx}/consumable/editEntity.shtml">
		<input type="hidden" class="form-control checkacc" value="${consumable.id}"
			name="ConsumableFormMap.id" id="id">
		<section class="panel panel-default">
		<div class="panel-body">
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">消耗品名称</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入消耗品名称"
						name="ConsumableFormMap.cname" id="cname" required="required" value="${consumable.cname}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">规格类型</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc" placeholder="请输入设备的规格类型"
						name="ConsumableFormMap.specifications" id="specifications" required="required" value="${consumable.specifications}">
				</div>
			</div>
		
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">单位</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" required="required"
						placeholder="请输入单位" name="ConsumableFormMap.unit" id="unit" value="${consumable.unit}">
				</div>
			</div>
			
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">单价</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入单价"
						name="ConsumableFormMap.price" id="price"  required="required" value="${consumable.price}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">采购时间</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入采购时间"
						name="ConsumableFormMap.buytime" id="buytime" required="required"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${consumable.buytime}">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">描述</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入设备描述"
						name="ConsumableFormMap.remarks" id="remarks" value="${consumable.remarks}">
				</div>
			</div>
		</div>
		<footer class="panel-footer text-right bg-light lter">
		<button type="submit" class="btn btn-success btn-s-xs">提交</button>
		</footer> </section>
	</form>
	<script type="text/javascript">
	onloadurl();
	</script>
	<script type="text/javascript"
		src="${ctx}/notebook/notebook_files/bootstrap-filestyle.min.js"></script>
</body>
</html>