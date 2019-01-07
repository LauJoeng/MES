//设备类型
$(document).ready(function(){
	$.ajax({
	    async : false,
	    dataType:'json',
	    type : 'POST',
	    url : rootPath + '/device/alldeptandtype.shtml',
	    error : function(){
	        alert('smx失败 ');
	    },
	    success : function(data){
	    	//设备类型
	    	 for (var i = 0; i < data.typelist.length; i++) {
	    		 $("#type").append("<option>" + data.typelist[i]+ "</option>");
	    	 }
	    }
		
	});
	
});






