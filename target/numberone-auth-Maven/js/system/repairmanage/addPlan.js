var pageii = null;
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			if($("#dname").val()==""){
				layer.msg("请选择设备！");
				return;
			}
			if($("#repairman").val()==""){
				layer.msg("请选择维修人员！");
				return;
			}
			if($("#repaircycle").val()==""){
				layer.msg("请选择维护周期！");
				return;
			}
			var d1 = new Date();
			var d2 = new Date($("#plantime").val());
			var diff = d2.getTime()+8*1000*60*60-d1.getTime();
			
			if($("#plantime").val()==""){
				layer.msg("请输入计划开始时间！");
				return;
			}
			if(diff<0){
				layer.msg("计划时间时间不能小于当前时间！");
				return;
			}
			if($("#planinfo").val()==""){
				layer.msg("请输入计划描述！");
				return;
			}
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data == "success") {
						layer.confirm('添加成功!是否关闭窗口?', function(index) {
							parent.grid.loadData();
							parent.layer.close(parent.pageii);
							return false;
						});
						$("#form")[0].reset();
					} else {
						layer.alert('添加失败！', 3);
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


