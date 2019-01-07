<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/bootstrap.min.js">
		</script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/js/date/bootstrap.min.css" />
        <style>
        	td{
        		border: 1px solid grey;
        		font-size: 25px;
        		color: black;
        	}
        	.checkbx{
        		width: 25px;
        		height: 25px;
        	}
        </style>
            <script type="text/javascript">
            $(function(){
            	$.ajax({
            		url:"${pageContext.request.contextPath}/user/selrpman.shtml",
            		dataType:"json",
            		success:function(data){
            			for (var i = 0; i < data.length; i++) {
            				$("#tbo").append("<tr><td><input type='checkbox' name='rpman' class='checkbx'/></td><td>"+data[i]+"</td></tr>");
						}
            			$("#cancle").click(function(){
            				//关闭当前弹出层
            				var index = parent.layer.getFrameIndex(window.name);  
            				parent.layer.close(index);
            			});
            			var rpmanArray=new Array();
            			var rpman="";
            			$("#submit").click(function(){
            				$("input[type='checkbox']:checked").each(function(){
            					rpmanArray.push($(this).parent().siblings().html());
            				});
            				for (var i = 0; i < rpmanArray.length; i++) {
            					if(i!=rpmanArray.length-1){
            						rpman=rpman+rpmanArray[i]+",";
            					}else{
            						rpman=rpman+rpmanArray[i];
            					}
							}
            				parent.$("#repairman").val(rpman);
            				//关闭当前弹出层
            				var index = parent.layer.getFrameIndex(window.name);  
            				parent.layer.close(index);
            			});
            		}
            		
            	});
            	
            })
        
            </script>
</head>

<body>
			<div class="container-fluid">
    		<table width="100%" style="border: 1px solid blue;border-collapse: collapse;text-align: center;">
    			<thead>
	    		<tr>
	    			<td></td>
	    			<td>姓名</td>
	    		</tr>
	    		</thead>
	    		<tbody id="tbo">
	    		</tbody>
    			
    		</table>
    		<div class="col-sm-4">
    			<input type="button"  id="submit" value="保存"  style="width: 80px;height: 40px;margin-left: 80%;"/>
    		</div>
    		<div class="col-sm-8">
    			<input type="button" id="cancle" value="取消"  style="width: 80px;height: 40px;margin-left: 80%;"/>
    		</div>
    		</div>
</body>
</html>