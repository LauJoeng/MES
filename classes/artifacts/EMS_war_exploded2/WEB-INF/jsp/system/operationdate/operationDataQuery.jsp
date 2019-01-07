<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<%-- <title>员工操作数据查询</title>
<link href="${pageContext.request.contextPath}/js/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.css" rel="stylesheet"> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
 --%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/operationdate/operationDataQuery.js"></script>

	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				<label class="control-label"> 
				<span class="h4 font-thin v-middle" style="width: 40px;display:inline-block;">工序</span></label>
				 <!-- <input class="input-medium ui-autocomplete-input" id="Spec" name="processName"> -->
				 <select id="OperationDataFormMap.process" name="OperationDataFormMap.process" class="input-medium ui-autocomplete-input" style="width: 100px;height: 25px;font-size: 14px;">
						
	    		</select>
				 <span class="h4 font-thin v-middle" style="width: 60px;display:inline-block;height: 25px;">员工号:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="OperationDataFormMap.op" name="OperationDataFormMap.op">
				<!--  <br/> -->
				 <span class="h4 font-thin v-middle" >操作时间:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="OperationDataFormMap.begintime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="OperationDataFormMap.begintime">
				 <span class="h4 font-thin v-middle" >到:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="OperationDataFormMap.endtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="OperationDataFormMap.endtime">
			</div>
			<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
			<a href="javascript:grid.exportData('/operationData/selectDataExport.shtml')" class="btn btn-info" id="search">导出excel</a>
		</form>
	</div>
	<header class="panel-heading">
	<div class="doc-buttons">
		<c:forEach items="${res}" var="key">
			${key.description}
		</c:forEach>
	</div>
	</header>
	<div class="table-responsive">
		<div id="paging" class="pagclass"></div>
	</div>
	
	<div class="table-responsive">
		<div id="paging2" class="pagclass"></div>
	</div>
<!-- <script type="text/javascript">
	//在浏览器打印输出的意思
	console.log(processName);
	
	$(function() {
		//点击查询按钮触发请求数据
		$("#button").click(function(){
			var processName = $("#processName option:selected").html();
			var op = $("#op").val();
			var begintime = $("#begintime").val();
			var endtime = $("#endtime").val();
			
			if(op != null && op != '' && begintime != null && begintime != '' && endtime != null && endtime != ''){
				$.ajax({
					url : '../optionDataQuery/selectDataQuery.do',
					type : "POST",
					//把需要的数据传到后台
					data : {
						"processName" : processName,
						"op" : op,
						"begintime" : $("#begintime").val(),
						"endtime" : $("#endtime").val()
					},
					dataType : "json",
					async : true,
					success : function(data) {
						$("#operationDataQueryList tr td")
								.remove();//每次点击查询都把前面的查询结果数据清除，重新心事新数据
						$("#totalNums").html(data.length);//显示查询到的结果有几条
						for (var i = 0; i < data.length; i++) {
							$("#operationDataQueryList").append(
											'<tr><td class="ptd" style="text-align:center;">'
													+ data[i].module_code
													+ '</td><td class="ptd" style="text-align:center;">'
													+ data[i].optime
													+ '</td>');
						}
					},
					error : function() {
						alert("请求失败");
					}
				})
			}else{
				alert("请输入员工号及操作时间");
				return ;
			}
		});
	})
</script> -->
