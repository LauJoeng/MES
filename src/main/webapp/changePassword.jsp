<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/layer-v1.9.2/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery/jquery-validation/jquery.validate.min.js"></script>
	
 	<style type="text/css">
		.col-sm-3 {
			width: 25%;
			float: left;
		}
		.col-sm-9 {
			width: 75%;
			float: left;
		}
	</style>
		<script type="text/javascript" >
		$(function() {
			$(".btn").attr("disabled", true); 
		})
		function isAccountNameExit(){
			var accountName=$('#accountName').val();
			$.ajax({
				data:{accountName:accountName},
				async : false,
				dataType : 'json',
				type : 'POST',
				url : '${pageContext.servletContext.contextPath }/isAccountExist.shtml',
				error : function() {
					alert('账号不存在');
					$('#id').val('000');
					$(".btn").attr("disabled", true); 
					
				},
				success : function(data) {
					if(typeof(data.id) == "undefined"){
					alert("账号不存在")	;
					$('#id').val('000');
					$(".btn").attr("disabled", true); 
					}else{
						/* alert("id="+data.id); */
						$('#id').val(data.id);
						$(".btn").attr("disabled", false); 
					}
					
				}
			});
		}
	</script>
</head>
<body>
	<div>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>	
	<form id="formUpdatePwd" name="form" class="form-horizontal" method="post" action="${pageContext.servletContext.contextPath }/editPassword.shtml">
<%-- 		<input type="hidden" class="form-control checkacc" value="${userSession.id}" name="userFormMap.id" id="id">
		<input type="hidden" class="form-control checkacc" value="${userSession.accountName}" name="userFormMap.accountName" id="accountName">
		<input type="hidden" class="form-control checkacc" value="${userSession.password}" name="userFormMap.password" id="password"> --%>
		<input type="hidden" class="form-control checkacc" value="000" name="userFormMap.id" id="id">
		<section class="panel panel-default">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-3 control-label">账号</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" placeholder="请输入账号" name="userFormMap.accountName" id="accountName" onblur="isAccountNameExit()" >
					</div>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label">新密码</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" placeholder="请输入新密码" name="userFormMap.newpassword" id="newpassword" >
					</div>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label">确认密码</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" placeholder="请输入确认密码" name="userFormMap.confirmpassword" id="confirmpassword" >
					</div>
				</div>
			</div>
			<footer class="panel-footer text-right bg-light lter">
				<button type="submit" class="btn btn-success btn-s-xs">修改</button>
			</footer> 
		</section>
	</form>
	</div>	
	<script type="text/javascript" >
	
	//校验密码是否相同
	function same(pwd) {  
	    var oldPwd = $("#newpassword").val();  
	    if (oldPwd == pwd){
	    	return false;  
	    }else{
	    	//更改表单中确认密码的name的属性名
	    	$("#confirmpassword").attr("name","userFormMap.password");
	    	return true;
	    }  
	}

	jQuery.validator.addMethod("same", function(value, element) {  
	    return this.optional(element) || same(value);  
	}, "新密码和确认密码不一致"); 

	//加入数据校验证
	$(function() {
		$("#formUpdatePwd").validate({
			submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
				ly.ajaxSubmit(form, {// 验证新增是否成功
					type : "post",
					dataType : "json",//ajaxSubmi带有文件上传的。不需要设置json
					success : function(data) {
						if (data == "success") {
							layer.confirm('修改密码成功!是否关闭窗口?', function(index) {
								layer.close(index);
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
								parent.layer.close(index); //再执行关闭   
							});
						} else {
							layer.msg('修改密码失败！', {icon: 5});
						}
					}
				});
			},
			rules : {
				"userFormMap.newpassword" : {
					minlength: 6,
					required : true
				},
				"userFormMap.confirmpassword": {
					required : true,
					minlength: 6,
//					same:true, 
					equalTo: "#newpassword"
				}
			},
			messages : {
				"userFormMap.newpassword" : {
					required : "请输入新密码",
					minlength: jQuery.format("密码不能小于{0}个字 符")
				},
				"userFormMap.confirmpassword" : {
					required : "请输入确认密码",
					minlength: jQuery.format("密码不能小于{0}个字 符"),
					equalTo : "新密码和确认密码不一致"
				}
			},
			errorPlacement : function(error, element) {// 自定义提示错误位置
				$(".l_err").css('display', 'block');
				// element.css('border','3px solid #FFCCCC');
				$(".l_err").html(error.html());
			},
			success : function(label) {// 验证通过后
				$(".l_err").css('display', 'none');
			}
		});
	});
	</script>
	
</body>
</html>