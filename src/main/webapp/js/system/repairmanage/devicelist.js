var pageii = null;
var grid = null;
$(function() {
	var dtype='';
	var usdept='';
	$.ajax({
		url:parent.rootPath+'/device/alldeptandtype.shtml',
		dataType:'json',
		success:function(data){
			for (var i = 0; i <data.typelist.length; i++) {
				$("#dlist").append('<li>'+data.typelist[i]+'</li>');
			}
			for (var i = 0; i <data.deptlist.length; i++) {
				$("#usdept").append('<li>'+data.deptlist[i]+'</li>');
			}
			//获取所有li的节点
			var dlists = $("#dlist").children();
			var usdepts = $("#usdept").children();
			//给每个li绑定事件
			for(var i = 0;i<dlists.length;i++){
				dlists[i].onclick=function(){
				//点击互斥事件
				$(this).addClass('selected').siblings().removeClass('selected');  
					if($(this).hasClass('selected')){
						dtype=$(this).text();
						if (dtype!='----------') {
							$("#typeid").val(dtype);
						}else{
							$("#typeid").val("");
						}
						
					}
			   }		
			}	
			for(var i = 0;i<usdepts.length;i++){
				usdepts[i].onclick=function(){
				$(this).addClass('selected').siblings().removeClass('selected');  
					if($(this).hasClass('selected')){
						usdept=$(this).text();
						if (usdept!='----------') {
							$("#userdept").val(usdept);
						}else{
							$("#userdept").val("");
						}
					}
			   }		
			}	
			
			
		}
	});
	
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
		
		parent.$("#dtype").val(arrayList[4]);//访问父页面元素值  
		parent.$("#dname").val(arrayList[1]);
		parent.$("#dnumber").val(arrayList[2]);
		parent.$("#dstandard").val(arrayList[3]);
		parent.$("#usedept").val(arrayList[5]);
		
		//关闭当前弹出层
		var index = parent.layer.getFrameIndex(window.name);  
		parent.layer.close(index);
	})
	
});

