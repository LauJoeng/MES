

var pageii = null;
var grid = null;
var confs =null;
$(function() {

	$("#search").click("click", function() {// 绑定查询按扭
		var module_code = $("#module_code").val();
		var order_no = $("#order_no").val();
		var op = $("#op").val();
		var begintime = $("#begintime").val();
		var endtime = $("#endtime").val();
		/*alert(endtime);*/
		if((module_code!=null &&  module_code!='' )|| (order_no!=null &&  order_no!='') || (op != null && op != '') || (begintime != null && begintime != '') || (endtime != null && endtime != '')){
			var searchParams = $("#searchForm").serializeJson();// 初始化传参数
			/*grid.setOptions({
				data : searchParams
			});*/
			
			grid = lyGrid({
				pagId : 'paging',
				l_column : [{
					colkey 	: "module_code",
					name 	: "组件条码",
					width	:"150px"
				}, {
					colkey 	: "order_no",
					name 	: "订单号",
				}, {
					colkey 	: "ordersendno",
					name 	: "订单指令",
				}, {
					colkey 	: "op",
					name 	: "员工号",
				}, {
					colkey 	: "china_name",
					name 	: "名字",
				}, {
					colkey 	: "process",
					name 	: "工序",
				}, {
					colkey 	: "optime",
					name 	: "操作时间",
					width	:"180px"
				}, {
					colkey 	: "step",
					name 	: "进度",
				}],
				jsonUrl 	: rootPath + '/operationData/selectOpModuleData.shtml',
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



