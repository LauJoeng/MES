<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/processManagement/deleteData.js"></script>

	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				<label class="control-label"> 
				<span class="h4 font-thin v-middle" >工序</span></label>
				 <!-- <input class="input-medium ui-autocomplete-input" id="Spec" name="processName"> -->
				 <select id="processName" name="processName" class="input-medium ui-autocomplete-input" style="width: 180px;height: 25px;font-size: 14px;">
	    		</select>
	    		<!-- <br/> -->
	    		<span class="h4 font-thin v-middle" >组件条码</span></label>
				<input class="input-medium ui-autocomplete-input" id="module_code" name="module_code">
				<input class="input-medium ui-autocomplete-input"  value="分片" style="display:none"   id="processNameForExl" name="processNameForExl">
								
			</div>
			<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
			<a href="javascript:grid.exportData('/processManagement/deleteDataExport.shtml')" class="btn btn-info" id="search">导出excel</a>
			
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
