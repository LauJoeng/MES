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
						layer.confirm('编辑成功!是否关闭窗口？', function(index) {
							parent.grid.loadData();
							parent.layer.close(parent.pageii);
							return false;
						});
						$("#form")[0].reset();
					}else {
						layer.alert('编辑失败！', 3);
					}
				}
			});
		},
	});
	
});


