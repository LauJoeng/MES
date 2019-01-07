<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/documentmanage/addDocument.js">
</script>
<link
    href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
    rel="stylesheet">
<link
    href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
    src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link
href="${pageContext.request.contextPath}/css/fileinput.min.css"
rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/zh.js"></script>

<style type="text/css">
input{
   		font-size: 16px;
   		border-color: #4876FF;
   		color: gray;
     }
</style>

</head>
<body>
	<div>
		<table   style="height:450px; border-collapse: collapse;margin:auto;font-size: 18px;">
			<tbody>
				<tr>
					<td>设备类别：</td>
					<td><input class=".input" type="text" id="dtype" readonly="readonly" style="width: 100%;"/></td>
					<td>&nbsp;&nbsp;&nbsp;设备编号：</td>
					<td><input type="text"  id="dnumber" readonly="readonly" style="width: 100%;"/></td>
					
				</tr>
				<tr>
					<td>设备名称：</td>
					<td><input type="text" id="dname" readonly="readonly" style="width: 100%;"/></td>
					<td>&nbsp;&nbsp;&nbsp;规格型号：</td>
					<td><input type="text" id="dstandard" readonly="readonly" style="width: 100%;"/></td>
					
				</tr>
				<tr>
					<td>所在部门：</td>
					<td><input type="text"  id="usedept" readonly="readonly" style="width: 100%;"/></td>
					<td>&nbsp;&nbsp;&nbsp;<input type="button" id="seldevice" value="选择设备"  style="font-size: 17px;color:black;"/></td>
				</tr>
				<tr>
					<td>文件分类：</td>
					<td colspan="3">
						<select  id="filetype"  style="font-size: 16px;
   								border:2px solid #4876FF;width:39%;height: 28px;" >
   							<option value="普通文档">普通文档</option>
							<option value="采购类文档">采购类文档</option>
							<option value="操作手册类">操作手册类</option>
						</select>
					</td>
				</tr>
				<tr>
					<td style="vertical-align: top;">文档备注：</td>
					<td><textarea style="font-size: 20px;width: 240%;height: 150px;
        		border:2px solid #4876FF;" id="remark" ></textarea></td>
				</tr>
				<tr>
					<td colspan="4">
						<input id="uploadfile" type="file" name="file" class="file file-loading" />
						<script type="text/javascript">
							
							//上传组件初始化
						    $("#uploadfile").fileinput({
						    	language:"zh",   //设置语言
						        uploadUrl: "${ctx}/document/upload.shtml", //上传的地址 
								//allowedFileExtensions: ['doc','docx','png','pdf'],//接收的文件后缀 */
						        uploadAsync: true, //默认异步上传
						        showUpload: true, //是否显示上传按钮
						        showRemove : true, //显示移除按钮
						        showPreview : false, //是否显示预览 
						        showCaption: true,//是否显示标题 
						        browseClass: "btn btn-primary", //按钮样式     
						        dropZoneEnabled: false,//是否显示拖拽区域  
						        maxFileCount: 10, //表示允许同时上传的最大文件个数
						        enctype: 'multipart/form-data',
						        validateInitialCount:true,
						        uploadExtraData: function(previewId, index) {   //额外参数
						            var obj = {};
						            obj.dnumber =$("#dnumber").val();
						            obj.dname =$("#dname").val();
						            obj.remark=$("#remark").val();
						            obj.filetype=$("#filetype").val();
						            return obj;
						        } 
						    }).on('filepreajax', function(event, previewId, index) { 
						    	
						    	if ($("#dnumber").val()=="") {
						    		layer.alert("请选择关联设备信息");
							    	$(".progress").hide();
							    	$("#uploadfile").fileinput('enable');	
									return false;
								} 	
						  
						    }).on("fileuploaded", function(event, data) {
						        if(data.response)
						        {
						            layer.alert("上传成功!");
						        };
						        $("#dnumber").val("");
						        $("#dname").val("");
						        $("#remark").val("");
						        $("#dtype").val("");
						        $("#usedept").val("");
						        $("#dstandard").val("");
						        $("#filetype").val("普通文档");
						        $(".progress").hide();
						    	$("#uploadfile").fileinput('enable');
						    	
						    });
						</script>
					</td>
				</tr>
				
			</tbody>
		</table>
		
	</div>
</body>
</html>