var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		l_column : [{
			colkey : "inspectId",
			isSort:true,
			name : "点检单号",
			width:'140px'
		}, {
			colkey : "dname",
			name : "维修设备"
		}, {
			colkey : "inspectman",
			name : "点检人员"
		}, {
			colkey : "inspectinfo",
			name : "工作描述",
			width:'220px'
		},{
			colkey : "inspectfee",
			name : "维修费用",
			width:'80px',
			renderData : function(rowindex,data, rowdata, column) {
				return data+"元";
			}
		},{
			colkey : "starttime",
			isSort:true,
			name : "点检开始时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},
		{
			colkey : "endtime",
			isSort:true,
			name : "点检结束时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		}],
		jsonUrl : rootPath + '/inspect/findInspectRecordByPage.shtml',
		checkbox : true,
		serNumber : false
	});
	
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});


	//绑定添加按钮事件
	$("#addRecord").click("click",function(){
		addRecord();
	});
	
	//绑定删除按钮事件
	$("#delete").click("click",function(){
		delRecord();
	});
});

function addRecord() {
	pageii = layer.open({
		title : "添加记录",
		type : 2,
		area : [ "800px", "100%" ],
		content : rootPath + '/devicerepair/addRecordUI.shtml'
	});
}

function delRecord() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox == "") {
		layer.msg("请选择删除项！！");
		return;
	}
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/inspect/deleteInspectRecordEntity.shtml';
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