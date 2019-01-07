
/*
$(function() {
	$("#search").click("click", function() {
		var searchParams = $("#searchForm").serializeJson();
		$.ajax({
			async : false,
			data:searchParams,
			dataType : 'json',
			type : 'POST',
			url : rootPath + '/module_detailed_list/orderSumMoneySelect.shtml',
			error : function() {
				alert('订单总额查询失败');
			},
			success : function(data) {
				$("#moduleGrossMargin_table tr:not(:first)").remove();
				$.each(data,function(n,value){
					var str="<tr><td>"+value.compactno+"</td><td>"+value.allMoney+"</td></tr>"
					$("#moduleGrossMargin_table").append(str);
				})
				
				}
			});
	});
});*/

			
			
$(function() {
				$("#search").click("click", function() {
					var searchParams = $("#searchForm").serializeJson();
					grid = lyGrid({
						pagId : 'paging',
						l_column : [{
							colkey 	: "compactno",
							name 	: "订单号",
							width	:"150px"
						}, {
							colkey 	: "ordernum",
							name 	: "数量",
						}, {
							colkey 	: "salemoney",
							name 	: "总额",
						}, {
							colkey 	: "allMoney",
							name 	: "成本",
						}],
						jsonUrl 	: rootPath + '/module_detailed_list/orderSumMoneySelect.shtml',
						checkbox 	: true,
						serNumber 	: true,
						data : searchParams
					});

				});
});
