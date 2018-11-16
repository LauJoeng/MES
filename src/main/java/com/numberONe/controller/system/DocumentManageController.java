package com.numberONe.controller.system;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.FileObject;

import com.numberONe.util.PropertiesUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.numberONe.mapper.DocumentMapper;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.Document;
import com.numberONe.entity.DocumentFormMap;
import com.numberONe.entity.RepairPlanFormMap;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;
import com.numberONe.util.FTPUtil;

/**
 * 
 * @author numberONe 2014-11-19
 * @version 3.0v
 */
@Controller
@RequestMapping("/document/")
public class DocumentManageController extends BaseController {
	@Inject
	private DocumentMapper  documentMapper;
	
	@RequestMapping("doclist")
	public String doclistUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/documentmanage/doclist";
	}
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DocumentFormMap documentFormMap = getFormMap(DocumentFormMap.class);
		documentFormMap=toFormMap(documentFormMap, pageNow, pageSize,documentFormMap.getStr("orderby"));
		documentFormMap.put("column", column);
		documentFormMap.put("sort", sort);
        pageView.setRecords(documentMapper.findDocumentPage(documentFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	
	//跳转到上传文档界面
	@RequestMapping("addDocumentUI")
	public String addDocumentUI() {
		return Common.BACKGROUND_PATH + "/system/documentmanage/addDocumentUI";
	}
	
	 /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String  fileUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {    
        //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String time=sdf.format(startTime);
        System.out.println(time);
        //获取上传的额外参数
        String dnumber = request.getParameter("dnumber");
        String dname = request.getParameter("dname");
        String remark=request.getParameter("remark");
        String filetype=request.getParameter("filetype");
        FTPUtil ftp = new FTPUtil("192.168.241.1",21,"anonymous","111111");
        String name=new String(file.getOriginalFilename().getBytes("GBK"),"iso-8859-1");
        String url="/EMSFILE/DevcieDocument/"+time+"/";
        ftp.upLoadFile(file,url,url+name);
        Document document=new Document();
        document.setDname(dname);
        document.setDnumber(dnumber);
        document.setFilename(file.getOriginalFilename());
        document.setRemark(remark);
        document.setFiletype(filetype);
        document.setFileurl(url);
        System.out.println(document);
        documentMapper.addDocEntity(document);
        long  endTime=System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "/success"; 
    }

    /**
     *返回文件流，让浏览器弹出文件下载提示框进行下载
     */
    @ResponseBody
    @RequestMapping(value = "/download")
    public String filedownload(@RequestParam("fileName")String fileName,@RequestParam("id")Integer fileId,HttpServletRequest request, HttpServletResponse response) throws IOException {
        FTPClient ftpClient = new FTPClient();
        System.out.println(fileName + ","+fileId);
        String fileurl=documentMapper.selectFileUrlById(fileId);
        try {
            int reply;
            ftpClient.connect((PropertiesUtils.findPropertiesKey("ftp.server")), Integer.parseInt(PropertiesUtils.findPropertiesKey("ftp.port")));
            ftpClient.login(PropertiesUtils.findPropertiesKey("ftp.user"),PropertiesUtils.findPropertiesKey("ftp.password"));
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)){
                ftpClient.disconnect();
                return "连接服务器失败,请关闭本窗口";
            }
            ftpClient.changeWorkingDirectory(fileurl);
            FTPFile[] fs = ftpClient.listFiles(fileName);
            if (fs.length==1){
                response.setContentType("application/x-download");//改变http请求头，返回文件流
                response.setHeader("Content-Disposition", "attachment;fileName=" + fs[0].getName());//文件用附件的方式返回
                response.setContentLength((int) fs[0].getSize());
                OutputStream os = response.getOutputStream();
                ftpClient.retrieveFile(fs[0].getName(),os);
                os.flush();
                os.close();
                System.out.println("文件找到");
            }else{
                System.out.println();
                return "未找到文件,请关闭本窗口";
            }
            ftpClient.logout();
            return "";
        }catch (Exception e){
            e.printStackTrace();
            return "下载出错,请关闭本窗口";
        }finally {
            if (ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }


//    @RequestMapping(value = "/download",method = RequestMethod.POST)
//    @ResponseBody
//    public boolean  filedownload(HttpServletRequest request) throws IOException {
//        //用来检测程序运行时间
//        long  startTime=System.currentTimeMillis();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
//        String time=sdf.format(startTime);
//        //下载到本地存储目录
//        String filedir = "D:\\Devicedownload\\"+time+"\\";
//        //获取上传的额外参数
//        String fileName = request.getParameter("fileName");
//        int id = Integer.parseInt(request.getParameter("id"));
//        String fileurl=documentMapper.selectFileUrlById(id);
//        //文件名转换成FTP服务器编码(FTP默认文件名编码格式,不转码文件无法下载)
//        String name = new String(fileName.getBytes("GBK"),"iso-8859-1");
//        System.out.println(fileurl+fileName);
//        FTPUtil ftp = new FTPUtil("192.168.1.220",21,"ftp","Blt@123");
//        boolean ret=ftp.downLoadFile(fileurl+name, fileName,filedir);
//        long  endTime=System.currentTimeMillis();
//        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
//        return ret;
//    }

    
    @ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="文档管理",methods="设备文档管理-删除设备文档")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			documentMapper.deleteByAttribute("id", id, DocumentFormMap.class);
		}
		return "success";
	}
}