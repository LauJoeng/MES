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
			colkey : "cname",
			name : "物品名称"
		}, {
			colkey : "unit",
			name : "物品单位"
		},{
			colkey : "price",
			isSort:true,
			name : "价格"
		},{
			colkey : "qty",
			isSort:true,
			name : "数量"
		},{
			colkey : "op",
			name : "操作人员",
			width : '250px'
		}, {
			colkey : "ctotal",
			name : "总费用",
		}],
		jsonUrl : rootPath + '/consumable/findConsumUseByPage.shtml',
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
