var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		l_column : [{
			colkey : "rp_number",
			isSort:true,
			name : "维修单号",
			width:'140px'
		}, {
			colkey : "dname",
			name : "维修设备"
		}, {
			colkey : "repairman",
			name : "维修人员"
		}, {
			colkey : "workinfo",
			name : "工作描述",
			width:'220px'
		},{
			colkey : "rp_cost",
			name : "维修费用",
			width:'80px',
			renderData : function(rowindex,data, rowdata, column) {
				return data+"元";
			}
		},{
			colkey : "begintime",
			isSort:true,
			name : "维修开始时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},
		{
			colkey : "stoptime",
			isSort:true,
			name : "维修结束时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},{
			colkey : "repairtime",
			name : "维修用时",
			width:'120px',
			renderData : function(rowindex,data, rowdata, column) {
				if(data<60){
					return data+"分";
				}else  if(data<1440&&data>=60){
					var hours=parseInt(data/60);//小时
					var minutes=data%60;//分钟
					return hours+"时/"+minutes+"分";
				}else{
					var days=parseInt(data/1440);
					var hours=parseInt((data%1440)/60);
					var minutes=data%60;
					return days+"天/"+hours+"时/"+minutes+"分";
				}
			}
		}, {
			colkey : "confirm_status",
			name : "维修状态",
			width:'70px',
			renderData : function(rowindex,data, rowdata, column) {
                if (data == 0)
                	confirm_status = '待维修';
                if (data == 1)
                	confirm_status = '待确认';
                if (data == 2)
                	confirm_status = '已完成';
                return confirm_status;
			}
		}],
		jsonUrl : rootPath + '/devicerepair/findRpRecordByPage.shtml',
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
	$("#delRecord").click("click",function(){
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
		var url = rootPath + '/devicerepair/deleteRpEntity.shtml';
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