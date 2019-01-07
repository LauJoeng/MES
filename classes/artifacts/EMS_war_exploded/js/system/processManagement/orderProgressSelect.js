var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [ {
			colkey 	: "order_no",
			name 	: "订单号",
			width 	: '100px'
		}, {
			colkey 	: "module_code",
			name 	: "组件条码",
			width 	: '150px'
		}, {
			colkey 	: "curStatus",
			name 	: "状态",
			width 	: '50px'
		},{
			colkey 	: "process_1_status",
			name 	: "分片",
			width 	: '50px'
		},{
			colkey 	: "process_2_status",
			name 	: "拼接",
			width 	: '50px'
		},{
			colkey 	: "process_3_status",
			name 	: "前道EL",
			width 	: '60px'
		}, {
			colkey 	: "process_4_status",
			name 	: "压层",
			width 	: '50px'
		}, {
			colkey 	: "process_5_status",
			name 	: "削边",
			width 	: '50px'
		}, {
			colkey 	: "process_6_status",
			name 	: "中道EL",
			width 	: '60px'
		}, {
			colkey 	: "process_7_status",
			name 	: "装框",
			width 	: '50px'
		}, {
			colkey 	: "process_8_status",
			name 	: "清洁",
			width 	: '50px'
		}, {
			colkey 	: "process_9_status",
			name 	: "耐压测试",
			width 	: '80px'
		}, {
			colkey 	: "process_10_status",
			name 	: "IV测试",
			width 	: '60px'
		}, {
			colkey 	: "process_11_status",
			name 	: "后道EL",
			width 	: '60px'
		}, {
			colkey 	: "process_12_status",
			name 	: "FQC",
			width 	: '50px'
		}, {
			colkey 	: "process_13_status",
			name 	: "PKG",
			width 	: '50px'
		}, {
			colkey 	: "process_14_status",
			name 	: "入库",
			width 	: '50px'
		}],
		jsonUrl 	: rootPath + '/processManagement/findOrderProgressByPage.shtml',
		checkbox 	: true,
		serNumber 	: true
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		var sumbitclick=false;
		var order_no=$("#order_no").val(); //订单编号
		var module_code=$("#module_code").val();//组件编码
		$("#orderprogressList tr:gt(0)").remove();/*  清空其他内容 重新加载表头 */
		if(order_no=="" &&  module_code==""){
			alert("请输入查询内容");
			return;
		}
		//正则表达式用来判断订单号输入是否 符合逻辑
		if(order_no !="" && /^([\d]{2})-([\w]{3})/.exec(order_no) ==null ){ 
			$("#order_no").val("");
			alert("订单号格式：XX-XXX");
			return;
		}
		grid.setOptions({
			data : searchParams
		});
	});
});

