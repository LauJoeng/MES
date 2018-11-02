var pageii = null;
var grid = null;
$(function() {
	grid = lyGrid({
		pagId : 'paging',
		l_column : [{
			colkey : "cname",
			name : "名称"
		}, {
			colkey : "unit",
			name : "单位"
		}, 
		{
			colkey : "price",
			name : "价格",
			isSort:true
		},{
			colkey : "specifications",
			name : "规格"
		}],
		jsonUrl : parent.rootPath+'/consumable/findByPage.shtml',
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
		for (var i = 0,j=0; i < arrayList.length; i++) {
			if (i%5==1) {
				parent.$("#addConsumable")
				.append('<tr><td><span class="removeConsumable">删除</span></td><td>'+arrayList[i]+'</td><td>'+arrayList[i+1]+'</td><td class="consumablePrice">'+arrayList[i+2]+'</td><td>'+arrayList[i+3]+'</td><td><input type="number" name="cqtylist['+j+']" value="0" class="consumableNumber"/></td><td style="display:none;"><input type="text" name="cnamelist['+j+']" value="'+arrayList[i]+'"></td><td style="display:none;"><input type="text" name="unitlist['+j+']" value="'+arrayList[i+1]+'"></td><td style="display:none;"><input type="number" name="pricelist['+j+']" value="'+arrayList[i+2]+'"></td></tr>');//访问父页面元素值  
				j++;
			}	
		}
		
		parent.$(".removeConsumable").click("click",function(){
			alert("点击了删除");
			$(this).parent().parent().remove();
		})
		//关闭当前弹出层
		var index = parent.layer.getFrameIndex(window.name);  
		parent.layer.close(index);
	});
	
});

