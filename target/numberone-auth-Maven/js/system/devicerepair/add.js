$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {//验证新增是否成功
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data == "success") {
						layer.confirm('添加成功!是否关闭窗口？', function(index) {
							parent.grid.loadData();
							parent.layer.close(parent.pageii);
							return false;
						});
						$("#form")[0].reset();
					}else if(data == "existing"){
						layer.alert('此设备已报修，请勿重复报修！', 3);
					}else {
						layer.alert('添加失败！', 3);
					}
				}
			});
		},
		rules : {
			"DeviceRepairFormMap.rp_number" : {
				required : true,
				remote : { // 异步验证是否存在
					type : "POST",
					url : 'isExist.shtml',
					data : {
						name : function() {
							return $("#rp_number").val();
						}
					}
				}
			}
		},
		messages : {
			"DeviceRepairFormMap.rp_number" : {
				required : "请输入单号",
				remote : "该报修单号已经存在"
			}
		},
		errorPlacement : function(error, element) {// 自定义提示错误位置
			$(".l_err").css('display', 'block');
			$(".l_err").html(error.html());
		},
		success : function(label) {// 验证通过后
			$(".l_err").css('display', 'none');
		}
	});
	
});




