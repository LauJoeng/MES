var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey : "name",
			name : "计划名称",
			width:'100px'
		},{
			colkey : "dnumber",
			name : "点检设备编号"
			
		},{
			colkey : "dname",
			name : "点检设备名称",
			width:'300px'
		},{
			colkey : "inspectman",
			name : "计划点检人员",
			width:'100px'
		},{
			colkey : "plantime",
			name : "计划开始时间",
			width:'100px',
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm");
			}
		},{
			colkey : "inspectcycle",
			name : "点检周期",
			width:'80px',
			renderData : function(rowindex,data, rowdata, column) {
				return data+"天";
			}
		},{
			colkey : "status",
			name : "计划状态",
			width:'80px',
			renderData : function(rowindex,data, rowdata, column) {
				if(data==0){
					return "停用";
				}else{
					return "启用";
				}
			}
			
		}],
		jsonUrl : rootPath + '/inspect/findInspectPlanByPage.shtml',
		checkbox : true,
		serNumber : true
	});
	
	$("#addPlan").click("click",function(){
		addPlan();
	})
	$("#editPlan").click("click",function(){
		editPlan();
	})

	$("#delPlan").click("click",function(){
		delPlan();
	})
});

function addPlan() {
	pageii = layer.open({
		title : "添加计划",
		type : 2,
		area : [ "600px", "80%" ],
		content : rootPath + '/inspect/addInspectPlanUI.shtml'
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
		area : [ "600px", "80%" ],
		content : rootPath + '/inspect/editInspectPlanUI.shtml?id=' + cbox
	});
}
function delPlan() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox == "") {
		layer.msg("请选择删除项！！");
		return;
	}
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/inspect/deleteInspectPlanEntity.shtml';
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