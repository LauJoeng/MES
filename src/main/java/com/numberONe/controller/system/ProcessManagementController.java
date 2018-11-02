package com.numberONe.controller.system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.OrderProgress;
import com.numberONe.entity.ProcessCyFormMap;
import com.numberONe.entity.processData.CellDataHis;
import com.numberONe.entity.processData.ComponentDetails;
import com.numberONe.entity.processData.CyDataHis;
import com.numberONe.entity.processData.El1DataHis;
import com.numberONe.entity.processData.El3DataHis;
import com.numberONe.entity.processData.FqcDataHis;
import com.numberONe.entity.processData.FrameDataHis;
import com.numberONe.entity.processData.FtDataHis;
import com.numberONe.entity.processData.LayingDataHis;
import com.numberONe.entity.processData.PkgInfoDataHis;
import com.numberONe.entity.MateriaModeForMap;
import com.numberONe.mapper.OrderProgressMapper;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;
import com.numberONe.util.FTPUtils;
import com.numberONe.util.JsonUtils;
import com.numberONe.util.POIUtils;
@Controller
@RequestMapping("/processManagement/")
public class ProcessManagementController extends BaseController {
		@Inject
		private OrderProgressMapper orderProgressMapper ;
		/**
		 * 工序进展查询页面
		 * @return 返回工序进展查询页面
		 * @throws Exception
		 */
		@RequestMapping("orderProgress")
		public String orderProgressPage() throws Exception {
			return Common.BACKGROUND_PATH + "/system/processManagement/orderProgress";
		}
	
		/**
		 * 工序进展查询数据
		 * @param pageNow
		 * @param pageSize
		 * @param order_no
		 * @param module_code
		 * @return
		 * @throws Exception
		 */
		@ResponseBody
		@RequestMapping("findOrderProgressByPage")
		public PageView findPartReplaceByPage( String pageNow,
				String pageSize,String order_no,String module_code) throws Exception {			
			pageView=getPageView(pageNow,pageSize,"order_no");
			
			List<OrderProgress> list=new ArrayList<>() ;
			if(order_no!=null || module_code!=null ) {
				list=orderProgressMapper.getOrderProgressInfo(order_no, module_code);
				Integer startpage=(pageView.getPageNow()-1)*pageView.getPageSize();
				Integer endpage=pageView.getPageSize()+ (pageView.getPageNow()-1)*pageView.getPageSize();
				if(endpage>=list.size()) {
					endpage=list.size();
				}
				pageView.setQueryResult(list.size(), list.subList(startpage,endpage));	
				
			}else {
				pageView.setQueryResult(list.size(), list);	
			}							
	        return pageView;
		}
		@RequestMapping("OrderProgressExport")
		public void downloadOrderProgress(HttpServletRequest request, HttpServletResponse response,String order_no,String module_code) throws IOException {
			String fileName = "工序进展查询列表";
			String exportData =request.getParameterValues("exportData")[0];
			List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
			List<OrderProgress> lis =orderProgressMapper.getOrderProgressInfo(order_no, module_code);
			List<Map<String, Object>> select=new ArrayList<Map<String, Object>>();
			for(int j=0;j<lis.size();j++){
				lis.get(j);
				select.add(ConvertObjToMap(lis.get(j)));
			 }
			POIUtils.exportToExcel(response, listMap, select, fileName);
		}
		
		/**
		 * 工序查询页面
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("process")
		public String processPage() throws Exception {
			return Common.BACKGROUND_PATH + "/system/processManagement/process";
		}
				
		@ResponseBody
		@RequestMapping("selectProcess_Cy")
		public PageView selectProcess_Cy( String pageNow,
				String pageSize,String order_no,String equipCode,String begintime,String endtime) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessCy(equipCode, begintime, endtime));
	        return pageView;
		}
		@ResponseBody
		@RequestMapping("selectProcess_EL1")
		public PageView selectProcess_EL1( String pageNow,
				String pageSize,String order_no,String equipCode,String begintime,String endtime) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessEL1(order_no, begintime, endtime));
	        return pageView;
		}
		@ResponseBody
		@RequestMapping("selectProcess_EL3")
		public PageView selectProcess_EL3( String pageNow,
				String pageSize,String order_no,String equipCode,String begintime,String endtime) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessEL3(order_no, begintime, endtime));
	        return pageView;
		}
		@RequestMapping("processExport")
		public void downloadSelectProcess_Cy(HttpServletRequest request, HttpServletResponse response,String equipCode,String begintime,String endtime) throws IOException {
			String fileName = "工序查询列表";
			String exportData =request.getParameterValues("exportData")[0];
			List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
			List<ProcessCyFormMap> lis = orderProgressMapper.selectProcessCy(equipCode, begintime, endtime);
			List<Map<String, Object>> select=new ArrayList<Map<String, Object>>();
			for(int j=0;j<lis.size();j++){
				lis.get(j);
				select.add(ConvertObjToMap(lis.get(j)));
			 }
			POIUtils.exportToExcel(response, listMap, select, fileName);
		}
		
		
		
		//组件物料查询
		@RequestMapping("materialMode")
		public String materialModePage() throws Exception {
			return Common.BACKGROUND_PATH + "/system/processManagement/materialMode";
		}
		@ResponseBody
		@RequestMapping("selectMaterialMode")
		public PageView selectMaterialMode(String pageNow,String pageSize,String order_no,String module_code) throws Exception {
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectMaterialMode(module_code,order_no));
			return pageView;		
	        }
		@RequestMapping("materiaexport")
		public void downloadMaterialMode(HttpServletRequest request, HttpServletResponse response,String order_no,String module_code) throws IOException {
			String fileName = "组件物料列表";
			String exportData =request.getParameterValues("exportData")[0];
			List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
			List<MateriaModeForMap> lis = orderProgressMapper.selectMaterialMode(module_code,order_no);
			List<Map<String, Object>> select=new ArrayList<Map<String, Object>>();
			/*Map<String, Object>map=new HashMap<String, Object>();*/
			for(int j=0;j<lis.size();j++){
				lis.get(j);
				select.add(ConvertObjToMap(lis.get(j)));
			 }
			POIUtils.exportToExcel(response, listMap, select, fileName);
		}
		
	
		
		//组件详细信息查询Component details
		@RequestMapping("componentDetails")
		public String componentDetailsPage() throws Exception {
			return Common.BACKGROUND_PATH + "/system/processManagement/componentDetails";
		}
		@ResponseBody
		@RequestMapping("selectComponentDetails")
		public PageView selectComponentDetails(String pageNow,String pageSize,String order_no,String module_code) throws Exception {
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectComponentDetails(module_code,order_no));
	        return pageView;		
	        }
		//		组件详细信息查询导出excel
		@RequestMapping("componentexport")
		public void download(HttpServletRequest request, HttpServletResponse response,String order_no,String module_code) throws IOException {
			String fileName = "组件详细信息列表";
			String exportData =request.getParameterValues("exportData")[0];
			List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
			List<ComponentDetails> lis = orderProgressMapper.selectComponentDetails(module_code,order_no);
			List<Map<String, Object>> select=new ArrayList<Map<String, Object>>();
			/*Map<String, Object>map=new HashMap<String, Object>();*/
			for(int j=0;j<lis.size();j++){
				/*lis.get(j);*/
				select.add(ConvertObjToMap(lis.get(j)));
			 }
			POIUtils.exportToExcel(response, listMap, select, fileName);
		}
		
 
		
		
		
		
		
		@RequestMapping("deleteData")
		public String deleteDataProcessPage() throws Exception {
			return Common.BACKGROUND_PATH + "/system/processManagement/deleteData";
		}
		
		@RequestMapping("deleteDataExport")
		public void downloadDeleteDataExport(HttpServletRequest request, HttpServletResponse response,String processNameForExl,String module_code) throws IOException {
			String fileName = "删除数据查询列表";
			String exportData =request.getParameterValues("exportData")[0];
			System.out.println(processNameForExl+","+module_code);
			List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
			List<Map<String, Object>> select=new ArrayList<Map<String, Object>>();
			if(processNameForExl.equals("分片")) {
					List<CellDataHis> lis =orderProgressMapper.selectProcessHis_Cell(module_code);
					for(int j=0;j<lis.size();j++){
						lis.get(j);
						select.add(ConvertObjToMap(lis.get(j)));
					 }
				}else if(processNameForExl.equals("拼接")) {
					List<LayingDataHis> lis =orderProgressMapper.selectProcessHis_Laying(module_code);
					for(int j=0;j<lis.size();j++){
						lis.get(j);
						select.add(ConvertObjToMap(lis.get(j)));
					 }
				}else if(processNameForExl.equals("前道EL")) {
					List<El1DataHis> lis =orderProgressMapper.selectProcessHis_El1(module_code);
					for(int j=0;j<lis.size();j++){
						lis.get(j);
						select.add(ConvertObjToMap(lis.get(j)));
					 }
				}else if(processNameForExl.equals("层压")) {
					List<CyDataHis> lis =orderProgressMapper.selectProcessHis_Cy(module_code);
					for(int j=0;j<lis.size();j++){
						lis.get(j);
						select.add(ConvertObjToMap(lis.get(j)));
					 }
				}else if(processNameForExl.equals("装框")) {
					List<FrameDataHis> lis =orderProgressMapper.selectProcessHis_Frame(module_code);
					for(int j=0;j<lis.size();j++){
						lis.get(j);
						select.add(ConvertObjToMap(lis.get(j)));
					 }
				}else if(processNameForExl.equals("IV测试")) {
					List<FtDataHis> lis =orderProgressMapper.selectProcessHis_Ft(module_code);
					for(int j=0;j<lis.size();j++){
						lis.get(j);
						select.add(ConvertObjToMap(lis.get(j)));
					 }
				}else if(processNameForExl.equals("后道EL")) {
					List<El3DataHis> lis =orderProgressMapper.selectProcessHis_El3(module_code);
					for(int j=0;j<lis.size();j++){
						lis.get(j);
						select.add(ConvertObjToMap(lis.get(j)));
					 }
				}else if(processNameForExl.equals("FQC")) {
					List<FqcDataHis> lis =orderProgressMapper.selectProcessHis_Fqc(module_code);
					for(int j=0;j<lis.size();j++){
						lis.get(j);
						select.add(ConvertObjToMap(lis.get(j)));
					 }
				}else if(processNameForExl.equals("PKG")) {
					List<PkgInfoDataHis> lis =orderProgressMapper.selectProcessHis_Pkg(module_code);
					for(int j=0;j<lis.size();j++){
						lis.get(j);
						select.add(ConvertObjToMap(lis.get(j)));
					 }
				}
			
			
			
			POIUtils.exportToExcel(response, listMap, select, fileName);
		}

		//删除数据查询-分片
		@ResponseBody
		@RequestMapping("selectProcessHis_Cell")
		public PageView selectProcessHis_Cell( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_Cell(module_code));
	        return pageView;
		}
		//删除数据查询-前道
		@ResponseBody
		@RequestMapping("selectProcessHis_El1")
		public PageView selectProcessHis_El1( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_El1(module_code));
			 return pageView;
		}
		

		//删除数据查询-层压
		@ResponseBody
		@RequestMapping("selectProcessHis_Cy")
		public PageView selectProcessHis_Cy( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_Cy(module_code));
	        return pageView;
		}
		
		//删除数据查询-FQC
		@ResponseBody
		@RequestMapping("selectProcessHis_Fqc")
		public PageView selectProcessHis_Fqc( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_Fqc(module_code));
			return pageView;
		}	
				
		//删除数据查询-装框
		@ResponseBody
		@RequestMapping("selectProcessHis_Frame")
		public PageView selectProcessHis_Frame( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_Frame(module_code));
			return pageView;
		}								
		//删除数据查询-IV测试
		@ResponseBody
		@RequestMapping("selectProcessHis_Ft")
		public PageView selectProcessHis_Ft( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_Ft(module_code));
	        return pageView;
		}				
		//删除数据查询-拼接
		@ResponseBody
		@RequestMapping("selectProcessHis_Laying")
		public PageView selectProcessHis_Laying( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_Laying(module_code));
	        return pageView;
		}
		//删除数据查询-PKG
		@ResponseBody
		@RequestMapping("selectProcessHis_Pkg")
		public PageView selectProcessHis_Pkg( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_Pkg(module_code));
			return pageView;
		}
		//删除数据查询-后道
		@ResponseBody
		@RequestMapping("selectProcessHis_El3")
		public PageView selectProcessHis_El3( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_El3(module_code));
	        return pageView;
		}
		//删除数据查询-削边
		@ResponseBody
		@RequestMapping("selectProcessHis_Cutting")
		public PageView selectProcessHis_cutting( String pageNow,String pageSize,String order_no,String module_code) throws Exception {			
			pageView=burstView(pageNow,pageSize,orderProgressMapper.selectProcessHis_Cutting(module_code));
	        return pageView;
		}
					
		@RequestMapping("processImage")
		public String processImage( Model model) throws Exception {
			String imagepath = getPara("imagepath");
			loadImage(imagepath);
			model.addAttribute("imagepath", imagepath);
			return Common.BACKGROUND_PATH + "/system/processManagement/processImage";
		}
		public Boolean loadImage(String imagepath ) {
			String str=imagepath;
			FTPUtils f=FTPUtils.getInstance();
			String storePath=str.substring(0, str.lastIndexOf("\\"));
			 
			 String fileName=str.substring(str.lastIndexOf("\\")+1);
/*			 System.out.println(storePath);
			 System.out.println(fileName);*/
			if( !f.checkFile("192.168.1.220", storePath, fileName)) {
				return false;
			};
			 
			InputStream is=f.retrieveFile("192.168.1.220", storePath, fileName);
			File file= new File(this.getClass().getClassLoader().getResource("../../").getPath()+"/images/"+str) ;	
			System.out.println(file.getPath());
			try {
				if (!file.exists()) {//文档不存在的时候下载
					/*file.delete();*/
		            file.getParentFile().mkdirs();
		            file.createNewFile();
			         OutputStream optS = new FileOutputStream(file,true);
			         int c;
			         while((c=is.read())!=-1)
			         {
			             optS.write(c);
			         }
			         optS.flush();
					
		        }else {//判断大小是否符合 不符合删除重新下载
		        	Long file_check=f.checkFileSize("192.168.1.220", storePath, fileName);
		        	Long file_size=file.length();
		        	System.out.println("file_size:"+file_size+"file_check:"+file_check);
		        	
		        	if((file_size-file_check)!=0) {
				         OutputStream optS = new FileOutputStream(file,false);
				         int c;
				         while((c=is.read())!=-1)
				         {
				             optS.write(c);
				         }
				         optS.flush();
		        	}
		        	
		        	
		        }
				// 先得到文件的上级目录，并创建上级目录，在创建文件

		         f.logout();
		        
			}catch (Exception e) {
				System.out.println("文件写入错误");
			}
			 return true;
		}
		
		/**
		 * 对返回的LIST集合进行存储分页 并返回 PageView
		 * @return
		 */
		public  PageView burstView(String pageNow,String pageSize,List<?> t) {
			pageView=getPageView(pageNow,pageSize,"order_no");
			Integer startpage=(pageView.getPageNow()-1)*pageView.getPageSize();
			Integer endpage=pageView.getPageSize()+ (pageView.getPageNow()-1)*pageView.getPageSize();
			if(endpage>=t.size()) {
				endpage=t.size();
			}
			pageView.setQueryResult(t.size(), t.subList(startpage,endpage));
			return pageView;
		}
		//将对象转换成MAP
		public static Map<String, Object> ConvertObjToMap(Object obj) {  
	        Map<String, Object> reMap = new HashMap<String, Object>();  
	        if (obj == null)  
	            return null;  
	        Field[] fields = obj.getClass().getDeclaredFields();  
	        try {  
	            for (int i = 0; i < fields.length; i++) {  
	                try {  
	                    Field f = obj.getClass().getDeclaredField(  
	                            fields[i].getName());  
	                    f.setAccessible(true);
	                    Object o = f.get(obj);  
	                    reMap.put(fields[i].getName(), o);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        } catch (SecurityException e) {  
	            e.printStackTrace();  
	        }  
	        return reMap;  
	    } 
		/*public static void main(String[] args) {
			ProcessManagementController c= new ProcessManagementController();
			c.show();
			
		}
		public void show() {
			System.out.println(this.getClass().getClassLoader().getResource("").getPath());
			 File directory = new File("");// 参数为空
	         String courseFile;
			try {
				courseFile = directory.getCanonicalPath();
				 System.out.println(courseFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
*/
}
