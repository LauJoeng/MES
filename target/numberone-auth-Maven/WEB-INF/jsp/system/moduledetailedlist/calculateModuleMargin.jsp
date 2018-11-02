<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/moduledetailedlist/calculateModuleMargin.js"></script>
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
			#moduleGrossMargin input{
				width:100px;
				 padding:2px;
			}

			#moduleGrossMargin_chackbasis span,#moduleGrossMargin_basis span{
			display:inline-block;
			width:80px;
			text-align:center;
			}
			#matertialBasicInfor #dosage,#matertialBasicInfor #itemUnit{
				width:60px;
			}
			#CostBasicInfor #checkbox,#no_CostBasicInfor #checkbox{
			width:20px;
			}
	</style>
	
	
	
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				<label class="control-label"> 
				<span class="h4 font-thin v-middle" style="width: 70px;display:inline-block;">订单号:</span></label>
	    		<input class="input-medium ui-autocomplete-input" id="order_no" name="order_no">
			</div>
<!-- 			<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
			<a href="javascript:void(0)" class="btn btn-default" id="calculate">计算</a>
			<a href="javascript:void(0)" class="btn btn-default" id="save_calculate" style="display:none">保存计算结果</a> -->
			
			<a href="javascript:void(0)" class="btn btn-default" id="increased">新增板材</a>
			<a href="javascript:void(0)" class="btn btn-default" id="calculate">计算</a>
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

					<td>数量</td>
					<td>瓦数</td>
					<td id="royalty_rate" style="display:none">提成率</td>
					<td id="gross_profit_margin" class="display_switch"		style="display:none">当月毛利额</td>
					<td id="gross_profit_rate" 	class="display_switch"			style="display:none">毛利率</td>
					<td id="orderNum_exchRate_margin" class="display_switch"		style="display:none"></td>
					<td id="orderNum_exchRate_unitPrice" class="display_switch"	 style="display:none"></td>
					<td id="orderNum_exchRate" class="display_switch" style="display:none"></td>
				</tr>
			</table>
	</div>

	<br>
	 <div id="moduleGrossMargin" style="display:none">
	 	<form >
	 		<label class="control-label"> 
			<span class="h4 font-thin v-middle" >板材信息:</span>
			</label>
			<a href="javascript:void(0)" class="btn btn-default" id="delete_button_moduleGrossMargin">删除板材</a>
			
	 		<div id="moduleGrossMargin_basis">
				<span>订单号:</span>
				<input class="input-medium ui-autocomplete-input" id="order_no" name="order_no">
				<span>板材编号:</span>
				<input class="input-medium ui-autocomplete-input" id="itemName" name="itemName" >
				<span>需求数量:</span>
				<input class="input-medium ui-autocomplete-input" id="orderNum" name="orderNum">
				<span>瓦数:</span>
				<input class="input-medium ui-autocomplete-input" id="exchRate" name="exchRate">
				<span>成本系数:</span>
				<input class="input-medium ui-autocomplete-input" id="cost_coefficient" name="cost_coefficient">
			</div>
			<div id="moduleGrossMargin_chackbasis">
			<span>外币价格:</span>
				<input class="input-medium ui-autocomplete-input" id="foreign_currency_prices" name="foreign_currency_prices">
				<span>外币汇率:</span>
				<input class="input-medium ui-autocomplete-input" id="foreign_currency_rate" name="foreign_currency_rate">
				
				<span>水电费:</span>
				<input class="input-medium ui-autocomplete-input" id="water_electricity" name="water_electricity">
				<span>人工费:</span>
				<input class="input-medium ui-autocomplete-input" id="cost_labor" name="cost_labor">
				<span>佣金提成率:</span>
				<input class="input-medium ui-autocomplete-input" id="commission_rate" name="commission_rate">
				<span>中信保费率:</span>
				<input class="input-medium ui-autocomplete-input" id="premium_rate" name="premium_rate">
				
				<br>
				
				<!-- <span>基础费用:</span>
				<input class="input-medium ui-autocomplete-input" id="basic_commission_premium" name="basic_commission_premium"> -->
				
				<span>海运费:</span>
				<input class="input-medium ui-autocomplete-input" id="sea" name="sea">
				<span>国内运费:</span>
				<input class="input-medium ui-autocomplete-input" id="inland" name="inland">
				<span>国外运费:</span>
				<input class="input-medium ui-autocomplete-input" id="foreign" name="foreign">
				<span>报废率:</span>
				<input class="input-medium ui-autocomplete-input" id="scrappage" name="scrappage">
				<span>提成系数:</span>
				<input class="input-medium ui-autocomplete-input" id="royalty_rate" name="royalty_rate">
			</div>
			<br>
					
			<div id="no_CostBasicInfor" >
				<label class="control-label"> 
					<span class="h4 font-thin v-middle" >非硅材料信息:</span>
				</label>
				<a href="javascript:void(0)" class="btn btn-default" id="increased_matertialBasicInfor">新增物料</a>
				<br>

			</div>

			
			<div id="CostBasicInfor" >
							<label class="control-label"> 
				<span class="h4 font-thin v-middle" >硅材料信息:</span>
			</label>
			<a href="javascript:void(0)" class="btn btn-default" id="increased_matertialBasicInfor">新增物料</a>
			<br>
				
			</div>
			
		</form>	
	</div> 
	<div id="showDiv" style="position: fixed; background-color: white; border: 1px solid black;">
	</div>

	
	


	
