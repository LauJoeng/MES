var pageii = null;
$(function() {
	$("#devicelist").click("click",function(){
		selDeviceDocument();
	})
	
});
//选择设备弹出框
function selDeviceDocument() {
	pageii = layer.open({
		title : "选择设备",
		type:2,
		area : [ "800px", "100%" ],
		content : rootPath + '/devicerepair/selDeviceUI.shtml'
	});
}



