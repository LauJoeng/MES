
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
			l_column 	:column_Cy,
			jsonUrl 	: rootPath + '/processManagement/selectComponentDetails.shtml',
			checkbox 	: true,
			serNumber 	: true
		});
		
	});
});

var selectedOption =function(){
		column_Cy=[{
			colkey 	: "order_no",
			name 	: "订单号",
			width 	: "100px"
		},{
			colkey 	: "module_code",
			name 	: "组件条码",
			width 	: "150px"
		},{
			colkey 	: "cellcode",
			name 	: "电池条码",
			width 	: "100px"
		},{
			colkey 	: "fpequip",
			name 	: "焊接设备",
			width 	: "100px"
		},{
			colkey 	: "fpline",
			name 	: "焊接线别",
			width 	: "80px"
		},{
			colkey 	: "fptime",
			name 	: "焊接时间",
			width 	: "180px"
		},{
			colkey 	: "pjop",
			name 	: "拼接员工",
			width 	: "280px"
		},{
			colkey 	: "pjtime",
			name 	: "拼接时间",
			width 	: "180px"
		},{
			colkey 	: "pjequip",
			name 	: "拼接设备",
			width 	: "80px"
		},{
			colkey 	: "pjline",
			name 	: "拼接线别",
			width 	: "80px"
		},{
			colkey 	: "el1op",
			name 	: "前道员工",
			width 	: "80px"
		},{
			colkey 	: "el1time",
			name 	: "前道EL时间 ",
			width 	: "180px"
		},{
			colkey 	: "el1euip",
			name 	: "前道EL设备",
			width 	: "80px"
		},{
			colkey 	: "el1line",
			name 	: "前道EL等级",
			width 	: "80px"
		},{
			colkey 	: "cyequip",
			name 	: "层压设备",
			width 	: "100px"
		},{
			colkey 	: "cyop",
			name 	: "层压员工",
			width 	: "180px"
		},{
			colkey 	: "cytime",
			name 	: "层压时间",
			width 	: "180px"
		},{
			colkey 	: "cyline",
			name 	: "层压线别",
			width 	: "80px"
		},{
			colkey 	: "zktime",
			name 	: "装框时间",
			width 	: "180px"
		},{
			colkey 	: "zkop",
			name 	: "装框员工",
			width 	: "600px"
		},{
			colkey 	: "zkequip",
			name 	: "装框设备",
			width 	: "80px"
		},{
			colkey 	: "fttime",
			name 	: "IV时间",
			width 	: "180px"
		},{
			colkey 	: "pmax",
			name 	: "Pmax",
			width 	: "80px"
		},{
			colkey 	: "ff",
			name 	: "FF",
			width 	: "80px"
		},{
			colkey 	: "isc",
			name 	: "Isc",
			width 	: "80px"
		},{
			colkey 	: "voc",
			name 	: "Voc",
			width 	: "80px"
		},{
			colkey 	: "imax",
			name 	: "Imax",
			width 	: "80px"
		},{
			colkey 	: "ftop",
			name 	: "IV员工",
			width 	: "130px"
		},{
			colkey 	: "f_power",
			name 	: "额定功率",
			width 	: "80px"
		},{
			colkey 	: "f_ia",
			name 	: "额定电流",
			width 	: "80px"
		},{
			colkey 	: "ftline",
			name 	: "IV线别",
			width 	: "60px"
		},{
			colkey 	: "ftequip",
			name 	: "IV设备",
			width 	: "100px"
		},{
			colkey 	: "el3time",
			name 	: "后道EL时间",
			width 	: "180px"
		},{
			colkey 	: "el3result",
			name 	: "后道EL等级",
			width 	: "80px"
		},{
			colkey 	: "el3equip",
			name 	: "后道EL设备",
			width 	: "80px"
		},{
			colkey 	: "el3line",
			name 	: "后道EL线别",
			width 	: "80px"
		},{
			colkey 	: "fqctime",
			name 	: "FQC时间",
			width 	: "180px"
		},{
			colkey 	: "fqcgrade",
			name 	: "FQC等级",
			width 	: "80px"
		},{
			colkey 	: "color",
			name 	: "组件颜色",
			width 	: "80px"
		},{
			colkey 	: "fqcequip",
			name 	: "FQC设备",
			width 	: "80px"
		},{
			colkey 	: "package_code",
			name 	: "包装托盘",
			width 	: "100px"
		}];
}


