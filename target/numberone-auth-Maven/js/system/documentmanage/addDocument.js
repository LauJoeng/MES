var pageii = null;
$(function() {
	
	$("#seldevice").click("click",function(){
		selDeviceDocument();
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



