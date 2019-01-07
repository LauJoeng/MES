
var pageii = null;
var grid = null;
var column_Cy=null;
$(document).ready(function() {
	$("#selectName").change(function(){
		var selectName = $("#selectName option:selected").html();		
		if(selectName=="组件条码"){
			$("#select_number").attr('name',"module_code");
		}else if(selectName=="订单号"){
			$("#select_number").attr('name',"order_no");
		}
	});
	
	$("#search").click("click", function() {// 绑定查询按扭	
		var select_number=$("#select_number").val();
		if(select_number==null ||select_number==''){
			alert("请输入查询条件");
			return false;
		}
		grid=null;
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数		
		selectedOption();
		grid = lyGrid({
			pagId 		: 'paging',
			data 		: searchParams,
			isFixed 	: false,
			l_column 	: column_Cy,
			jsonUrl 	: rootPath + '/processManagement/selectMaterialMode.shtml',
			checkbox 	: true,
			serNumber 	: true,
			pageSize 	: 50
		});
		
	});
});

var selectedOption =function(){
	/*column_Cy=[{
		colkey 	: "orderno",
		name 	: "订单号",
		width	:"100px"
	},{
		colkey 	: "moduleCode",
		name 	: "组件条码",
		width	:"160px"
	},{
		colkey 	: "mname",
		name 	: "物料名称",
		width	:"15%"
	},{
		colkey 	: "mcode",
		name 	: "物料条码",
		width	:"15%"
	},{
		colkey 	: "sup",
		name 	: "物料厂商",
	},{
		colkey 	: "lotNum",
		name 	: "ERP批次",
	}];*/
	column_Cy=[{
		colkey 	: "orderno",
		name 	: "订单号",
		width	:"80px"
	},{
		colkey 	: "moduleCode",
		name 	: "组件条码",
		width	:"150px"
	},{
		colkey 	: "eva1Bar" ,
		name 	:"EVA1条码",
		width	:"100px"
			},{
		colkey 	: "eva1Fac" ,
		name 	:"EVA1厂商",
		width	:"180px"
			},{
		colkey 	: "eva1Erp" ,
		name 	:"EVA1ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "eva2Bar" ,
		name 	:"EVA2条码",
		width	:"100px"
			},{
		colkey 	: "eva2Fac" ,
		name 	:"EVA2厂商",
		width	:"180px"
			},{
		colkey 	: "eva2Erp" ,
		name 	:"EVA2ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "evaSmalBar" ,
		name 	:"EVA小条条码",
		width	:"100px"
			},{
		colkey 	: "evaSmalFac" ,
		name 	:"EVA小条厂商",
		width	:"150px"
			},{
		colkey 	: "evaSmalErp" ,
		name 	:"EVA小条ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "backBar" ,
		name 	:"背板条码",
		width	:"100px"
			},{
		colkey 	: "backFac" ,
		name 	:"背板厂商",
		width	:"180px"
			},{
		colkey 	: "backErp" ,
		name 	:"背板ERP批次",
		width	:"160px"
		
			},{
		colkey 	: "frameBar" ,
		name 	:"边框密封胶条码",
		width	:"120px"
			},{
		colkey 	: "frameFac" ,
		name 	:"边框密封胶厂商",
		width	:"150px"
			},{
		colkey 	: "frameErp" ,
		name 	:"边框密封胶ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "glassBar" ,
		name 	:"玻璃条码",
		width	:"100px"
			},{
		colkey 	: "glassFac" ,
		name 	:"玻璃厂商",
		width	:"150px"
			},{
		colkey 	: "glassErp" ,
		name 	:"玻璃ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "longFrameBar" ,
		name 	:"长边框条码",
		width	:"100px"
			},{
		colkey 	: "longFrameFac" ,
		name 	:"长边框厂商",
		width	:"150px"
			},{
		colkey 	: "longFrameErp" ,
		name 	:"长边框ERP批次",
		width	:"150px"
			},{
		colkey 	: "shortFrameBar" ,
		name 	:"短边框条码",
		width	:"100px"
			},{
		colkey 	: "shortFrameFac" ,
		name 	:"短边框厂商",
		width	:"150px"
			},{
		colkey 	: "shortFrameErp" ,
		name 	:"短边框ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "pourBar" ,
		name 	:"灌封胶条码",
		width	:"100px"
			},{
		colkey 	: "pourFac" ,
		name 	:"灌封胶厂商",
		width	:"150px"
			},{
		colkey 	: "pourErp" ,
		name 	:"灌封胶ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "interBar" ,
		name 	:"互连条条码",
		width	:"100px"
			},{
		colkey 	: "interFac" ,
		name 	:"互连条厂商",
		width	:"150px"
			},{
		colkey 	: "interErp" ,
		name 	:"互连条ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "infallBar" ,
		name 	:"汇流条条码",
		width	:"100px"
			},{
		colkey 	: "infallFac" ,
		name 	:"汇流条厂商",
		width	:"150px"
			},{
		colkey 	: "infallErp" ,
		name 	:"汇流条ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "boxBar" ,
		name 	:"接线盒条码",
		width	:"100px"
			},{
		colkey 	: "boxFac" ,
		name 	:"接线盒厂商",
		width	:"180px"
			},{
		colkey 	: "boxErp" ,
		name 	:"接线盒ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "insulatBar" ,
		name 	:"绝缘小条条码",
		width	:"100px"
			},{
		colkey 	: "insulatFac" ,
		name 	:"绝缘小条厂商",
		width	:"180px"
			},{
		colkey 	: "insulatErp" ,
		name 	:"绝缘小条ERP批次",
		width	:"150px"
		
			},{
		colkey 	: "baffleBar" ,
		name 	:"遮挡条条码",
		width	:"100px"
			},{
		colkey 	: "baffleFac" ,
		name 	:"遮挡条厂商",
		width	:"180px"
			},{
		colkey 	: "baffleErp" ,
		name 	:"遮挡条ERP批次",
		width	:"150px"}];
	
	
			
}