var pageii = null;
var grid = null;
$(function() {
	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey : "dname",
			isSort:true,
			name : "设备名称"
		}, {
			colkey : "number",
			isSort:true,
			name : "设备编号"
		}, 
		{
			colkey : "standard",
			name : "规格型号"
		},{
			colkey : "typeid",
			name : "设备类型"
		}, {
			colkey : "userdept",
			name : "使用部门"
		}],
		jsonUrl : parent.rootPath+'/device/findByPage.shtml',
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
	$("#submit").click(function(){
		var cbox = grid.getSelectedCheckbox();
		var arrayList = new Array();  
		$("input[type='checkbox']:checked").each(function () {
           $(this).parent().siblings().each(function(){
        	   arrayList.push($(this).text());
           })
        });
		//增加配件信息的动态显示
		for (var i = 0;i < arrayList.length; i++) {
			if (i%6==1) {
				parent.$("#addDevice")
				.append('<tr><td><span class="removeDevice">删除</span></td><td class="dnumber">'+arrayList[i+1]+'</td><td class="dname">'+arrayList[i]+'</td><td>'+arrayList[i+2]+'</td></tr>');//访问父页面元素值
			}	
		}
		
		parent.$(".removeDevice").click("click",function(){
			$(this).parent().parent().remove();
		})
		//关闭当前弹出层
		var index = parent.layer.getFrameIndex(window.name);  
		parent.layer.close(index);
	});
	
});

