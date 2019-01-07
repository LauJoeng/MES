
var context_data={};
context_data.matertialInforList=[];
var tr_length;
var tr_id;//选中了第几行
var no_CostBasicInfor_name=["互联条","汇流条","EVA","玻璃","背板","铝材","接线盒体","密封硅胶","条码","标签","包装材料","其他"];
var CostBasicInfor_name=["电池"];
/*
 * total_gross_margin 总毛利率
 * average_gross_profit  平均毛利率
 * sum_orderNum_exchRate_margin
 * sum_orderNum_exchRate_unitPrice
 * sum_orderNum_exchRate
 */
$(function() {

	$("#increased").click("click",function(){
		order_no=$(".form-group #order_no").val();
		if(order_no==null||order_no==""){
			alert("订单号不能为空！");
		}else{
			$("#moduleGrossMargin_table #tr_calculate").remove();//移除计算结果
			$(".display_switch").hide();//隐藏原来disable的元素			
			context_data.order_no=order_no;
			increased_tr();
			click_tr();
			//同时出发click事件；
			$("#moduleGrossMargin_table tr").eq(-1).click();
		}
		
	});
	
	var increased_tr=function(){
		 tr_length=$("#moduleGrossMargin_table tr").length;
		$("#moduleGrossMargin_table").append("<tr id="+"tr_"+(tr_length+1)+">"
				+"<td id="+"order_no"+">"+context_data.order_no+"</td>"
				+"<td id="+"itemName"+">"+"</td>"
				+"<td id="+"unitPrice"+">"+"</td>"
				+"<td id="+"cost_silicon"+">"+"</td>"
				+"<td id="+"no_cost_silicon"+">"+"</td>"
				+"<td id="+"water_electricity"+">"+"</td>"
				+"<td id="+"cost_labor"+">"+"</td>"
				+"<td id='sea'>"+"<span></span>"+"</td>"
				+"<td id='inland'>"+"<span></span>"+"</td>"
				+"<td id='foreign'>"+"<span></span>"+"</td>"
				+"<td id="+"commission"+">"+"</td>"
				+"<td id="+"premium"+">"+"</td>"
				+"<td id="+"royalty"+">"+""+"</td>"
				+"<td id="+"orderNum"+">"+"</td>"
				+"<td id="+"exchRate"+">"+"</td>"
				+"<td id="+"royalty_rate style=display:none"+">"+"</td>"
				+"<td id=gross_profit_margin class='display_switch'	 style=display:none></td>"
				+"<td id=gross_profit_rate class='display_switch'  style=display:none></td>"
				+"<td id='orderNum_exchRate_margin' class='display_switch' style=display:none></td>"
				+"<td id='orderNum_exchRate_unitPrice' class='display_switch' style=display:none></td>"
				+"<td id='orderNum_exchRate' class='display_switch' style=display:none></td>"
				 +"</tr>");
		var matertialInfor={"order_no":order_no,"tr_id":tr_length+1,"cost_coefficient":1.15,"sum_no_cost_silicon":0,"sum_cost_silicon":0};
		
		//上下文中添加物料默认值
		matertialInfor.no_CostBasicInfor=[];
		matertialInfor.CostBasicInfor=[];
		$.each(no_CostBasicInfor_name,function(i,val){
			matertialInfor.no_CostBasicInfor[i]={"itemName":val,"dosage":"","wasteRate":"","taxPrice":"","dosage_wasteRate":"","check_pitch":true,"no_cost_silicon":0};
		});
		$.each(CostBasicInfor_name,function(i,val){
			matertialInfor.CostBasicInfor[i]={"itemName":val,"dosage":"","wasteRate":"","taxPrice":"","dosage_wasteRate":"","check_pitch":true,"cost_silicon":0};
		});
		
		(context_data.matertialInforList).push(matertialInfor);
	}
	var click_increasedMatertial=function(){
		$("[id=increased_matertialBasicInfor]").unbind("click");//移除多重绑定事件
		$("[id=increased_matertialBasicInfor]").click("click",function(){
			var string="";
			 string="<div>"+
			"<input name='checkbox' id='checkbox' checked='checked' type='checkbox'  />"+
			"<span> 物料名称:</span><input id='itemName' name='itemName' value='其他' ></input>"+
			"<span> 单耗:</span><input name='dosage' id='dosage'></input>"+
			"<span> 损耗率:</span><input id='wasteRate' ></input>"+
			"<span> 标准用量:</span><input id='dosage_wasteRate' disabled='disabled' ></input>"+
			"<span> 单价:</span><input id='taxPrice' ></input>"+
			"</div>"
			$(this).parent().append(string);
			var div_id= $(this).parent().attr("id");
			var increasedMatertial={"itemName":"其他","dosage":"","wasteRate":"","taxPrice":"","dosage_wasteRate":"","check_pitch":true}
			if(div_id=="no_CostBasicInfor"){
				increasedMatertial["no_cost_silicon"]=0;
			}else{
				increasedMatertial["cost_silicon"]=0;
			}
			
			context_data.matertialInforList[tr_id-1][div_id].push(increasedMatertial)
			blur_input_costInfor();//添加失去焦点按钮
		});
	}
	var add_matertialDiv=function(val){
		var string="<div>"+
		"<input name='checkbox' id='checkbox' checked='checked' type='checkbox'  />"+
		"<span> 物料名称:</span><input id='itemName' value="+val.itemName+" ></input>"+
		"<span> 单耗:</span><input id='dosage'value="+val.dosage+"></input>"+
		"<span> 损耗率:</span><input id='wasteRate' value="+val.wasteRate+"></input>"+
		"<span> 标准用量:</span><input id='dosage_wasteRate'  disabled='disabled' value="+val.dosage_wasteRate+" ></input>"+
		"<span> 单价:</span><input id='taxPrice' value="+val.taxPrice+"></input>"+
		"</div>"
		return string
	}
	var click_tr=function(){
		$("#moduleGrossMargin_table tr:not(:first)").unbind("click");
		$("#moduleGrossMargin_table tr:not(:first)").click("click", function() {
			tr_id= $(this).index();
			var matertialInfor=context_data.matertialInforList[tr_id-1]
			//先清空表格数据 再 从上下文中取值 
			$("#no_CostBasicInfor div").remove();
			$("#CostBasicInfor div").remove();
			$.each(matertialInfor.no_CostBasicInfor,function(i,val){
			$("#no_CostBasicInfor").append(add_matertialDiv(val));
			})
			$.each(matertialInfor.CostBasicInfor,function(i,val){
				$("#CostBasicInfor").append(add_matertialDiv(val));
			})
			
			$("#moduleGrossMargin_basis input[id='order_no']").val(context_data.order_no);
			$("#moduleGrossMargin_basis input[id='order_no']").attr("disabled","disabled");
			$("#matertialBasicInfor input:not(#taxPrice,#checkbox)").attr("disabled","disabled");
			$("#moduleGrossMargin").show();
			blur_input();//绑定失去焦点事件
			blur_input_costInfor();//绑定失去按钮
			click_assignment();//清空原有的数据 插入上下文的数据
			click_increasedMatertial();//增加行数按钮
			click_delete_button();//绑定删除按钮事件
			$("#moduleGrossMargin_basis #itemName").focus();
		})
	}
	var click_delete_button=function(){
		$("#delete_button_moduleGrossMargin").unbind("click");
		$("#delete_button_moduleGrossMargin").click("click",function(){
			if(confirm("确定删除该板材?")){
				
				$("#moduleGrossMargin_table #tr_calculate").remove();
				$("#moduleGrossMargin_table .display_switch").hide();
				context_data.matertialInforList.splice(tr_id-1,1);
				$("#moduleGrossMargin_table tr").eq(tr_id).remove();
				$("#moduleGrossMargin").hide();
				$("#moduleGrossMargin_table tr").eq(-1).click();
			}
			
			
		});
	}

	var click_assignment=function(){
		$("#moduleGrossMargin_basis input,#moduleGrossMargin_chackbasis input").val("");
		var matertialInfor=context_data.matertialInforList[tr_id-1];
		$.each(matertialInfor,function(i,val){
			$("#moduleGrossMargin_basis,#moduleGrossMargin_chackbasis").find("#"+i).val(val);
		})
	}
	var blur_input=function(){
		$(" #moduleGrossMargin_basis input, #moduleGrossMargin_chackbasis input").not("#checkbox").blur(function(event){
			var value=$(this).val();
			var id=$(this).attr("id");
			var pattern_chin=/^(\-|\+)?\d+(\.\d+)?$/g;
			if(id!="itemName"){
				if(value.match(pattern_chin)==null){
					if(value!=""){
						$(this).val("");
						value="";
						alert("请输入数字!");
					}
				}
			
			}
			/*alert(id+"  "+value);*/
			//给上下文赋值
			var matertialInfor=context_data.matertialInforList[tr_id-1];
			if(id=="water_electricity"||id=="cost_labor"){
				
				value=(value/(matertialInfor["exchRate"])).toFixed(4);
				/*$(this).val(value);*/
			}
			if(id=="sea"||id=="inland"||id=="foreign"){
				
				value=(value/(matertialInfor["exchRate"]*(matertialInfor["orderNum"]))).toFixed(4);
				/*$(this).val(value);*/
			}
			
			
			matertialInfor[id]=value;
			//给输入框赋值
			$("#moduleGrossMargin_table tr").eq(tr_id).find("#"+id).html(value);
			
			//瓦数和数量的改变会修改  水电 人工  海运费 内陆费  国外 费用 从而再修改业务提成
			if(id=="exchRate"||id=="orderNum"){
				var water_electricity=($("#moduleGrossMargin_chackbasis #water_electricity").val())/matertialInfor["exchRate"];
				var cost_labor=($("#moduleGrossMargin_chackbasis #cost_labor").val())/matertialInfor["exchRate"];
				var sea=($("#moduleGrossMargin_chackbasis #sea").val())/matertialInfor["exchRate"]/matertialInfor["orderNum"];
				var inland=($("#moduleGrossMargin_chackbasis #inland").val())/matertialInfor["exchRate"]/matertialInfor["orderNum"];
				var foreign=($("#moduleGrossMargin_chackbasis #foreign").val())/matertialInfor["exchRate"]/matertialInfor["orderNum"];
				
				matertialInfor["water_electricity"]=water_electricity.toFixed(3);
				matertialInfor["cost_labor"]=cost_labor.toFixed(3);
				matertialInfor["sea"]=sea.toFixed(3);
				matertialInfor["inland"]=inland.toFixed(3);
				matertialInfor["foreign"]=foreign.toFixed(3);
				$("#moduleGrossMargin_table tr").eq(tr_id).find("#water_electricity").html(water_electricity.toFixed(3));
				$("#moduleGrossMargin_table tr").eq(tr_id).find("#cost_labor").html(cost_labor.toFixed(3));
				$("#moduleGrossMargin_table tr").eq(tr_id).find("#sea").html(sea.toFixed(3));
				$("#moduleGrossMargin_table tr").eq(tr_id).find("#inland").html(inland.toFixed(3));
				$("#moduleGrossMargin_table tr").eq(tr_id).find("#foreign").html(foreign.toFixed(3));
				
				
			}
			
			//根据输入框的ID变换TABLE值
			var royalty_change_id=["royalty_rate","sea","foreign_currency_prices","foreign_currency_rate","commission_rate","premium_rate","exchRate","orderNum"];
			//这些ID的值改变会改动其他的值
			if(royalty_change_id.indexOf(id)>=0){
				var royalty_rate=matertialInfor["royalty_rate"]== undefined?0:matertialInfor["royalty_rate"];
				var sea=matertialInfor["sea"]== undefined?0:matertialInfor["sea"];
				var foreign_currency_prices=matertialInfor["foreign_currency_prices"]== undefined?0:matertialInfor["foreign_currency_prices"];
				var foreign_currency_rate=matertialInfor["foreign_currency_rate"]== undefined?0:matertialInfor["foreign_currency_rate"];
				var commission_rate=matertialInfor["commission_rate"]== undefined?0:matertialInfor["commission_rate"];
				var premium_rate=matertialInfor["premium_rate"]== undefined?0:matertialInfor["premium_rate"];
				var unitPrice//单价
				var commission//佣金
				var premium//保费
				var royalty//提成
				unitPrice=foreign_currency_prices*foreign_currency_rate;
				commission=foreign_currency_rate*commission_rate;
				premium=foreign_currency_rate*commission_rate;
				royalty=(unitPrice-commission-sea)*royalty_rate;
				matertialInfor["unitPrice"]=unitPrice;
				matertialInfor["commission"]=commission;
				matertialInfor["premium"]=premium;
				matertialInfor["royalty"]=royalty;
				$("#moduleGrossMargin_table tr").eq(tr_id).find("#unitPrice").html(unitPrice);
				$("#moduleGrossMargin_table tr").eq(tr_id).find("#commission").html(commission);
				$("#moduleGrossMargin_table tr").eq(tr_id).find("#premium").html(premium);
				$("#moduleGrossMargin_table tr").eq(tr_id).find("#royalty").html(royalty);
			}
			if(id=="exchRate"||id=="cost_coefficient"||id=="scrappage"){
				change_cost_silicon(matertialInfor);
			}

		});
	}

	
	var blur_input_costInfor=function(){
		$(" #no_CostBasicInfor input, #CostBasicInfor input").unbind("blur");
		$("#moduleGrossMargin [id=checkbox]").unbind("click");
		$(" #no_CostBasicInfor input, #CostBasicInfor input").not("#checkbox").blur(function(event){
			var matertialInfor=context_data.matertialInforList[tr_id-1];
			var CostBasicInforList=matertialInfor.CostBasicInfor;
			var no_CostBasicInforList=matertialInfor.no_CostBasicInfor;
			var id=$(this).attr("id");//获取点击框的ID
			var val=eval($(this).val());
			$(this).val(val)
			$(this).parent("div")
			/*var pattern_chin=/^(\-|\+)?\d+(\.\d+)?$/g;*/
			
			/*if(id!="itemName"){
				if(val.match(pattern_chin)==null){
					if(val!=""){
						$(this).val("");
						val="";
						alert("请输入数字!");
					}
				}
			
			}*/
			
			var div_id=$("#no_CostBasicInfor div").index($(this).parent("div"));
			if(div_id>-1){//判断失去焦点的框是否在非硅材料
				var no_CostBasicInfor=no_CostBasicInforList[div_id];
				no_CostBasicInfor[id]=val;
				//
				var dosage_wasteRate=(no_CostBasicInfor.dosage)*( Number(no_CostBasicInfor.wasteRate)+1);
				no_CostBasicInfor.dosage_wasteRate=dosage_wasteRate;
				$(this).siblings("#dosage_wasteRate").val(dosage_wasteRate);
				no_CostBasicInfor["no_cost_silicon"]=dosage_wasteRate*(no_CostBasicInfor.taxPrice);
				/*var check_pitch=no_CostBasicInfor.check_pitch; 判断是否选中 */
				
			}else{
				div_id=$("#CostBasicInfor div").index($(this).parent("div"));
				var CostBasicInfor=	CostBasicInforList[div_id];
				CostBasicInfor[id]=val;
				var dosage_wasteRate=(CostBasicInfor.dosage)*( Number(CostBasicInfor.wasteRate)+1);
				CostBasicInfor.dosage_wasteRate=dosage_wasteRate;
				$(this).siblings("#dosage_wasteRate").val(dosage_wasteRate);
				CostBasicInfor["cost_silicon"]=dosage_wasteRate*(CostBasicInfor.taxPrice);	
			}
			//遍历点击的元素 相加给上下文赋值sum_no_cost_silicon sum_cost_silicon
			var no_cost_silicon;
			var cost_silicon;
			matertialInfor.sum_no_cost_silicon=0;
			matertialInfor.sum_cost_silicon=0;
			$.each(no_CostBasicInforList,function(i,val){
				if(val.check_pitch){
				no_cost_silicon=val.no_cost_silicon;
				matertialInfor.sum_no_cost_silicon=matertialInfor.sum_no_cost_silicon+no_cost_silicon;
				}
			}) 
			$.each(CostBasicInforList,function(i,val){
				if(val.check_pitch){
				cost_silicon=val.cost_silicon;
				matertialInfor.sum_cost_silicon=matertialInfor.sum_cost_silicon+cost_silicon;
				}
			}) 
			
/*			matertialInfor.sum_no_cost_silicon=900;
			matertialInfor.sum_cost_silicon=1000;*/
			change_cost_silicon(matertialInfor);
		});
		$("#moduleGrossMargin [id=checkbox]").click("click",function(){
			//ture 由没选中到选中 则要添加值到上下文 false由选中到没选中 则要在上下文减去
			var matertialInfor=context_data.matertialInforList[tr_id-1];
			var no_CostBasicInforList=matertialInfor.no_CostBasicInfor;			
			var CostBasicInforList=matertialInfor.CostBasicInfor;
			
			var div_id=$("#no_CostBasicInfor div").index($(this).parent("div"));
			if(div_id>-1){//判断失去焦点的框是否在非硅材料
				var no_CostBasicInfor=no_CostBasicInforList[div_id];
				no_CostBasicInfor["check_pitch"]=$(this).is(':checked');
				if($(this).is(':checked')){
					matertialInfor.sum_no_cost_silicon=matertialInfor.sum_no_cost_silicon+no_CostBasicInfor.no_cost_silicon;
				}else{
					matertialInfor.sum_no_cost_silicon=matertialInfor.sum_no_cost_silicon-no_CostBasicInfor.no_cost_silicon;
				}
					
			}else{
				div_id=$("#CostBasicInfor div").index($(this).parent("div"));
				var CostBasicInfor=	CostBasicInforList[div_id];
				CostBasicInfor["check_pitch"]=$(this).is(':checked');
				if($(this).is(':checked')){
					matertialInfor.sum_cost_silicon=matertialInfor.sum_cost_silicon+CostBasicInfor.cost_silicon;
				}else{
					matertialInfor.sum_cost_silicon=matertialInfor.sum_cost_silicon-CostBasicInfor.cost_silicon;
				}
				
			}
			change_cost_silicon(matertialInfor);
		})
		$("input:not(:disabled)").not("#checkbox").bind("keydown",function(e){
		if (e.which == 13){
			var inputs=$("input:not(:disabled)").not("#checkbox");
			
			e.preventDefault(); //Skip default behavior of the enter key
	          var nextIndex = inputs.index(this) + 1;
	          n=inputs.length;
	          if(nextIndex < n)
	        	  inputs[nextIndex].focus();
	          else
	        	  inputs[nextIndex-1].blur();
		}
		})
		
	}
	var change_cost_silicon=function(matertialInfor){
		var exchRate=matertialInfor["exchRate"]== undefined?0:matertialInfor["exchRate"];
		var cost_coefficient=matertialInfor["cost_coefficient"]== undefined?0:matertialInfor["cost_coefficient"];
		var scrappage=matertialInfor["scrappage"]== undefined?0:matertialInfor["scrappage"];
		var sum_cost_silicon=matertialInfor["sum_cost_silicon"]== undefined?0:matertialInfor["sum_cost_silicon"];
		var sum_no_cost_silicon=matertialInfor["sum_no_cost_silicon"]== undefined?0:matertialInfor["sum_no_cost_silicon"];
		var cost_silicon;//硅成本
		var no_cost_silicon;//非硅成本
		
		cost_silicon=(sum_cost_silicon*(1+scrappage)/exchRate/cost_coefficient).toFixed(4);
		no_cost_silicon=(sum_no_cost_silicon*(1+scrappage)/exchRate/cost_coefficient).toFixed(4);
		matertialInfor.cost_silicon=cost_silicon;
		matertialInfor.no_cost_silicon=no_cost_silicon;
		
		$("#moduleGrossMargin_table tr").eq(tr_id).find("#cost_silicon").html(cost_silicon);
		$("#moduleGrossMargin_table tr").eq(tr_id).find("#no_cost_silicon").html(no_cost_silicon);
	}
	/*
	 * total_gross_margin 总毛利率
	 * average_gross_profit  平均毛利率
	 * sum_orderNum_exchRate_margin
	 * sum_orderNum_exchRate_unitPrice
	 * sum_orderNum_exchRate
	 * gross_profit_margin 当月毛利额
	 * gross_profit_rate 毛利率
	 */
	$("#calculate").click("click",function(){
		mouserover_out();
		$("#moduleGrossMargin_table #tr_calculate").remove();
		var matertialInforList= context_data.matertialInforList;//全部板材
		context_data.sum_orderNum_exchRate_margin=0;
		context_data.sum_orderNum_exchRate_unitPrice=0;
		context_data.sum_orderNum_exchRate=0;
		$.each(matertialInforList,function(i,val){//
			
/*			var gross_profit_margin=(val.unitPrice)-(val.cost_silicon)- val.no_cost_silicon- val.water_electricity- val.cost_labor-val.sea-val.inland-val.foreign-val.commission-val.premium-val.royalty;
*/			
			var gross_profit_margin=(val.unitPrice)-(val.cost_silicon)-(val.no_cost_silicon)-( val.water_electricity)-( val.cost_labor)-(val.sea)-(val.inland)-(val.foreign)-(val.commission)-(val.premium)-(val.royalty);
			var gross_profit_rate=(gross_profit_margin/(val.unitPrice)).toFixed(6);
		
			matertialInforList[i].gross_profit_margin=gross_profit_margin;
			matertialInforList[i].gross_profit_rate=gross_profit_rate;
			
			var orderNum_exchRate_margin=(val.gross_profit_margin*val.exchRate*val.orderNum).toFixed(4);
			var orderNum_exchRate_unitPrice=(val.unitPrice*val.exchRate*val.orderNum).toFixed(4);
			var orderNum_exchRate=(val.exchRate*val.orderNum);
			matertialInforList[i].orderNum_exchRate_margin=orderNum_exchRate_margin;
			matertialInforList[i].orderNum_exchRate_unitPrice=orderNum_exchRate_unitPrice;
			matertialInforList[i].orderNum_exchRate=orderNum_exchRate;
			
			context_data.sum_orderNum_exchRate_margin+=Number(orderNum_exchRate_margin);
			context_data.sum_orderNum_exchRate_unitPrice+=Number(orderNum_exchRate_unitPrice);
			context_data.sum_orderNum_exchRate+=orderNum_exchRate;
			$("#moduleGrossMargin_table tr ").eq(i+1).find("#gross_profit_margin").html(gross_profit_margin.toFixed(2));
			$("#moduleGrossMargin_table tr ").eq(i+1).find("#gross_profit_rate").html((gross_profit_rate*100).toFixed(1)+"%");
			$("#moduleGrossMargin_table tr ").eq(i+1).find("#orderNum_exchRate_margin").html(orderNum_exchRate_margin);
			$("#moduleGrossMargin_table tr ").eq(i+1).find("#orderNum_exchRate_unitPrice").html(orderNum_exchRate_unitPrice);
			$("#moduleGrossMargin_table tr ").eq(i+1).find("#orderNum_exchRate").html(orderNum_exchRate);

		});
		$("#moduleGrossMargin_table tr ").eq(0).find("#orderNum_exchRate_margin").html(context_data.sum_orderNum_exchRate_margin);
		$("#moduleGrossMargin_table tr ").eq(0).find("#orderNum_exchRate_unitPrice").html(context_data.sum_orderNum_exchRate_unitPrice);
		$("#moduleGrossMargin_table tr ").eq(0).find("#orderNum_exchRate").html(context_data.sum_orderNum_exchRate);
		var  total_gross_margin=(context_data.sum_orderNum_exchRate_margin/context_data.sum_orderNum_exchRate_unitPrice) ;
		var  average_gross_profit=(context_data.sum_orderNum_exchRate_margin/context_data.sum_orderNum_exchRate);

		$(".display_switch").show();
		
		$("#moduleGrossMargin_table").append("<tr id='tr_calculate'>" +
				"<td>总毛利率</td>" +
				"<td>"+(total_gross_margin*100).toFixed(2) +"%</td>" +
				"<td>平均毛利率</td>" +
				"<td>"+(average_gross_profit*100).toFixed(2) +"%</td>" +
						"</tr>");
		
	});
	var mouserover_out=function(){
		$("#moduleGrossMargin_table #orderNum_exchRate_unitPrice:not(:first),#moduleGrossMargin_table #orderNum_exchRate:not(:first),#moduleGrossMargin_table #orderNum_exchRate_margin:not(:first)").mouseover(function(){
			$("#showDiv").show();
			$("#showDiv").css("left",event.clientX);
			$("#showDiv").css("top",event.clientY);
			var id=$(this).attr("id");
			/*alert(id);*/
			if(id=="orderNum_exchRate_margin"){
				$("#showDiv").html("数量*瓦数*当月毛利额");
			}else if(id=="orderNum_exchRate_unitPrice"){
				$("#showDiv").html("数量*瓦数*单价");
			}else if(id=="orderNum_exchRate"){
				$("#showDiv").html("数量*瓦数");
			}
			});
		$("#moduleGrossMargin_table #orderNum_exchRate_margin,#moduleGrossMargin_table #orderNum_exchRate_unitPrice,#moduleGrossMargin_table #tr_1 #orderNum_exchRate").mouseout(function(){
			$("#showDiv").html("");
			$("#showDiv").hide();
			});
		
	}
});

