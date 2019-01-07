//isSort:true：排序
var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey : "rp_number",
			isSort:true,
			name : "维修单号"
		},{
			colkey : "dnumber",
			isSort:true,
			name : "设备编号"
		},{
			colkey : "dname",
			isSort:true,
			name : "设备名"
		},{
			colkey : "standard",
			isSort:true,
			name : "规格型号"
		},{
			colkey : "reporttime",
			isSort:true,
			name : "报修时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},{
			colkey : "reportman",
			name : "报修人"
		},{
			colkey : "tel",
			name : "电话"
		},{
			colkey : "confirm_status",
			name : "维修状态",
			renderData : function(rowindex,data, rowdata, column) {
                if (data == 0)
                	confirm_status = '待维修';
                if (data == 1)
                	confirm_status = '待确认';
                if (data == 2)
                	confirm_status = '已完成';
                return confirm_status;
			}
		},{
			colkey : "isreplace",
			name : "是否更换配件",
			renderData : function(rowindex,data, rowdata, column) {
                if (data == 0)
                	isreplace = '否';
                if (data == 1)
                	isreplace = '是';
                return isreplace;
			}
		}],
		jsonUrl : rootPath + '/devicerepair/findByPage.shtml',
		checkbox : true,
		serNumber : true
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});

	$("#addFun").click("click", function() {
		addFun();
	});
	$("#editFun").click("click", function() {
		editFun();
	});
	$("#delFun").click("click", function() {
		delFun();
	});
});
function addFun() {
	pageii = layer.open({
		title : "新增",
		type : 2,
		area : [ "800px", "80%" ],
		content : rootPath + '/devicerepair/addUI.shtml'
	});
}
function delFun(){
	var cbox = grid.getSelectedCheckbox();
	if (cbox == "") {
		layer.msg("请选择删除项！！");
		return;
	}
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/devicerepair/deleteId.shtml';
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
function editFun(){
	var cbox = grid.getSelectedCheckbox();
	if (cbox.length > 1 || cbox == "") {
		layer.msg("只能选中一个");
		return;
	}
	pageii = layer.open({
		title : "编辑",
		type : 2,
		area : [ "600px", "60%" ],
		content : rootPath + '/devicerepair/editUI.shtml?id=' + cbox
	});
}

