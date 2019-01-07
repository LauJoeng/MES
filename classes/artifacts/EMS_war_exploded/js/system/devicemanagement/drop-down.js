//设备类型和部门的下拉列表
$(document).ready(function(){//页面开始加载时执行
	$.ajax({
	    async : false,
	    dataType:'json',
	    type : 'POST',
	    url : rootPath + '/device/alldeptandtype.shtml',
	    error : function(){
	        alert('设备类型查询失败 ');
	    },
	    success : function(data) {
	    	//设备类型
	    	 for (var i = 0; i < data.typelist.length; i++) {
	    		 $("#type").append("<option>" + data.typelist[i]+ "</option>");
	    	 }
	    	 //部门
	    	 for (var j = 0; j < data.deptlist.length; j++) {
	    		 $("#department").append("<option>" + data.deptlist[j]+ "</option>");
	    	 }
	    }
		
	});
	
	$.ajax({
	    async : false,
	    dataType:'json',
	    type : 'POST',
	    url : rootPath + '/devicem/select.shtml',
	    error : function(){
	        alert('失败 ');
	    },
	    success : function(data) {
	    	//设备类别
	    	 for (var i = 0; i < data.category.length; i++) {
	    		 $("#category").append("<option>" + data.category[i]+ "</option>");
	    	 }
	    	//车间
	    	 for (var i = 0; i < data.workshop.length; i++) {
	    		 $("#workshop").append("<option>" + data.workshop[i]+ "</option>");
	    	 }
	    	 //工序
	    	 for (var i = 0; i < data.process.length; i++) {
	    		 $("#process").append("<option>" + data.process[i]+ "</option>");
	    	 }
	    }
		
	});
	
});
