var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [ {
			colkey : "rpnumber",
			name : "维护/维修单号",
			isSort:true,
			width : '150px'
		}, {
			colkey : "fno",
			name : "配件编号"
		}, {
			colkey : "fname",
			name : "配件名称"
		},{
			colkey : "qty",
			isSort:true,
			name : "数量"
		},{
			colkey : "fprice",
			name : "价格"
		},{
			colkey : "op",
			name : "操作人员",
			width : '250px'
		}, {
			colkey : "ftotal",
			name : "总费用",
		}],
		jsonUrl : rootPath + '/SpareParts/findPartReplaceByPage.shtml',
		checkbox : true,
		serNumber : true
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});
});
