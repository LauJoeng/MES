var pageii = null;
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",//ajaxSubmi带有文件上传的。不需要设置json
				success : function(data) {
					if (data == "success") {
						layer.confirm('添加成功!是否关闭窗口？', function(index) {
							parent.grid.loadData();
							parent.layer.close(parent.pageii);
							return false;
						});
					}else {
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


