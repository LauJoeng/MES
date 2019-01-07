var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		l_column : [{
			colkey : "dnumber",
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
			name : "计划时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},{
			colkey : "lasttime",
			name : "上次维护时间",
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
		jsonUrl : rootPath + '/devicemaintenance/findByPage.shtml',
		checkbox : true,
		serNumber : false
	});
	
	//执行维护
	$("#maintenance").click("click",function(){
		maintenance();
	});
});

function maintenance() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox.length > 1 || cbox == ""){
		layer.msg("只能选中一个");
		return;
	}
	pageii = layer.open({
		title : "执行维护",
		type : 2,
		area : [ "800px", "100%" ],
		content : rootPath + '/repairmanage/excuPlanUI.shtml?id=' + cbox
	});
}
