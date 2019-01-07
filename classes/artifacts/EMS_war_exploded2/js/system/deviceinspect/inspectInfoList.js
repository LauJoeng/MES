var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey : "inspectcode",
			isSort:true,
			name : "点检条码",
			width:'100px'
		},{
			colkey : "inspectinfo",
			name : "点检项目",
			width:'300px'
		},{
			colkey : "applydevice",
			name : "适用设备"
		},{
			colkey : "inspectrule",
			name : "点检标准",
		},{
			colkey : "remark",
			name : "备注"
		}],
		jsonUrl : rootPath + '/inspect/findByPage.shtml',
		checkbox : true,
		serNumber : true
	});
	
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});
	$("#addRecord").click("click",function(){
		addRecord();
	})
	$("#delRecord").click("click",function(){
		delRecord();
	})
});

function addRecord() {
	pageii = layer.open({
		title : "添加项目",
		type : 2,
		area : [ "600px", "80%" ],
		content : rootPath + '/inspect/addInspectInfoUI.shtml'
	});
}
function delRecord() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox == "") {
		layer.msg("请选择删除项！！");
		return;
	}
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/inspect/deleteInspectInfoEntity.shtml';
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