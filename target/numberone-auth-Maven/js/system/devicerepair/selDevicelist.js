var pageii = null;
var grid = null;
$(function() {
	grid = lyGrid({
		pagId : 'paging',
		l_column : [ {
			colkey : "id",
			name : "id",
			isSort:true,
			width : '90px'
		}, {
			colkey : "dname",
			isSort:true,
			name : "设备名称"
		}, {
			colkey : "number",
			isSort:true,
			name : "设备编号"
		},{
			colkey : "standard",
			isSort:true,
			name : "规格型号"
		},{
			colkey : "typeid",
			name : "设备类型"
		},{
			colkey : "userdept",
			name : "使用部门",
		}],
		jsonUrl : rootPath + '/devicem/findByPage.shtml',
		checkbox : true,
		serNumber : true
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});

	//点击按钮提交
	$("#button").click(function(){
		var cbox = grid.getSelectedCheckbox();
		if (cbox.length > 1 || cbox == "") {
			layer.msg("只能选中一个");
			return;
		}
		var arrayList = new Array();  
		$("input[type='checkbox']:checked").each(function () {
           $(this).parent().siblings().each(function(){
        	   arrayList.push($(this).text());   
           })
        });
		parent.$("#id").val(arrayList[1]);
		parent.$("#dname").val(arrayList[2]);
		parent.$("#number").val(arrayList[3]);
		parent.$("#standard").val(arrayList[4]);
		parent.$("#typeid").val(arrayList[5]);//访问父页面元素值 
		parent.$("#userdept").val(arrayList[6]);
		
		//关闭当前弹出层
		var index = parent.layer.getFrameIndex(window.name);  
		parent.layer.close(index);
	})
});

