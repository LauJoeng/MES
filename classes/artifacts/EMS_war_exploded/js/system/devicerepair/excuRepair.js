var pageii = null;

//如果返回true则说明符合规则
function checkDateTime(starttime,endtime){
    var oDate1 = new Date(starttime);
    var oDate2 = new Date(endtime);
    if(oDate1.getTime() <= oDate2.getTime()){
        return true;
    } else {
    	return false;
    }
}

$(function() {
	$("form").validate({
		//提交表单前的验证
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			var b=checkDateTime($("#start").val(),$("#stop").val());
			//维修人员不能为空
			if($("#repairman").val().trim()==""){
				layer.msg("请选择维修人员!");
				return;
			}
			if(!b){
				layer.msg("结束时间不能小于开始时间!");
				return;
			}
			//维护过程不能为空
			if($("#workinfo").val().trim()==""){
				layer.msg("请录入工作描述!");
				return;
			}
			
			var totalpartfee=0;//总配件费用
			var totalconsumablefee=0;//总消耗品费用
			var partNums=new Array();//各配件数量集合
			var consumableNums=new Array();//各消耗品数量集合
			$(".partNumber").each(function(){
				partNums.push($(this).val());
			});
			$(".consumableNumber").each(function(){
				consumableNums.push($(this).val());
			});
			var partPrice=new Array();//各配件价格集合
			var consumablePrice=new Array();//各消耗品价格集合
			$(".partPrice").each(function(){
				partPrice.push($(this).text());
			});
			$(".consumablePrice").each(function(){
				consumablePrice.push($(this).text());
			});
			for (var i = 0; i < partNums.length; i++) {
				totalpartfee += parseInt(partPrice[i])*partNums[i];
			}
			for (var i = 0; i < consumableNums.length; i++) {
				totalconsumablefee += parseInt(consumablePrice[i])*consumableNums[i];
			}
			$("#rp_cost").val(totalconsumablefee+totalpartfee);
	
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",//ajaxSubmi带有文件上传的。不需要设置json
				success : function(data) {
					if (data == "success") {
						layer.confirm('保存成功!是否关闭窗口?', function(index) {
							parent.grid.loadData();
							parent.layer.close(parent.pageii);
							return false;
						});
					} else {
						layer.msg('更新失败！', 3);
					}
				}
			});
		}
	});
	$("#seldevice").click("click",function(){
	
		selDeviceDocument();
	})
	$("#selrpman").click("click",function(){
	
		selrpmanDocument();
	})
	$("#addPartBt").click("click",function(){
	
		addPart();
	})
	
	$("#addConsumableBt").click("click",function(){
	
		addConsumable();
	})
	
});
//选择设备弹出框
function selDeviceDocument() {
	//弹出添加计划输入框
	pageii = layer.open({
		title : "选择设备",
		type:2,
		area : [ "800px", "100%" ],
		content : rootPath + '/repairmanage/selDeviceUI.shtml'
	});
}

//选择维修人员弹出框
function selrpmanDocument() {

	pageii = layer.open({
		title : "选择维修人员",
		type:2,
		area : [ "800px", "100%" ],
		content : rootPath + '/repairmanage/selrpmanUI.shtml'
	});
}
//选择配件弹出框
function addPart() {

	pageii = layer.open({
		title : "增加配件",
		type:2,
		area : [ "800px", "100%" ],
		content : rootPath + '/repairmanage/addPartUI.shtml'
	});
}
//选择消耗品弹出框
function addConsumable() {

	pageii = layer.open({
		title : "增加消耗品",
		type:2,
		area : [ "800px", "100%" ],
		content : rootPath + '/repairmanage/addConsumableUI.shtml'
	});
}

