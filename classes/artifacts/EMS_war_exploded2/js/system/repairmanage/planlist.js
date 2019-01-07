var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		l_column : [{
			colkey : "dnumber",
			isSort:true,
			name : "设备编号"
		}, {
			colkey : "dname",
			name : "设备名称"
		}, {
			colkey : "dstandard",
			name : "规格型号"
		}, {
			colkey : "usedept",
			name : "使用部门",
		}, {
			colkey : "dtype",
			name : "设备类型"
		}, {
			colkey : "plantime",
			isSort:true,
			name : "计划时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},{
			colkey : "repairman",
			name : "维护人员"
		},{
			colkey : "repaircycle",
			name : "维修周期",
			renderData : function(rowindex,data, rowdata, column) {
				return data+"天";
			}
		},{
			colkey : "planinfo",
			name : "计划描述",
			width:'200px'
			
		}],
		jsonUrl : rootPath + '/repairmanage/findByPage.shtml',
		checkbox : true,
		serNumber : false
	});
	
	//绑定添加按钮事件
	$("#addPlan").click("click",function(){
		addPlan();
	});
	
	//绑定编辑按钮事件
	$("#editPlan").click("click",function(){
		editPlan();
	});
	//绑定执行按钮事件
	$("#excuPlan").click("click",function(){
		excuPlan();
	});
	//绑定删除按钮事件
	$("#delPlan").click("click",function(){
		delPlan();
	});
});

function addPlan() {
	//弹出添加计划输入框
	pageii = layer.open({
		title : "添加计划",
		type:2,
		area : [ "800px", "100%" ],
		content : rootPath + '/repairmanage/addPlanUI.shtml'
	});
}

function editPlan() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox.length > 1 || cbox == "") {
		layer.msg("只能选中一个");
		return;
	}
	pageii = layer.open({
		title : "修改计划",
		type : 2,
		area : [ "800px", "100%" ],
		content : rootPath + '/repairmanage/editPlanUI.shtml?id=' + cbox
	});
}
function excuPlan() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox.length > 1 || cbox == "") {
		layer.msg("只能选中一个");
		return;
	}
	pageii = layer.open({
		title : "执行计划",
		type : 2,
		area : [ "800px", "100%" ],
		content : rootPath + '/repairmanage/excuPlanUI.shtml?id=' + cbox
	});
}
function delPlan() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox == "") {
		layer.msg("请选择删除项！！");
		return;
	}
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/repairmanage/deleteEntity.shtml';
		var s = CommnUtil.ajax(url, {
			ids : cbox.join(",")
		}, "json");
		if (s == "success") {
			layer.msg('删除成功');
			grid.loadData();
		} else {
			layer.msg('删除失败');
		}
	});
}