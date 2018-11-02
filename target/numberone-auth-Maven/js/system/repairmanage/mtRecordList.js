var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		l_column : [{
			colkey : "maintainid",
			isSort:true,
			name : "维护单号",
			width:'140px'
		}, {
			colkey : "dname",
			name : "维护设备"
		}, {
			colkey : "repairman",
			name : "维护人员"
		}, {
			colkey : "workinfo",
			name : "维护过程",
			width:'220px'
		},{
			colkey : "maintainfee",
			name : "维护费用",
			width:'80px',
			renderData : function(rowindex,data, rowdata, column) {
				return data+"元";
			}
		},{
			colkey : "starttime",
			isSort:true,
			name : "维护开始时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},
		{
			colkey : "endtime",
			isSort:true,
			name : "维护结束时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},{
			colkey : "maintaintime",
			name : "维护用时",
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
		}],
		jsonUrl : rootPath + '/maintain/findByPage.shtml',
		checkbox : true,
		serNumber : false
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

//添加维护记录
function addRecord() {
	pageii = layer.open({
		title : "添加记录",
		type : 2,
		area : [ "800px", "100%" ],
		content : rootPath + '/repairmanage/addRecordUI.shtml'
	});
}

function delRecord() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox == "") {
		layer.msg("请选择删除项！！");
		return;
	}
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/maintain/deleteEntity.shtml';
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