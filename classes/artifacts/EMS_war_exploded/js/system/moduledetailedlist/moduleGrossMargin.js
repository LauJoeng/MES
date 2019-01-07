var select_complete=false;
var context_data;
var context_data_sum={};
var click_button=0;
$(function() {
	
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();
		context_data=null;
		$("#moduleGrossMargin").hide();//隐藏下列
		$("#save_calculate").hide();
		$.ajax({
			async : false,
			data:searchParams,
			dataType : 'json',
			type : 'POST',
			url : rootPath + '/module_detailed_list/selectModuleGrossMargin.shtml',
			error : function() {
				alert('单组件毛利查询失败 ');
			},
			success : function(data) {
				context_data=data;
				select_complete=true;
				// 工序
				/*for (var i = 0; i < data.length; i++) {
					$("#OperationDataFormMap\\.process").append("<option>" + data[i]+ "</option>");
				}*/
				var total_number_of_watts=0;
				$("#moduleGrossMargin_table tr:not(:first)").remove();
				
				$("#moduleGrossMargin_table").find("#royalty_rate,#gross_profit_margin,#gross_profit_rate,#orderNum_exchRate_margin,#orderNum_exchRate_unitPrice,#orderNum_exchRate").hide();

				for (var i = 0; i < data.length; i++) {
					var unitPrice=((data[i].foreign_currency_prices)*(data[i].foreign_currency_rate)).toFixed(4);//外币价格*外币汇率
					var matertialBasicInforList=data[i].matertialBasicInforList;
					var cost_silicon=0;//硅成本
					var no_cost_silicon=0;//非硅成本
					var commission=data[i].commission_rate*data[i].basic_commission_premium;//佣金
					var premium=data[i].premium_rate*data[i].basic_commission_premium;//佣金
					var orderNum=data[i].orderNum;
					var exchRate=data[i].exchRate;
					var royalty_rate=data[i].royalty_rate;
				
					
					for (var j = 0; j < matertialBasicInforList.length; j++) {
						var matertialBasicInfor= matertialBasicInforList[j];
						//数量*（1+损耗率）*单价/1.15/功率
						var price=matertialBasicInfor.taxPrice*(1+matertialBasicInfor.wasteRate/100)*matertialBasicInfor.dosage/1.15/exchRate;
						if(matertialBasicInfor.itemParam!="半成品"){
/*							var price=matertialBasicInfor.taxPrice*(1+matertialBasicInfor.wasteRate/100)*matertialBasicInfor.dosage/1.15/exchRate;
*/							//数量*（1+损耗率）*单价/1.15/功率 *(1+报废率)
							
							no_cost_silicon=no_cost_silicon+price;
						}else{
/*							var price=matertialBasicInfor.taxPrice*(1+matertialBasicInfor.wasteRate/100)*matertialBasicInfor.dosage/1.15/exchRate;
*/							//数量*（1+损耗率）*单价/1.15/功率
							cost_silicon=price;
						}
						
					}
					cost_silicon=cost_silicon.toFixed(4);
					
					commission=commission.toFixed(6);
					premium=premium.toFixed(6);
					no_cost_silicon=no_cost_silicon*(1+data[i].scrappage/100);
					no_cost_silicon=no_cost_silicon.toFixed(4);
					context_data[i]["no_cost_silicon"]=no_cost_silicon;
					context_data[i]["cost_silicon"]=cost_silicon;
					context_data[i]["unitPrice"]=unitPrice;
					context_data[i]["commission"]=commission;
					data[i].water_electricity=(data[i].water_electricity==null?0:data[i].water_electricity)
					data[i].cost_labor=(data[i].cost_labor==null?0:data[i].cost_labor);
					$("#moduleGrossMargin_table").append("<tr id="+"tr_"+(i+2)+">"
							+"<td id="+"order_no"+">"+data[i].order_no+"</td>"
							+"<td id="+"name"+">"+data[i].itemName+"</td>"
							+"<td id="+"unitPrice"+">"+unitPrice+"</td>"
							+"<td id="+"cost_silicon"+">"+cost_silicon+"</td>"
							+"<td id="+"no_cost_silicon"+">"+no_cost_silicon+"</td>"
							+"<td id="+"water_electricity"+">"+data[i].water_electricity+"</td>"
							+"<td id="+"cost_labor"+">"+data[i].cost_labor+"</td>"
							+"<td id='sea'>"+"<span><input></input></span>"+"</td>"
							+"<td id='inland'>"+"<span><input></input></span>"+"</td>"
							+"<td id='foreign'>"+"<span><input></input></span>"+"</td>"
							+"<td id="+"commission"+">"+commission+"</td>"
							+"<td id="+"premium"+">"+premium+"</td>"
							+"<td id="+"royalty"+">"+""+"</td>"
							+"<td id="+"royalty_rate style=display:none"+">"+royalty_rate+"</td>"
							+"<td id=gross_profit_margin style=display:none>"+"当月毛利额"+"</td>"
							+"<td id=gross_profit_rate  style=display:none>"+"毛利率"+"</td>"
							+"<td id="+"orderNum"+">"+orderNum+"</td>"
							+"<td id="+"exchRate"+">"+exchRate+"</td>"
							+"<td id="+"orderNum_exchRate_margin"+">"+""+"</td>"
							+"<td id="+"orderNum_exchRate_unitPrice"+">"+""+"</td>"
							+"<td id="+"orderNum_exchRate"+">"+""+"</td>"
							 +"</tr>");
				}
			}
		});
		
		$("#moduleGrossMargin_table tr:not(:first)").click("click", function() {
			var tr_id= $(this).index()+1;
			click_button=tr_id-2;
			/*alert(tr_id);*/
			/*alert(.orderNum);*/
			var moduleGrossMargin=context_data[tr_id-2];//获取当前行的对象值
			var matertialBasicInfor=moduleGrossMargin.matertialBasicInforList;//物料信息
			$.each(moduleGrossMargin,function(i,val){//迭代对象 i为key val是对应的值
				/*alert(i);
				alert(val);*/
				
				if(i=="scrappage"){
					val=(val==null?0:val);
					$("#moduleGrossMargin input[id="+i+"]").val(val+"%");
				}else{
					$("#moduleGrossMargin input[id="+i+"]").val(val);
				}
				
				if(i=="matertialBasicInforList"){
					$("div[id=matertialBasicInfor]").empty();
					
						var string="";
					$.each(matertialBasicInfor,function(i,val){
						/*alert(val.itemId);*/
						string=string+"<input name='checkbox' id='checkbox' checked='checked' type='checkbox'  />"+
						"<span>物料名称:</span><input id='itemName' value="+val.itemName+"></input>"+
						"<span>规格/型号:</span><input id='itemSpc'  value="+val.itemSpc+"></input>"+
						"<span>单耗:</span><input id='dosage' value="+Number(val.dosage).toFixed(4)+"></input>"+
						"<span>损耗率:</span><input id='wasteRate' value="+val.wasteRate+"%></input>"+
						"<span>标准用量:</span><input id='dosage_wasteRate' value="+((1+Number(val.wasteRate)/100)*val.dosage).toFixed(4)+"></input>"+
						"<span>单位:</span><input id='itemUnit' value="+val.itemUnit+"></input>"+
						"<span>单价:</span><input id='taxPrice' value="+(val.taxPrice==null?'':val.taxPrice)+"></input>"+
						"<input id='itemId' value="+val.itemId+"></input>"+
						"<input id='itemParam' value="+val.itemParam+"></input>"+
						"<br>";
					});
					
					$("div[id=matertialBasicInfor]").append(
							string
							);
					/*alert("1");*/
				}
			});
			$("#moduleGrossMargin_basis input").attr("disabled","disabled");
			$("#matertialBasicInfor input:not(#taxPrice,#checkbox)").attr("disabled","disabled");
			$("#moduleGrossMargin").show();
			/*$("#matertialBasicInfor input").blur(function(){
				alert("2");
			});*/
			$("#matertialBasicInfor input:not(#checkbox)").blur(function(event){
				var value=$(this).val();
				var pattern_chin=/^(\-|\+)?\d+(\.\d+)?$/g; 
				if(value.match(pattern_chin)==null){
					if(value!=""){
						$(this).val("");
						alert("请输入数字!");
						/*return;*/
					}
					
				}
				var itemId=$(this).next("#itemId").val();
				/*alert(tr_id);*/
				/*alert(.orderNum);*/
				var moduleGrossMargin=context_data[click_button];//获取当前行的对象值
				var matertialBasicInfor=moduleGrossMargin.matertialBasicInforList;//物料信息
				var exchRate=moduleGrossMargin.exchRate;
				var scrappage=moduleGrossMargin.scrappage;
				var cost_silicon=0;
				var no_cost_silicon=0;
				var price=0;
				$.each(matertialBasicInfor,function(i,val){
					//给上下文赋值 同时修改输入框的值
					if(val.itemId==itemId){
						val.taxPrice=value;
						
						/*alert((context_data[click_button].matertialBasicInforList)[i].taxPrice);
						alert((context_data[click_button].matertialBasicInforList)[i].itemId);*/						
						/*return;*/
					}
					
					var itemParam=val.itemParam;
					/*alert(itemParam);*/
					if(itemParam!="半成品"){
						price=((1+scrappage/100)*val.taxPrice*(1+val.wasteRate/100)*val.dosage/1.15/exchRate);
						no_cost_silicon=no_cost_silicon+price;
						
					}else{
						price=((val.taxPrice)*(1+val.wasteRate/100)*(val.dosage)/1.15/exchRate).toFixed(4);
						 cost_silicon=price;
						
					}
					
					
				});
				/*context_data["no_cost_silicon"]=no_cost_silicon;
				context_data["cost_silicon"]=cost_silicon;*/
				//上下文赋值
				moduleGrossMargin["no_cost_silicon"]=no_cost_silicon;
				moduleGrossMargin["cost_silicon"]=cost_silicon;
				
				$("#moduleGrossMargin_table #tr_"+(click_button+2)+" #cost_silicon").html(cost_silicon);
				$("#moduleGrossMargin_table #tr_"+(click_button+2)+" #no_cost_silicon").html(no_cost_silicon.toFixed(4));

			});
			$("#moduleGrossMargin_chackbasis input").blur(function(event){
				var value=$(this).val();
				var moduleGrossMargin=context_data[click_button];//获取当前行的对象值
				var pattern_chin=/^(\-|\+)?\d+(\.\d+)?%?$/g; 
				if(value.match(pattern_chin)==null){
					if(value!=""){
						$(this).val("");
						alert("请输入数字!");
						/*return;*/
					}
					
				}
				var id=$(this).attr("id");//获取失去事件点击框ID
				if(id=="scrappage"){//报废率
					if(value.match(/%$/g)==null){
						value=value*100;
					}else{
					value=value.substring(0,value.indexOf("%"));
					}
				}
				moduleGrossMargin[id]=value;//存到上下文
				if(id=="foreign_currency_prices"||id=="foreign_currency_rate"){
					value=Number(moduleGrossMargin.foreign_currency_prices*moduleGrossMargin.foreign_currency_rate).toFixed(4);
					id="unitPrice";
					
					moduleGrossMargin[id]=value;
				} 
				if(id=="commission_rate"||id=="premium_rate"||id=="basic_commission_premium"){
					moduleGrossMargin["commission"]=(moduleGrossMargin["commission_rate"]*moduleGrossMargin["basic_commission_premium"]).toFixed(6);
					moduleGrossMargin["premium"]=(moduleGrossMargin["premium_rate"]*moduleGrossMargin["basic_commission_premium"]).toFixed(6);
					$("#moduleGrossMargin_table #tr_"+(click_button+2)).find("#commission").html(moduleGrossMargin["commission"]);
					$("#moduleGrossMargin_table #tr_"+(click_button+2)).find("#premium").html(moduleGrossMargin["premium"]);
					
				}else{
				
				//修改表格的值
				$("#moduleGrossMargin_table #tr_"+(click_button+2)).find("#"+id).html(value);
				}
				//判断海运费是否有值如果有则 要改变业务提成的值
				var sea=$("#moduleGrossMargin_table #tr_"+(click_button+2)).find("#sea input").val();
				if(sea!=null && sea!=""){
					var royalty=((moduleGrossMargin["unitPrice"]-sea-moduleGrossMargin["commission"])*moduleGrossMargin["royalty_rate"]).toFixed(4);
					moduleGrossMargin["royalty"]=royalty;
					$("#moduleGrossMargin_table #tr_"+(click_button+2)).find("#royalty").html(royalty);
				}
				
			})
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
	
	$("#save_calculate").click("click",function(){
		
		var string="";
		$.each(context_data_sum,function(i,val){
			string=string+i+"="+val+"&";
		})
		
		$.ajax({
			async : false,
			data:JSON.stringify(context_data),
			dataType : 'json',
			type : 'POST',
			contentType:'application/json;charset=UTF-8',
			url : rootPath + '/module_detailed_list/updateCalculateModuleGrossMargin.shtml?'+string,
			error : function() {
				alert('计算结果保存失败 ');
			},
			success :function(){
				alert('计算结果保存成功 ');
				}
			})
		
	})
	//点击按钮保存信息
	$("#save_button_moduleGrossMargin").click("click",function(){
		var data=context_data[click_button];
		var _list = {}; 
		$.each(data,function(i,val){
			if(i!="matertialBasicInforList"){
				_list[i]=val;
			}
			
		});
		$.ajax({
			async : false,
			data:_list,
			dataType : 'json',
			type : 'POST',
			url : rootPath + '/module_detailed_list/updateModuleGrossMargin.shtml',
			error : function() {
				alert(data.itemName+'板材信息更新失败 ');
			},
			success :function(){
				alert(data.itemName+'板材信息更新成功 ');
				}
			})
	});
	$("#save_button_matertialBasicInfor").click("click",function(){
			var data=context_data[click_button];
			var matertialBasicInforList=data.matertialBasicInforList;
			var _list=[];
			var _map
			//看选中了哪些
			var checkboxList=$("#matertialBasicInfor #checkbox");
			$.each(checkboxList,function(i){
				 _map={};
				/*alert($(this).is(':checked'));*/
				if($(this).is(':checked')){
					_map=matertialBasicInforList[i];
					_list.push(_map);
				}
				
			})
			/*$.each(matertialBasicInforList,function(i,val){
				 _map={};
				$.each(val,function(j,value){
					_map[j]=value;
				});
				_list.push(_map);
			});*/

			$.ajax({
				async : false,
				data:JSON.stringify(_list),
				dataType : 'json',
				type : 'POST',
				contentType:'application/json;charset=UTF-8', 
				/*contentType:"application/json",*/
				url : rootPath + '/module_detailed_list/updateMatertialBasicInforList.shtml',
				error : function() {
					alert(data.itemName+'物料价格更新失败 ');
				},
				success :function(){
					alert(data.itemName+'物料价格更新成功 ');
					}
				})
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

		var sum_orderNum_exchRate_margin=0;
		var sum_orderNum_exchRate_unitPrice=0;
		var sum_orderNum_exchRate=0;
		
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
			var exchRate= $(this).children("#exchRate").html();
			var orderNum= $(this).children("#orderNum").html();
			/*alert(gross_profit_margin);*/
			$(this).children("#gross_profit_rate").html((gross_profit_margin/unitPrice*100).toFixed(2)+"%");
			
			/**
			 * 计算数量*瓦数*毛利额  及其总数
			 * 计算数量*瓦数*单价  及其总数
			 * 计算数量*瓦数
			 */
			var orderNum_exchRate_margin=$(this).children("#orderNum_exchRate_margin").html((gross_profit_margin*exchRate*orderNum).toFixed(4)).html();
			var orderNum_exchRate_unitPrice=$(this).children("#orderNum_exchRate_unitPrice").html((unitPrice*exchRate*orderNum).toFixed(4)).html();
			var orderNum_exchRate=$(this).children("#orderNum_exchRate").html(exchRate*orderNum).html();

			sum_orderNum_exchRate_margin=sum_orderNum_exchRate_margin+Number(orderNum_exchRate_margin);
			sum_orderNum_exchRate_unitPrice=sum_orderNum_exchRate_unitPrice+Number(orderNum_exchRate_unitPrice);
			sum_orderNum_exchRate=sum_orderNum_exchRate+Number(orderNum_exchRate);
			/*alert(sum_orderNum_exchRate_margin);*/
			/**
			 * 存储到上下文方便后续取值
			 */
			context_data[i].sea=sea;
			context_data[i].inland=inland;
			context_data[i].foreign=foreign;
			context_data[i].orderNum_exchRate_margin=orderNum_exchRate_margin;
			context_data[i].orderNum_exchRate_unitPrice=orderNum_exchRate_unitPrice;
			context_data[i].orderNum_exchRate=orderNum_exchRate;
			context_data[i].commission=commission;
			context_data[i].premium=premium;royalty
			context_data[i].royalty=royalty;
			context_data[i].gross_profit_margin=gross_profit_margin;
		});
		
		$("#moduleGrossMargin_table #tr_1 #orderNum_exchRate_margin").html(sum_orderNum_exchRate_margin.toFixed(4));
		$("#moduleGrossMargin_table #tr_1 #orderNum_exchRate_unitPrice").html(sum_orderNum_exchRate_unitPrice.toFixed(4));
		$("#moduleGrossMargin_table #tr_1 #orderNum_exchRate").html(sum_orderNum_exchRate.toFixed(4));
		$("#moduleGrossMargin_table td").not("#royalty_rate").show();
		$("#moduleGrossMargin_table tr").not("[id^='tr_']").remove();
		var  total_gross_margin=(sum_orderNum_exchRate_margin/sum_orderNum_exchRate_unitPrice*100).toFixed(2) ;
		var  average_gross_profit=(sum_orderNum_exchRate_margin/sum_orderNum_exchRate*100).toFixed(2);
		$("#moduleGrossMargin_table").append("<tr>" +
				"<td>总毛利率</td>" +
				"<td>"+total_gross_margin +"%</td>" +
				"<td>平均毛利率</td>" +
				"<td>"+average_gross_profit +"%</td>" +
						"</tr>");
		/**
		 * 给上下文context_data_sum赋值
		 */
		context_data_sum["order_no"]=context_data[0].order_no;
		context_data_sum.total_gross_margin=total_gross_margin;
		context_data_sum["average_gross_profit"]=average_gross_profit;
		context_data_sum["sum_orderNum_exchRate_margin"]=sum_orderNum_exchRate_margin;
		context_data_sum["sum_orderNum_exchRate_unitPrice"]=sum_orderNum_exchRate_unitPrice;
		context_data_sum.sum_orderNum_exchRate=sum_orderNum_exchRate;
		
		
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
		
		/*$("#moduleGrossMargin_table #orderNum_exchRate_unitPrice").mouseout(function(){
			$("#showDiv").html("");
			$("#showDiv").hide();
			});*/
		$("#save_calculate").show();
	});
	
	
	
	

});

