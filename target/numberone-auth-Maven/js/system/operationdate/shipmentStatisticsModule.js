

var pageii = null;
var grid = null;
var confs =null;
$(function() {

	$("#search").click("click", function() {// 绑定查询按扭
		
		var order_no = $("#order_no").val();
		var begintime = $("#begintime").val();
		var endtime = $("#endtime").val();
		/*alert(endtime);*/
		if( (begintime != null && begintime != '') || (endtime != null && endtime != '')){
			var searchParams = $("#searchForm").serializeJson();// 初始化传参数
			/*grid.setOptions({
				data : searchParams
			});*/
			
			grid = lyGrid({
				pagId : 'paging',
				l_column : [{
					colkey 	: "ioDate",
					name 	: "出货日期",
					width	:"150px"
				}, {
					colkey 	: "compactno",
					name 	: "订单号",
				}, {
					colkey 	: "exchRate",
					name 	: "型号",
				}, {
					colkey 	: "mainNum",
					name 	: "数量",
				}, {
					colkey 	: "subNum",
					name 	: "瓦数",
				}],
				jsonUrl 	: rootPath + '/operationData/selectShipmentModule.shtml',
				checkbox 	: true,
				serNumber 	: true,
				data : searchParams
			});
		}else{
			alert("查询条件不能全部为空!!");
			return ;
		}
	});

});



