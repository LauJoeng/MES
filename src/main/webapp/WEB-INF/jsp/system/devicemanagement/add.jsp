<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript"src="${ctx}/js/system/devicemanagement/add.js"></script>
<script type="text/javascript" src="${ctx}/js/system/devicemanagement/drop-down.js"></script>
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
		action="${ctx}/devicem/addEntity.shtml">
		<section class="panel panel-default">
		<div class="panel-body">
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">设备名称</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入设备名称"
						name="DeviceFormMap.dname" id="dname" required="required";>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">设备编号</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						placeholder="请输入设备编号" name="DeviceFormMap.number" id="number" required="required";>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">规格型号</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入设备的规格型号"
						name="DeviceFormMap.standard" id="standard" required="required">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">设备类型</label>
				<div class="col-sm-9">
					<div class="btn-group m-r">
						<select name="DeviceFormMap.typeid" required="required"; id="type" class="btn btn-sm btn-default dropdown-toggle">
						</select> 
					</div>
				</div>
			</div>
			
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">设备用途</label>
				<div class="col-sm-9">
					<div class="btn-group m-r">
						<select name="DeviceFormMap.category" value="" id="category" class="btn btn-sm btn-default dropdown-toggle" required="required">
						</select> 
					</div>
					<div class="btn-group m-r">
						<select name="DeviceFormMap.workshopno" value="" id="workshop" class="btn btn-sm btn-default dropdown-toggle">
						</select> 
					</div>
					<div class="btn-group m-r">
						<select name="DeviceFormMap.process" value="" id="process" class="btn btn-sm btn-default dropdown-toggle">
						</select> 
					</div>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">设备状态</label>
				<div class="col-sm-9">
					<div class="btn-group m-r" required="required";>
						<button data-toggle="dropdown"
							class="btn btn-sm btn-default dropdown-toggle">
							<span class="dropdown-label">使用中</span> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu dropdown-select">
							<li class=""><a href="#"><input type="radio"
									name="DeviceFormMap.status" value="0">闲置</a></li>
							<li class="active"><a href="#"><input type="radio"
									name="DeviceFormMap.status" value="1">使用中</a></li>
							<li class="active"><a href="#"><input type="radio"
									name="DeviceFormMap.status" value="2">报废</a></li>

						</ul>
					</div>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">使用部门</label>
				<div class="col-sm-9">
					<div class="btn-group m-r">
						<select name="DeviceFormMap.userdept" required="required"; id="department" class="btn btn-sm btn-default dropdown-toggle">
						</select>
					</div>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">安装地点</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入安装地点"
						name="DeviceFormMap.location" id="location" required="required";>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">启用时间</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入启用时间"
						name="DeviceFormMap.usertime" id="usertime"required="required";
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">生产商</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入生产商"
						name="DeviceFormMap.manufacturer" id="manufacturer">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">供应商</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入供应商"
						name="DeviceFormMap.supplier" id="supplier">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">供应商电话</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入供应商电话"
						name="DeviceFormMap.suptel" id="suptel">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">采购时间</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入采购时间"
						name="DeviceFormMap.buytime" id="buytime" required="required"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">当前状态</label>
				<div class="col-sm-9">
					<div class="btn-group m-r">
						<button data-toggle="dropdown"
							class="btn btn-sm btn-default dropdown-toggle">
							<span class="dropdown-label">正常运行</span> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu dropdown-select">
							<li class=""><a href="#"><input type="radio"
									name="DeviceFormMap.cur_status" value="0">停机状态</a></li>
							<li class="active"><a href="#"><input type="radio"
									name="DeviceFormMap.cur_status" value="1">正常运行</a></li>
							<li class="active"><a href="#"><input type="radio"
									name="DeviceFormMap.cur_status" value="2">带病运行</a></li>
							<li class="active"><a href="#"><input type="radio"
									name="DeviceFormMap.cur_status" value="3">停机待修</a></li>

						</ul>
					</div>
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">责任部门</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入责任部门"
						name="DeviceFormMap.dutydept" id="dutydept">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">责任部门电话</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入责任部门电话"
						name="DeviceFormMap.dtdptel" id="dtdptel">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">责任人</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入责任人"
						name="DeviceFormMap.dutyman" id="dutyman">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">责任人电话</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入责任人电话"
						name="DeviceFormMap.dtmantel" id="dtmantel">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">资产编号</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入资产编号"
						name="DeviceFormMap.assetnumbers" id="assetnumbers"
						required="required">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">描述</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入设备描述"
						name="DeviceFormMap.remarks" id="remarks">
				</div>
			</div>
		</div>
		<footer class="panel-footer text-right bg-light lter">
		<button type="submit" class="btn btn-success btn-s-xs">提交</button>
		</footer> </section>
	</form>
	<script type="text/javascript">
	$(window).load(function(){
		$("#category").click(function() {
			var category = $("#category").val();
				if(category != null){
					if(category == "非生产" || category == "请选择"){
						$('#workshop').attr("disabled",true); //设置input为不可编辑
						$('#process').attr("disabled",true); //设置input为不可编辑
					}else{
						$('#workshop').attr("disabled",false); //设置input为可编辑
						$('#process').attr("disabled",false); //设置input为可编辑
					}
				}else if(category == "请选择"){
					alert("请选择");
				}
		});
	});
	</script>
	<script type="text/javascript"
		src="${ctx}/notebook/notebook_files/bootstrap-filestyle.min.js"></script>
</body>
</html>