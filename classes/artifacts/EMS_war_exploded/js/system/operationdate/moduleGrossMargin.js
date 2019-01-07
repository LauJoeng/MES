var select_complete=false;
$(function() {
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();
		$.ajax({
			async : false,
			data:searchParams,
			dataType : 'json',
			type : 'POST',
			url : rootPath + '/operationData/selectModuleGrossMargin.shtml',
			error : function() {
				alert('单组件毛利查询失败 ');
			},
			success : function(data) {
				select_complete=true;
				// 工序
				/*for (var i = 0; i < data.length; i++) {
					$("#OperationDataFormMap\\.process").append("<option>" + data[i]+ "</option>");
				}*/
				var total_number_of_watts=0;
				$("#moduleGrossMargin_table tr:not(:first)").remove();
				
				$("#moduleGrossMargin_table").find("#royalty_rate,#gross_profit_margin,#gross_profit_rate,#amount_wattage_margin,#amount_wattage_unitPrice,#amount_wattage").hide();

				for (var i = 0; i < data.length; i++) {
					$("#moduleGrossMargin_table").append("<tr id="+"tr_"+(i+2)+">"
							+"<td id="+"order_no"+">"+data[i].order_no+"</td>"
							+"<td id="+"name"+">"+data[i].name+"</td>"
							+"<td id="+"unitPrice"+">"+data[i].unitPrice+"</td>"
							+"<td id="+"cost_silicon"+">"+data[i].cost_silicon+"</td>"
							+"<td id="+"no_cost_silicon"+">"+data[i].no_cost_silicon+"</td>"
							+"<td id="+"water_electricity"+">"+data[i].water_electricity+"</td>"
							+"<td id="+"cost_labor"+">"+data[i].cost_labor+"</td>"
							+"<td id='sea'>"+"<span><input></input></span>"+"</td>"
							+"<td id='inland'>"+"<span><input></input></span>"+"</td>"
							+"<td id='foreign'>"+"<span><input></input></span>"+"</td>"
							+"<td id="+"commission"+">"+data[i].commission+"</td>"
							+"<td id="+"premium"+">"+data[i].premium+"</td>"
							+"<td id="+"royalty"+">"+""+"</td>"
							+"<td id="+"royalty_rate style=display:none"+">"+data[i].royalty_rate+"</td>"
							+"<td id=gross_profit_margin style=display:none>"+"当月毛利额"+"</td>"
							+"<td id=gross_profit_rate  style=display:none>"+"毛利率"+"</td>"
							+"<td id="+"amount"+">"+data[i].amount+"</td>"
							+"<td id="+"wattage"+">"+data[i].wattage+"</td>"
							+"<td id="+"amount_wattage_margin"+">"+""+"</td>"
							+"<td id="+"amount_wattage_unitPrice"+">"+""+"</td>"
							+"<td id="+"amount_wattage"+">"+""+"</td>"
							 +"</tr>");
				}
			}
		});
		/*
		 * 只能输入数字
		 */
		$("#moduleGrossMargin_table input").blur(function(){
			var val=$(this).val();
			var pattern_chin =/^(\-|\+)?\d+(\.\d+)?$/g; 
			/*alert(val.match(pattern_chin));*/
			if(val.match(pattern_chin)==null){
				if(val==""){
					return;
				}
				$(this).val("");
				alert("请输入数字!");
			}
		});
		$("#sea input").blur(function(e){
			var sea=$(this).val();
			if(sea==null ||sea==""){
				$(this).parents("#sea").siblings("#royalty").html("");
				return;
			}
			/*获取当前值
			 * */
			var royalty=$(this).parents("#sea").siblings("#royalty_rate").html();
			var unitPrice=$(this).parents("#sea").siblings("#unitPrice").html();
			var commission=$(this).parents("#sea").siblings("#commission").html();
			$(this).parents("#sea").siblings("#royalty").html(((unitPrice-sea-commission)*royalty).toFixed(4));
		});
	});
	
	var first_calculate=true;
	$("#calculate").click("click", function() {
		var judge=true;
		$("#moduleGrossMargin_table input").each(function(i){
			 var text = $(this).val();
			    if(text ==""||text ==null){
			        alert("有空值");
			        judge=false;
			        return false ;
			    }
		});
		if(!judge){
			return;
		}

		var sum_amount_wattage_margin=0;
		var sum_amount_wattage_unitPrice=0;
		var sum_amount_wattage=0;
		
		
		$("#moduleGrossMargin_table tr[id^='tr_']:not(:first)").each(function(i){
			var unitPrice= $(this).children("#unitPrice").html();
			var cost_silicon= $(this).children("#cost_silicon").html();
			var no_cost_silicon= $(this).children("#no_cost_silicon").html();
			var water_electricity= $(this).children("#water_electricity").html();
			var cost_labor= $(this).children("#cost_labor").html();
			
			var sea= $(this).find("#sea input").val();
			var inland= $(this).find("#inland input").val();
			var foreign= $(this).find("#foreign input").val();
			
			var commission= $(this).children("#commission").html();
			var premium= $(this).children("#premium").html();
			var royalty= $(this).children("#royalty").html();
			var gross_profit_margin=$(this).children("#gross_profit_margin").html((unitPrice - cost_silicon- no_cost_silicon- water_electricity- cost_labor
					-sea-inland-foreign-commission-premium-royalty).toFixed(4)).html();
			var wattage= $(this).children("#wattage").html();
			var amount= $(this).children("#amount").html();
			/*alert(gross_profit_margin);*/
			$(this).children("#gross_profit_rate").html((gross_profit_margin/unitPrice*100).toFixed(2)+"%");
			
			/**
			 * 计算数量*瓦数*毛利额  及其总数
			 * 计算数量*瓦数*单价  及其总数
			 * 计算数量*瓦数
			 */
			var amount_wattage_margin=$(this).children("#amount_wattage_margin").html(gross_profit_margin*wattage*amount).html();
			var amount_wattage_unitPrice=$(this).children("#amount_wattage_unitPrice").html(unitPrice*wattage*amount).html();
			var amount_wattage=$(this).children("#amount_wattage").html(wattage*amount).html();

			sum_amount_wattage_margin=sum_amount_wattage_margin+Number(amount_wattage_margin);
			sum_amount_wattage_unitPrice=sum_amount_wattage_unitPrice+Number(amount_wattage_unitPrice);
			sum_amount_wattage=sum_amount_wattage+Number(amount_wattage);
			/*alert(sum_amount_wattage_margin);*/
		});
		
		$("#moduleGrossMargin_table #tr_1 #amount_wattage_margin").html(sum_amount_wattage_margin);
		$("#moduleGrossMargin_table #tr_1 #amount_wattage_unitPrice").html(sum_amount_wattage_unitPrice);
		$("#moduleGrossMargin_table #tr_1 #amount_wattage").html(sum_amount_wattage);
		$("#moduleGrossMargin_table td").not("#gross_profit_rate,#royalty_rate").show();
		$("#moduleGrossMargin_table tr").not("[id^='tr_']").remove();
		$("#moduleGrossMargin_table").append("<tr>" +
				"<td>总毛利率</td>" +
				"<td>"+ (sum_amount_wattage_margin/sum_amount_wattage_unitPrice*100).toFixed(2)+"%</td>" +
				"<td>平均毛利率</td>" +
				"<td>"+ (sum_amount_wattage_margin/sum_amount_wattage*100).toFixed(2)+"%</td>" +
						"</tr>");
		
/*		$("#moduleGrossMargin_table #amount_wattage_margin").mouseover(function(){
			$("#showDiv").show();
			$("#showDiv").css("left",event.clientX);
			$("#showDiv").css("top",event.clientY);
			$("#showDiv").html("数量*瓦数*当月毛利额");
			});
		
		$("#moduleGrossMargin_table #amount_wattage_unitPrice").mouseover(function(){
			$("#showDiv").show();
			$("#showDiv").css("left",event.clientX);
			$("#showDiv").css("top",event.clientY);
			$("#showDiv").html("数量*瓦数*单价");
			});*/
		$("#moduleGrossMargin_table #amount_wattage_unitPrice:not(:first),#moduleGrossMargin_table #amount_wattage:not(:first),#moduleGrossMargin_table #amount_wattage_margin:not(:first)").mouseover(function(){
			$("#showDiv").show();
			$("#showDiv").css("left",event.clientX);
			$("#showDiv").css("top",event.clientY);
			var id=$(this).attr("id");
			/*alert(id);*/
			if(id=="amount_wattage_margin"){
				$("#showDiv").html("数量*瓦数*当月毛利额");
			}else if(id=="amount_wattage_unitPrice"){
				$("#showDiv").html("数量*瓦数*单价");
			}else if(id=="amount_wattage"){
				$("#showDiv").html("数量*瓦数");
			}
			});
		$("#moduleGrossMargin_table #amount_wattage_margin,#moduleGrossMargin_table #amount_wattage_unitPrice,#moduleGrossMargin_table #tr_1 #amount_wattage").mouseout(function(){
			$("#showDiv").html("");
			$("#showDiv").hide();
			});
		
		/*$("#moduleGrossMargin_table #amount_wattage_unitPrice").mouseout(function(){
			$("#showDiv").html("");
			$("#showDiv").hide();
			});*/
		
	});
	
	
	
	

});

