$(document).ready(function() {// 页面开始加载时执行
	// 所有工序查询
	$.ajax({
				async : false,
				dataType : 'json',
				type : 'POST',
				url : rootPath + '/operationData/selectName.shtml',
				error : function() {
					alert('工序查询失败 ');
				},
				success : function(data) {
					// 工序
					for (var i = 0; i < data.length; i++) {
						$("#OperationDataFormMap\\.process").append("<option>" + data[i]+ "</option>");
					}
				}
			});
});

var pageii = null;
var grid = null;
var confs =null;
$(function() {
	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey 	: "module_code",
			name 	: "组件条码"
		}, {
			colkey 	: "optime",
			name 	: "操作时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd  hh:mm:ss");
			}
		}],
		jsonUrl 	: rootPath + '/operationData/selectData.shtml',
		checkbox 	: true,
		serNumber 	: true
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var processName = $("#OperationDataFormMap\\.processName option:selected").html();
		var op = $("#OperationDataFormMap\\.op").val();
		var begintime = $("#OperationDataFormMap\\.begintime").val();
		var endtime = $("#OperationDataFormMap\\.endtime").val();
		if(op != null && op != '' && begintime != null && begintime != '' && endtime != null && endtime != ''){
			var searchParams = $("#searchForm").serializeJson();// 初始化传参数
			grid.setOptions({
				data : searchParams
			});
		}else{
			alert("请输入员工号及操作时间");
			return ;
		}
	});

});



