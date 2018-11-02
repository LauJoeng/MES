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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/repairmanage/consumablelist.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/lyGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer-v1.9.2/layer/layer.js"></script>
<script type="text/javascript">
$(function(){
	
})

</script>
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
	
</style>
</head>
 <body>
 	<div class="container-fluid">
 		<div style="height: 650px;border: 1px solid blue;">
	  		<div class="col-sm-12" style="background-color: darkgray">
	  			<div class="m-b-md">
					<form class="form-inline" id="searchForm"
						name="searchForm">
						<div class="form-group">
							<label class="control-label"> <span
								class="h4 font-thin v-middle">名称:</span></label> <input
								class="input-medium ui-autocomplete-input" id="cname"
								name="consumableFormMap.cname">
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