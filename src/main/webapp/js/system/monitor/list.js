var dialog;
var grid;
$(function() {
	grid = lyGrid({
		id : 'paging',
		l_column : [ {
			colkey : "id",
			name : "id",
			hide:true
		}, {
			colkey : "cpuusage",
			name : "cpu使用率",
			width : "85px"
		}, {
			colkey : "setcpuusage",
			name : "预设cpu使用率",
			width : "115px"
		}, {
			colkey : "jvmusage",
			name : "Jvm使用率",
			width : "90px"
		}, {
			colkey : "setjvmusage",
			name : "预设Jvm使用率",
			width : "115px"
		} ,{
			colkey : "ramusage",
			name : "Ram使用率",
			width : "90px"
		} ,{
			colkey : "setramusage",
			name : "预设Ram使用率",
			width : "115px"
		} ,{
			colkey : "email",
			name : "发送的邮件"
		} ,{
			colkey : "opertime",
			name : "发送的时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		} ,{
			colkey : "mark",
			name : "备注"
		} ],
		jsonUrl : rootPath + '/monitor/findByPage.shtml',
		checkbox : true
	});
	$("#searchForm").click("click", function() {//绑定查询按扭
		var searchParams = $("#fenye").serializeJson();
		grid.setOptions({
			data : searchParams
		});
	});
});