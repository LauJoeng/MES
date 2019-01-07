<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/operationdate/moduleGrossMargin.js"></script>
	<style type="text/css">
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
	
	
	
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				<label class="control-label"> 
				<span class="h4 font-thin v-middle" style="width: 70px;display:inline-block;">订单号:</span></label>
				 <!-- <input class="input-medium ui-autocomplete-input" id="Spec" name="processName"> -->
				 <!-- <select id="order_no" name="order_no" class="input-medium ui-autocomplete-input" style="width: 100px;height: 25px;font-size: 14px;">
						
	    		</select> -->
	    		<input class="input-medium ui-autocomplete-input" id="order_no" name="order_no">
			</div>
			<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
			<a href="javascript:void(0)" class="btn btn-default" id="calculate">计算</a>
			
			<a href="javascript:grid.exportData('/operationData/selectDataExport.shtml')" class="btn btn-info" id="search">导出excel</a>
		</form>
	</div>

	<div style="overflow:scroll; overflow-y:hidden;">
			<table 	id="moduleGrossMargin_table" border="2" align="left"  >
				<tr id="tr_1">
					<td>订单号</td>
					<td>编号</td>
					<td id="unitPrice">单价</td>
					<td>①硅成本</td>
					<td>②非硅成本</td>
					<td>③水电费</td>
					<td>④人工费</td>
					<td>⑤海运费</td>
					<td>⑥中国国内运费</td>
					<td>⑦国外内陆运费</td>
					<td>⑧佣金</td>
					<td>⑨中信保费用</td>
					<td>⑩业务提成</td>
					<td id="royalty_rate" style="display:none">提成率</td>
					<td id="gross_profit_margin" style="display:none">当月毛利额</td>
					<td id="gross_profit_rate" style="display:none">毛利率</td>
					<td>数量</td>
					<td>瓦数</td>
					<td id="amount_wattage_margin" style="display:none"></td>
					<td id="amount_wattage_unitPrice" style="display:none"></td>
					<td id="amount_wattage" style="display:none"></td>
				</tr>
			</table>
	</div>
	<div id="showDiv" style="position: fixed; background-color: white; border: 1px solid black;">
	</div>

	<div class="table-responsive">
		<div id="paging" class="pagclass">
			
		</div>
	</div>
	
	<div class="table-responsive">
		<div id="paging2" class="pagclass"></div>
	</div>
	
