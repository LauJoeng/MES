var pageii = null;
var grid = null;
var imagepath=null;
/**
 * 初始默认为工序：分片
 * @returns
 */
var column_Cy=null;
var selectedUrl=null;
$(function() {		
		//绑定查询按钮
	$("#search").click("click", function() {// 绑定查询按扭						
		//调用函数 根据选中的值  给column_Cy和jsonUrl赋值
		if(!selectedOption()){
			return;
		};
		grid=null;
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid = lyGrid({
			pagId 	  : 'paging',
			data 	  : searchParams,
			isFixed   : false,
			l_column  : column_Cy ,
			jsonUrl   : rootPath + selectedUrl,
			checkbox  : true,
			serNumber : true
		});
		var processName = $("#processName option:selected").html();
		if(processName=="层压"){
			$("#mytable tr:not(:first)").unbind("dblclick");
		}else{
			$("#mytable tr:not(:first)").unbind("dblclick");
			$("#mytable tr:not(:first)").dblclick(function(){
				var tr_id= $(this).index();
				var all_data = grid.getCurrentData();
				/*alert(all_data);
				alert(tr_id);*/
				/*var i=0;*/
				$.each(all_data,function(i,val){
					if(i==tr_id){
						$.each(val,function(j,x){
							if(j=="imagepath"){
								imagepath=x;
								return;
							}
						});
						return;
					}
					
				});
				/*alert(all_data[tr_id]);*/
				
			imagepath=imagepath.replace(/\\/g,"%5C");
			/*alert(imagepath);*/
				pageii = layer.open({
					title : "图片",
					type : 2,
					scrollbar: true,
					area : [ "90%", "90%" ],
					content : rootPath + '/processManagement/processImage.shtml?imagepath='+imagepath   
				});
			})
		}
	});		

});


var processNameChange=function(){
	var processName = $("#processName option:selected").html();
	if(processName=="层压"){
		$("div .equipCode").css('display','inline-block');
		$(" div .order_no").css('display','none');
	}else if(processName=="前道EL"){
		$("div .equipCode").css('display','none');
		$(" div .order_no").css('display','inline-block');
	}else if(processName=="后道EL"){
		$("div .equipCode").css('display','none');
		$(" div .order_no").css('display','inline-block');
	}
   }

var begintime ;
var endtime ;
var equipCode;
var selectedOption =function(){
	begintime=$("#begintime").val();
	endtime=$("#endtime").val();
	var timeout=(begintime==''|| begintime==null || endtime==''|| endtime==null) ;
	var processName = $("#processName option:selected").html();
	/*alert(processName);*/
	if(processName=="分片"){
		
	}else if(processName=="拼接"){
			
	}else if(processName=="前道EL"){
		order_no=$("#order_no").val();
		if(order_no==''|| order_no==null || timeout  ){
			alert("请输入时间与订单号");
			return false;
		}
		selectedUrl='/processManagement/selectProcess_EL1.shtml';
		column_Cy=[{
			colkey 	: "order_no",
			name 	: "订单号"
		},{
			colkey 	: "module_code",
			name 	: "组件条码"
		},{
			colkey 	: "line",
			name 	: "线别"
		},{
			colkey 	: "createtime",			
			name 	: "创建时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd  hh:mm:ss");
			}
		},{
			colkey 	: "op",
			name 	: "操作人"
		}, {
			colkey 	: "el_test_time",
			name 	: "白/夜",
			renderData : function(rowindex,data, rowdata, column) {
			var hour=(new Date(data)).getHours();
			if(hour>=7 & hour<=17){
				return "白班";
			}else{
				return "夜班";
			}
			}
		},{
			colkey 	: "imagepath",
			name 	: "图片路径"
				/*,
			hide : true	*/					
		}];
	}else if(processName=="层压"){
		equipCode=$("#equipCode").val();
		/*alert(begintime+endtime+equipCode);*/
		if(equipCode==''|| equipCode==null || timeout  ){
			alert("请输入时间与设备号");
			return false;
		}
			selectedUrl='/processManagement/selectProcess_Cy.shtml';
			column_Cy=[{
				colkey 	: "module_code",
				name 	: "组件条码"
			},{
				colkey 	: "equipCode",
				name 	: "设备编号"
			},{
				colkey 	: "locationno",
				name 	: "摆放位置"
			},{
				colkey 	: "op",
				name 	: "操作人"
			}, {
				colkey 	: "createtime",			
				name 	: "层压时间",
				renderData : function(rowindex,data, rowdata, column) {
					return new Date(data).format("yyyy-MM-dd  hh:mm:ss");
				}
			},{
				colkey 	: "shiftName",
				name 	: "班次"
			}];
			
	}else if(processName=="装框"){
			
	}else if(processName=="IV测试"){
			
	}else if(processName=="后道EL"){
		order_no=$("#order_no").val();
		if(order_no==''|| order_no==null || timeout  ){
			alert("请输入时间与订单号");
			return false;
		}
		selectedUrl='/processManagement/selectProcess_EL3.shtml';
		column_Cy=[{
			colkey 	: "order_no",
			name 	: "订单号"
		},{   
			colkey 	: "module_code",
			name 	: "组件条码"
		},{
			colkey 	: "line",
			name 	: "线别"
		},{
			colkey 	: "createtime",			
			name 	: "创建时间",
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd  hh:mm:ss");
			}
		},{
			colkey 	: "op",
			name 	: "操作人"
		}, {
			colkey 	: "el_test_time",
			name 	: "白/夜",
			renderData : function(rowindex,data, rowdata, column) {
			var hour=(new Date(data)).getHours();
			if(hour>=7 & hour<=17){
				return "白班";
			}else{
				return "夜班";
			}
			}
		},{
			colkey 	: "imagepath",
			name 	: "图片路径"
				/*,
			hide : true	*/					
		}];
		
	}else if(processName=="FQC"){
		
	}else if(processName=="PKG"){
		
	}else{
		return false;
	}
	return true;
}


/*pageii = layer.open({
	title : "编辑",
	type : 2,
	area : [ "600px", "80%" ],
	content : rootPath + '/resources/editUI.shtml?id=' + cbox
});*/
