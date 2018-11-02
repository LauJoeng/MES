var pageii = null;
var grid = null;
$(function() {
	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey : "rp_number",
			isSort:true,
			name : "报修单号"
		},{
			colkey : "dname",
			isSort:true,
			name : "设备名称"
		},{
			colkey : "dnumber",
			name : "设备编号"
		},{
			colkey : "reporttime",
			name : "报修时间",
			isSort:true,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},{
			colkey : "reportman",
			name : "报修人"
		},{
			colkey : "confirm_status",
			name : "确认状态",
			renderData : function(rowindex,data, rowdata, column) {
                if (data == 0)
                	confirm_status = '待维修';
                if (data == 1)
                	confirm_status = '待确认';
                if (data == 2)
                	confirm_status = '已确认';
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
		jsonUrl : rootPath + '/audit/findByPage.shtml',
		checkbox : true,
		serNumber : true
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});
	
	//通过审核按钮
	$("#through").click("click",function(){
		through();
	});
	//退回审核按钮
	$("#back").click("click",function(){
		back();
	});

});

function through(){
	var cbox = grid.getSelectedCheckbox();
	if (cbox.length > 1 || cbox == ""){
		layer.msg("只能选中一个");
		return;
	}
	pageii = layer.open({
		title : "审核",
		type : 2,
		area : [ "700px", "60%" ],
		content : rootPath + '/audit/editUI.shtml?id=' + cbox
	});
}

function back(){
	var cbox = grid.getSelectedCheckbox();
	if (cbox.length > 1 || cbox == ""){
		layer.msg("只能选中一个");
		return;
	}
	pageii = layer.open({
		title : "审核",
		type : 2,
		area : [ "700px", "60%" ],
		content : rootPath + '/audit/backUI.shtml?id=' + cbox
	});
}
