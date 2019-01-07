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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/repairmanage/devicelist.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/lyGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer-v1.9.2/layer/layer.js"></script>

<style>
	.arrowright{
	
	}
	.arrowbottom{
	
		transform: rotate(90deg);
	}
	li{
		font-size: 15px;
		cursor:pointer;
		background-color: white;
	}
	.selected {  
	    color: #fff;  
	    background: rgba(59,181,182, 1);  
 	 } 
	.xxx{
	   background-color: white;
	}
</style>
<script type="text/javascript">
     $(function(){
     
     	$("#opendlist").bind("click",function(){
	     	  if($(this).attr('class')=="arrowright"){
				   $(this).removeClass("arrowright");
				   $(this).addClass("arrowbottom");
				   $("#dlist").show();
				        }else{
				      	$(this).removeClass("arrowbottom");
				    $(this).addClass("arrowright");
				    $("#dlist").hide();
			   }
         })
     	
     	$("#openusdept").bind("click",function(){
		   if($(this).attr('class')=="arrowright"){
			   $(this).removeClass("arrowright");
			   $(this).addClass("arrowbottom");
			   $("#usdept").show();
			        }else{
			      	$(this).removeClass("arrowbottom");
			    $(this).addClass("arrowright");
			    $("#usdept").hide();
		    }
		})
	});
</script>
</head>
 <body>
 	<div class="container-fluid">
 		<div style="height: 650px;border: 1px solid blue;">
	  		<div class="col-sm-3" style="text-align: center;padding-top: 8px;padding-bottom: 8px;padding-left: 8px;padding-right: 8px;">
		  			<div style="height: 300px;background-color: white;overflow: scroll;border: 1px solid blue;">
		  				<img id="opendlist" src="${pageContext.request.contextPath}/images/rightarrow.png" class="arrowright" width="20px"height="20px;"/><span style="font-size: 20px;">按设备类型</span><ul id="dlist" style="list-style-type: none;display: none;">			
		  				<li>----------</li></ul>
		  			</div>
	  				<div style="height: 20px;background-color: darkgray;" ></div>
		  			<div style="height: 300px;background-color: white;overflow: scroll;border: 1px solid blue;">
		  				<img id="openusdept" src="${pageContext.request.contextPath}/images/rightarrow.png" class="arrowright" width="20px"height="20px;"/><span style="font-size: 20px;">按使用部门</span><ul id="usdept" style="list-style-type: none;display: none;">
		  				<li>----------</li></ul>
		  			</div>
	  		</div>
	  		<div class="col-sm-9" style="background-color: darkgray">
	  			<div class="m-b-md">
					<form class="form-inline" id="searchForm"
						name="searchForm">
						<div class="form-group">
							<label class="control-label"> <span
								class="h4 font-thin v-middle">编号:</span></label> <input
								class="input-medium ui-autocomplete-input" id="number"
								name="deviceFormMap.number">
								<input id="typeid"  name="deviceFormMap.typeid" style="display: none;">
								<input id="userdept"  name="deviceFormMap.userdept" style="display: none;">
						</div>
						<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
					</form>
				</div>
  				<div style="background-color: white;height: 650px;">
			  		<div class="doc-buttons">
						<c:forEach items="${res}" var="key">
							${key.description}
						</c:forEach>
					</div>
					<div class="table-responsive">
						<div id="paging" class="pagclass"></div>
					</div>
					
					<div class="table-responsive">
						<div id="paging2" class="pagclass"></div>
					</div>
					<input type="button" id="submit" value="保存" style="margin-left: 88%;width:60px;font-size: 18px;background-color: #32CD32;"/>
  			    </div>
  		    </div>
  		   </div>
 	</div>
 	
</body>
</html>