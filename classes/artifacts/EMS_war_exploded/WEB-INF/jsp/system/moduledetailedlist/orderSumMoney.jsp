<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/moduledetailedlist/orderSumMoney.js"></script>
	<!-- <style type="text/css">
			table,th,td{
				border:1px solid #328AA4;
			}
			td input{
				border:none;
				width:100%;
				height:100%;
				text-align:center;
			}
			td {
			width:120px;
			height:50px;
			text-align:center;
			/* align:center; */
			}
			table {
			width:100%;
			 table-layout: fixed; 
			 word-break:break-all;
			`overflow:false; 
			 white-space:nowrap; 
			 
			} 
			
	</style>
			-->



	
	
	
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
 				<span class="h4 font-thin v-middle" >开始时间:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="starttime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="starttime">
				 <span class="h4 font-thin v-middle" >结束时间:</span></label>
				 <input class="input-medium ui-autocomplete-input" id="endtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="endtime">
	
			<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>

		</form>
	</div>

<!-- 	<div style="overflow:scroll; overflow-y:hidden;">
			<table 	id="moduleGrossMargin_table" border="2" align="left"  >
				<tr>
					<td>订单号</td>
					<td>成本</td>
				</tr>
				
			</table>
	</div> -->
	
	<div class="table-responsive">
		<div id="paging" class="pagclass"></div>
	</div>
	
	<div class="table-responsive">
		<div id="paging2" class="pagclass"></div>
	</div>

	
	
	


	
