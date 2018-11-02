$(document).ready(function() {// 页面开始加载时执行
	// 所有工序查询
	$.ajax({
				async : false,
				dataType : 'json',
				type : 'POST',
				url : rootPath + '/operationData/selectName.shtml',
				error : function() {
					alert('工序查询失败 ');
				},
				success : function(data) {
					// 工序
					for (var i = 0; i < data.length; i++) {
						$("#processName").append("<option>" + data[i]+ "</option>");
					}
				}
			});
});

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
			shrinkToFit:false,
			autoScroll: false,
			width : '100%',
			pagId : 'paging',
			data : searchParams,
			isFixed : false,
			l_column :column_Cy ,
			/*jsonUrl : rootPath + '/processManagement/selectProcessHis_Cy.shtml',*/
			jsonUrl : rootPath + selectedUrl,
			checkbox : true,
			serNumber : true
		});
	
	});		
});

var selectedOption =function(){
	var processName = $("#processName option:selected").html();
	$("#processNameForExl").val(processName);
	var module_code=$("#module_code").val();
	if(module_code==null ||module_code==''){
		alert("请输入组件条码");
		return false;
	}
	/*alert(processName);*/
	if(processName=="分片"){
			column_Cy=[{ colkey : "module_code", name : "组件条码" ,width:"140px"
			},{ colkey : "cell_code"	, name : "电池条码" 
			},{ colkey : "op"			, name : "操作人" 
			},{ colkey : "cell_code2"	, name : "电池条码2" 
			},{ colkey : "cell_code3"	, name : "电池条码3" 
			},{ colkey : "cell_op"		, name : "设备号" 
			},{ colkey : "cell_mc"		, name : "电脑编码" 
			},{ colkey : "createtime"	, name : "创建时间" ,width:"100px"
			},{ colkey : "line"			, name : "线别"
			},{ colkey : "delop"		, name : "删除人" 
			},{ colkey : "deltime"		, name : "删除时间" ,width:"100px"
			},{ colkey : "effective"	, name : "有效状态" 
			}];
			selectedUrl='/processManagement/selectProcessHis_Cell.shtml';
	}else if(processName=="拼接"){
			column_Cy=[{ colkey : "module_code", name : "组件条码" ,width:"140px"
			},{ colkey : "equipcode"	, name : "设备号"  
			},{ colkey : "computer"		, name : "操作电脑"  					
			},{ colkey : "createtime"	, name : "创建时间" ,width:"100px"
			},{ colkey : "op"			, name : "操作人"
			},{ colkey : "line"			, name : "线别"
			},{ colkey : "delop"		, name : "删除人" 
			},{ colkey : "deltime"		, name : "删除时间"  ,width:"100px"
			},{ colkey : "effective"	, name : "有效状态" 
			}];	
			selectedUrl='/processManagement/selectProcessHis_Laying.shtml';
	}else if(processName=="前道EL"){
			column_Cy=[{ colkey : "module_code", name : "组件条码" ,width:"140px"
			},{ colkey : "equipcode"	, name : "设备号"  		  					
			},{ colkey : "el_test_time"	, name : "EL测试时间"  ,width:"100px"
			},{ colkey : "op"			, name : "操作人"
			},{ colkey : "imagepath"	, name : "图片路径" 	,width:"100px"
			},{ colkey : "line"			, name : "线别"
			},{ colkey : "shiftName"	, name : "班别" 
			},{ colkey : "result"		, name : "结果" 
			},{ colkey : "delop"		, name : "删除人" 
			},{ colkey : "deltime"		, name : "删除时间"  	,width:"100px"
			},{ colkey : "effective"	, name : "有效状态" 
			}];
			selectedUrl='/processManagement/selectProcessHis_El1.shtml';
	}else if(processName=="层压"){
			selectedUrl='/processManagement/selectProcessHis_Cy.shtml';
			column_Cy=[{colkey : "module_code",name : "组件条码",width:"140px"
			},{colkey : "equipCode"		,name : "设备编号"
			},{colkey : "locationno"	,name : "摆放"
			},{colkey : "op"			,name : "操作人"
			}, {colkey : "createtime"	,name : "层压时间",
				renderData : function(rowindex,data, rowdata, column) {return new Date(data).format("yyyy-MM-dd  hh:mm:ss");} ,width:"100px"
			},{colkey : "shiftName"		,name : "班次"
			},{colkey : "computer"		,name : "电脑编号"
			},{colkey : "line"			,name : "线别"
			},{colkey : "delop"			,name : "删除人"
			},{colkey : "deltime"		,name : "删除时间" 	,width:"100px"
			},{colkey : "effective"		,name : "有效状态"
			}];
/*			column_Cy=[{ colkey : "module_code", name : "组件条码" },{ colkey : "equipCode", name : "设备编号" },{ colkey : "locationno", name : "摆放" },{ colkey : "op", name : "操作人" }, { colkey : "createtime",			 name : "层压时间", renderData : function(rowindex,data, rowdata, column) { 	return new Date(data).format("yyyy-MM-dd  hh:mm:ss"); } },{ colkey : "shiftName", name : "班次" },{ colkey : "computer", name : "电脑编号" },{ colkey : "line", name : "线别" },{ colkey : "delop", name : "删除人" },{ colkey : "deltime", name : "删除时间" },{ colkey : "effective", name : "有效状态" }];
*/			
	}else if(processName=="装框"){
			column_Cy=[{ colkey : "module_code", name : "组件条码" ,width:"140px"
			},{ colkey : "equipcode"	, name : "设备号"  		  					
			},{ colkey : "op"			, name : "操作人"
			},{ colkey : "line"			, name : "线别"
			},{ colkey : "shiftName"	, name : "班别" 
			},{ colkey : "createtime"	, name : "创建时间"  ,width:"100px"
			},{ colkey : "computername"	, name : "操作电脑" 
			},{ colkey : "delop"		, name : "删除人" 
			},{ colkey : "deltime"		, name : "删除时间"  ,width:"100px"
			},{ colkey : "effective"	, name : "有效状态" 
			}];
			selectedUrl='/processManagement/selectProcessHis_Frame.shtml';

	}else if(processName=="IV测试"){
			column_Cy=[{ colkey : "module_code", name : "组件条码" ,width:"140px"
			},{ colkey : "equipcode"	, name : "设备号" 	,width:"100px"  		  					
			},{ colkey : "op"			, name : "操作人" 	,width:"150px"
			},{ colkey : "line"			, name : "线别" 		,width:"80px"
			},{ colkey : "shiftName"	, name : "班别"  		,width:"80px"
			},{ colkey : "createtime"	, name : "创建时间"  	,width:"120px"
			},{ colkey : "test_time"	, name : "测试时间"  	,width:"120px"
			},{ colkey : "computer"		, name : "操作电脑"  	,width:"150px"
			},{ colkey : "ncell"		, name : "ncell"  	,width:"80px"	
			},{ colkey : "rsh"			, name : "Rsh"  	,width:"80px"	
			},{ colkey : "rs"			, name : "Rs"  		,width:"80px"	
			},{ colkey : "ff"			, name : "FF"  		,width:"80px"	
			},{ colkey : "isc"			, name : "Isc"  	,width:"80px"	
			},{ colkey : "voc"			, name : "Voc"  	,width:"80px"	
			},{ colkey : "imax"			, name : "Imax"  	,width:"80px"
			},{ colkey : "vmax"			, name : "Vmax"  	,width:"80px"
			},{ colkey : "pmax"			, name : "Pmax"  	,width:"80px"
			},{ colkey : "envTemp"		, name : "EnvTemp"  ,width:"80px"
			},{ colkey : "surfTemp"		, name : "SurfTemp" ,width:"80px"
			},{ colkey : "f_power"		, name : "额定电压"  	,width:"80px"
			},{ colkey : "f_ia"			, name : "额定电流"  	,width:"80px"
			},{ colkey : "iv_path"		, name : "iv_path"  ,width:"350px"
			},{ colkey : "nmodule"		, name : "nmodule"  ,width:"60px"
			},{ colkey : "delop"		, name : "删除人"  	,width:"100px"
			},{ colkey : "deltime"		, name : "删除时间" 	,width:"100px"
			},{ colkey : "effective"	, name : "有效状态"  	,width:"100px"
			}];
			selectedUrl='/processManagement/selectProcessHis_Ft.shtml';
	}else if(processName=="后道EL"){
			column_Cy=[{ colkey : "module_code", name : "组件条码" ,width:"140px"
			},{ colkey : "equipcode"	, name : "设备号"  		  					
			},{ colkey : "el_test_time"	, name : "EL测试时间"  	,width:"100px"
			},{ colkey : "op"			, name : "操作人"
			},{ colkey : "imagepath"	, name : "图片路径" 		,width:"100px"
			},{ colkey : "line"			, name : "线别"
			},{ colkey : "shiftName"	, name : "班别" 
			},{ colkey : "result"		, name : "结果" 
			},{ colkey : "delop"		, name : "删除人" 
			},{ colkey : "deltime"		, name : "删除时间"  		,width:"100px"
			},{ colkey : "effective"	, name : "有效状态" 
			}];
			selectedUrl='/processManagement/selectProcessHis_El3.shtml';
	}else if(processName=="FQC"){
			column_Cy=[{ colkey : "module_code", name : "组件条码"	,width:"140px" 
			},{ colkey : "equipcode"		, name : "设备号"  		  					
			},{ colkey : "op"				, name : "操作人"
			},{ colkey : "line"				, name : "线别"
			},{ colkey : "shiftName"		, name : "班别" 
			},{ colkey : "fqc_time"			, name : "创建时间"  	,width:"100px"
			},{ colkey : "computer"			, name : "电脑编号"
			},{ colkey : "back_code"		, name : "back_code" 
			},{ colkey : "bk_code"			, name : "bk_code"
			
			},{ colkey : "color"			, name : "颜色" 
			},{ colkey : "remark"			, name : "备注"  
			},{ colkey : "delop"			, name : "删除人" 
			},{ colkey : "deltime"			, name : "删除时间"  ,width:"100px"
			},{ colkey : "effective"		, name : "有效状态" 
			}];
			selectedUrl='/processManagement/selectProcessHis_Fqc.shtml';
	}else if(processName=="PKG"){
			column_Cy=[{ colkey : "module_code", name : "组件条码" ,width:"140px"
			},{ colkey : "package_code"		, name : "包装条码" 
			},{ colkey : "module_model"		, name : "组件型号" 
			},{ colkey : "Material_Number"	, name : "成品编号"
			},{ colkey : "grade"			, name : "组件等级"
			},{ colkey : "fPower"			, name : "额定功率"
			},{ colkey : "moduleseries"		, name : "组件系列号"
			},{ colkey : "op"				, name : "操作人"
			},{ colkey : "delop"			, name : "删除人"  	,width:"100px"
			},{ colkey : "deltime"			, name : "删除时间" 
			},{ colkey : "effective"		, name : "有效状态" 
			}];
			selectedUrl='/processManagement/selectProcessHis_Pkg.shtml';
	}else if(processName=="削边"){
			column_Cy=[{ colkey : "module_code", name : "组件条码" ,width:"140px"
			},{ colkey : "equipcode"		, name : "设备号" 
			},{ colkey : "line"				, name : "线别"
			},{ colkey : "shiftName"		, name : "班别" 
			},{ colkey : "op"				, name : "操作人"
			},{ colkey : "isprint"			, name : "isprint" 
			},{ colkey : "isrfid"			, name : "isrfid"
			},{ colkey : "delop"			, name : "删除人" 
			},{ colkey : "deltime"			, name : "删除时间"  	,width:"100px"
			},{ colkey : "effective"		, name : "有效状态" 
			}];
			selectedUrl='/processManagement/selectProcessHis_Cutting.shtml';
	}else{
		alert(processName+"查询条件不存在！！");
		return false;
	}
	return true;
}

