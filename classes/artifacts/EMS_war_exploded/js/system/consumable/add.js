//单独验证某一个input  class="checkpass"
//jQuery.validator.addMethod("checkacc", function(value, element) {
//	return this.optional(element)
//			|| ((value.length <= 30) && (value.length >= 3));
//}, "规格类型由3至30位字符组合构成");
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
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
					}else {
						layer.alert('添加失败！', 3);
					}
				}
			});
		},
		rules : {
			"ConsumableFormMap.cname" : {
				required : true,
				remote : { // 异步验证是否存在
					type : "POST",
					url :  'isExist.shtml',
					data : {
						name : function() {
							return $("#cname").val();
						}
					}
				}
			}
		},
		messages : {
			"ConsumableFormMap.cname" : {
				required : "请输入设备编号",
				remote : "该设备编号已经存在"
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


