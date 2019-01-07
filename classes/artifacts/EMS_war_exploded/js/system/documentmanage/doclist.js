var pageii = null;
var grid = null;
$(function() {

	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey : "filename",
			name : "文件名",
		}, {
			colkey : "dname",
			name : "设备名称"
		},{
			colkey : "uploadtime",
			name : "上传时间",
			isSort:true,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
		   }
		},{
			colkey : "dnumber",
			name : "设备编号",
			isSort:true
		},{
			colkey : "filetype",
			name : "文档类型"
		},{
			colkey : "remark",
			name : "备注"
		}],
		jsonUrl : rootPath + '/document/findByPage.shtml',
		checkbox : true,
		serNumber : true,
		checkValue : 'id'
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});
	$("#addDocument").click("click", function() {
		addDocument();
	});
	//绑定删除按钮事件
	$("#delDocument").click("click",function(){
		delDocument();
	});
	$("#downLoadDoc").click("click", function() {
		downLoadDoc();
	});
});

function addDocument() {
	pageii = layer.open({
		title : "添加文档",
		type:2,
		area : [ "800px", "100%" ],
		content : rootPath + '/document/addDocumentUI.shtml'
	});
}

function delDocument() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox == "") {
		layer.msg("请选择删除项！！");
		return;
	}
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/document/deleteEntity.shtml';
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


function downLoadDoc() {
	var cbox = grid.getSelectedCheckbox();
	var arrayList = new Array();
	if (cbox.length > 1 || cbox == "") {
		layer.msg("只能选中一个");
		return;
	}

	$("input[type='checkbox']:checked").each(function () {
       $(this).parent().siblings().each(function(){
    	   arrayList.push($(this).text());
       })
    });
	var fileName = arrayList[1];
	//由于ajax请求不能返回流，无法弹出文件选择框，所以在页面放了一个隐藏表单，通过表单请求的方式来得到文件流下载
	$("#fileNameInput").attr("value",fileName);
	$("#idInput").attr("value",cbox[0]);
	// $("#downloadform").submit();
    window.open(rootPath+"/document/download.shtml?fileName="+fileName+"&id="+cbox[0]);
}




