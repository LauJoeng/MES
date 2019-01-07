var pageii = null;
var grid = null;
$(function() {
	
	var ftype='';
 	$.ajax({
 		url:parent.rootPath+'/SpareParts/findallftype.shtml',
 		dataType:'json',
 		type:'post',
 		success:function(data){
 			
 			for (var i = 0; i <data.length; i++) {
 				$("#ftypelist").append('<li>'+data[i]+'</li>');
 			}
 			//获取所有li的节点
 			var ftypes = $("#ftypelist").children();
 			//给每个li绑定事件
 			for(var i = 0;i<ftypes.length;i++){
 				ftypes[i].onclick=function(){
 				$(this).addClass('selected').siblings().removeClass('selected');  
 					if($(this).hasClass('selected')){
 						ftype=$(this).text();
 						if (ftype!='----------') {
 							$("#ftype").val(ftype);
 						}else{
 							$("#ftype").val("");
 						}
 					}
 			   }		
 			}	
 			
 			
 		}
 	});
	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey : "fid",
			name : "配件编号"
		}, {
			colkey : "fname",
			name : "配件名称"
		}, 
		{
			colkey : "Spec",
			name : "规格型号"
		},{
			colkey : "ftype",
			name : "配件类型"
		}, {
			colkey : "fprice",
			isSort:true,
			name : "配件价格"
		}],
		jsonUrl : parent.rootPath+'/SpareParts/findByPage.shtml',
		checkbox : true,
		serNumber : true
	});
	$("#search").click("click", function() {// 绑定查询按扭
		alert("查询");
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
		for (var i = 0,j=0; i < arrayList.length; i++) {
			if (i%6==1) {
				parent.$("#addPart")
				.append('<tr><td><span class="removePart">删除</span></td><td>'+arrayList[i]+'</td><td>'+arrayList[i+1]+'</td><td>'+arrayList[i+2]+'</td><td class="partPrice">'+arrayList[i+4]+'</td><td><input type="number" name="fqtylist['+j+']" class="partNumber" value="0"/></td><td style="display:none;"><input type="text" name="fnolist['+j+']" value="'+arrayList[i]+'"></td><td style="display:none;"><input type="text" name="fnamelist['+j+']" value="'+arrayList[i+1]+'"></td><td style="display:none;"><input type="number" name="fpricelist['+j+']" value="'+arrayList[i+4]+'"></td></tr>');//访问父页面元素值
				j++;
			}	
		}
		
		
		parent.$(".removePart").click("click",function(){
			$(this).parent().parent().remove();
		})
		//关闭当前弹出层
		var index = parent.layer.getFrameIndex(window.name);  
		parent.layer.close(index);
	});
	
});

