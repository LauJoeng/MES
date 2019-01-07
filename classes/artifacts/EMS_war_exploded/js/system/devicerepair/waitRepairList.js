var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey : "rp_number",
			isSort:true,
			name : "维修单号"
		}, {
			colkey : "dnumber",
			isSort:true,
			name : "设备编号"
		},{
			colkey : "dname",
			name : "设备名称",
		},{
			colkey : "reportman",
			name : "报修人"
		},{
			colkey : "tel",
			name : "电话"
		},{
			colkey : "reporttime",
			name : "报修时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},{
			colkey : "trouble",
			name : "故障描述",
			width:'200px'
		},{
			colkey : "confirm_status",
			name : "确认状态",
			renderData : function(rowindex,data, rowdata, column) {
				switch (data) {
				case 0:return "待维修"
					break;
				case 1:return "待确认"
					break;
				default:return "已完成"
					break;
				}
			}
		}],
		jsonUrl : rootPath + '/devicerepair/findWaitRepairByPage.shtml',
		checkbox : true,
		serNumber : true
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});
	$("#excuRepair").click("click",function(){
		excuRepair();
	})

});
function excuRepair(){
	var cbox = grid.getSelectedCheckbox();
	if (cbox.length > 1 || cbox == "") {
		layer.msg("只能选中一个");
		return;
	}
	pageii = layer.open({
		title : "执行维修",
		type : 2,
		area : [ "800px", "100%" ],
		content : rootPath + '/devicerepair/excuRepairUI.shtml?id=' + cbox
	});
}