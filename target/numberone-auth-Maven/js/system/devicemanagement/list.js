var pageii = null;
var grid = null;
$(function() {
	grid = lyGrid({
		l_column : [{
			colkey : "dname",
			isSort:true,
			name : "设备名称"
		}, {
			colkey : "number",
			isSort:true,
			name : "设备编号"
		},{
			colkey : "standard",
			isSort:true,
			name : "规格型号"
		},{
			colkey : "typeid",
			name : "设备类型"
		},{
			colkey : "status",
			name : "设备状态",
			renderData : function(rowindex,data, rowdata, column) {
                if (data == 0)
                	status = '闲置';
                if (data == 1)
                	status = '使用中';
                if (data == 2)
                	status = '报废';
                return status;
			}
		}, {
			colkey : "userdept",
			name : "使用部门",
		}, {
			colkey : "location",
			name : "安装地点",
		},{
			colkey : "usertime",
			name : "启用时间",
			isSort:true,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},{
			colkey : "dutyman",
			name : "责任人"
		}, {
			colkey : "dtmantel",
			name : "责任人电话"
		},
		{
			colkey : "buytime",
			name : "采购时间",
			isSort:true,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		}],
		jsonUrl : rootPath + '/devicem/findByPage.shtml',
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
		area : [ "600px", "60%" ],
		content : rootPath + '/devicem/addUI.shtml'
	});
}
function delFun(){
	var cbox = grid.getSelectedCheckbox();
	if (cbox == "") {
		layer.msg("请选择删除项！！");
		return;
	}
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/devicem/deleteId.shtml';
		var s = CommnUtil.ajax(url, {ids : cbox.join(",")}, "json");
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
		content : rootPath + '/devicem/editUI.shtml?id=' + cbox
	});
}

