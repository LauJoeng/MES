var pageii = null;
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			if($("#name").val()==""){
				layer.msg("请输入计划名称!");
				return;
			}
			var d1 = new Date();
			var d2 = new Date($("#plantime").val());
			var diff = d2.getTime()-d1.getTime();
			if($("#plantime").val()==""){
				layer.msg("请选择计划开始时间!");
				return;
			}
			if(diff<0){
				layer.msg("计划时间时间不能小于当前时间！");
				return;
			}
			if($("#repairman").val()==""){
				layer.msg("请选择点检人员!");
				return;
			}
			var dnumber = new Array();
			$(".dnumber").each(function(){
				dnumber.push($(this).text());
			})
			var dname = new Array();
			$(".dname").each(function(){
				dname.push($(this).text());
			})
			if(dnumber.length==0){
				layer.msg("请添加点检设备!");
				return;
			}
			//设备编号字符串集合
			var dnumberstr = "";
			for (var i = 0; i < dnumber.length; i++) {
				if(i==dnumber.length-1){
					dnumberstr = dnumberstr+dnumber[i];
				}else{
					dnumberstr = dnumberstr+dnumber[i]+",";
				}
			}
			//点检设备名称字符串集合
			var dnamestr = "";
			for (var i = 0; i < dname.length; i++) {
				if(i==dname.length-1){
					dnamestr = dnamestr+dname[i];
				}else{
					dnamestr = dnamestr+dname[i]+",";
				}
			}
			$("#dnumber").val(dnumberstr);
			$("#dname").val(dnamestr);
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
	});
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
		area : [ "600px", "100%" ],
		content : rootPath + '/inspect/selDeviceUI.shtml'
	});
}
//选择维修人员弹出框
function selrpmanDocument() {

	pageii = layer.open({
		title : "选择维修人员",
		type:2,
		area : [ "600px", "80%" ],
		content : rootPath + '/repairmanage/selrpmanUI.shtml'
	});
}


