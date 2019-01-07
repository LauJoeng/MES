var pageii = null;
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			if($("#inspectinfo").val()==""){
				layer.msg("请输入点检项目内容!");
				return;
			}
			if($("#inspectrule").val()==""){
				layer.msg("请输入点检参考值!");
				return;
			}
			var dnumber = new Array();
			$(".dnumber").each(function(){
				dnumber.push($(this).text());
			})
			if(dnumber.length==0){
				layer.msg("请添加适用设备!");
				return;
			}
			//适用设备字符串集合
			var dnumberstr = "";
			for (var i = 0; i < dnumber.length; i++) {
				if(i==dnumber.length-1){
					dnumberstr = dnumberstr+dnumber[i];
				}else{
					dnumberstr = dnumberstr+dnumber[i]+",";
				}
			}
			$("#applydevice").val(dnumberstr);
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

});
//选择设备弹出框
function selDeviceDocument() {
	//弹出添加计划输入框
	pageii = layer.open({
		title : "选择设备",
		type:2,
		area : [ "600px", "100%" ],
		content : rootPath + '/inspect/selDeviceUI.shtml'
	});
}



