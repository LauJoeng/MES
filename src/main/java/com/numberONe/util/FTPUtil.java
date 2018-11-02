package com.numberONe.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;


public class FTPUtil { 
	
	/** 本地字符编码 */
	private static String LOCAL_CHARSET = "UTF-8";

	// FTP协议里面，规定文件名编码为iso-8859-1
	private static String SERVER_CHARSET = "ISO-8859-1";
	//ftp对象
    private FTPClient ftp;
    //需要连接到的ftp端的ip
    private String ip;
    //连接端口，默认21
    private int port;
    //要连接到的ftp端的名字
    private String name;
    //要连接到的ftp端的对应得密码
    private String pwd;
    //调用此方法，输入对应得ip，端口，要连接到的ftp端的名字，要连接到的ftp端的对应得密码。连接到ftp对象，并验证登录进入fto
    public FTPUtil(String ip,int port,String name,String pwd) {
        this.ftp = new FTPClient();
        this.ip = ip;
        this.port = port;
        this.name = name;
        this.pwd = pwd;
        FTPFile[] ftpFiles = null;  
        //验证登录
        try {
            ftp.connect(ip, port);
            System.out.println("连接ftp成功"); 
            if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
            	if (ftp.login(name, pwd)) {
            	if (FTPReply.isPositiveCompletion(ftp.sendCommand(
            	"OPTS UTF8", "ON"))) {// 开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
            	LOCAL_CHARSET = "UTF-8";
            	}
            	ftp.setControlEncoding(LOCAL_CHARSET);
            	ftp.enterLocalPassiveMode();// 设置被动模式
            	ftp.setFileType(FTP.BINARY_FILE_TYPE);
            	}
            }
        } catch (IOException e) {
        	System.out.println("抛出异常");
            e.printStackTrace();
        }
    }
    
    //上传文件
    public void upLoadFile(MultipartFile file,String pathname,String fileName) {
    	OutputStream os=null;
    	InputStream is=null;
        try {
        	ftp.makeDirectory(pathname);
            os = ftp.storeFileStream(fileName);
            is =file.getInputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = is.read(b)) != -1) {
                os.write(b,0,len);
            }
            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //下载文件
    public boolean downLoadFile(String fileurl,String fileName,String filedir){
    	boolean ret=false;
    	
    	OutputStream os=null;
    	try {
    		ftp.setFileType(FTP.BINARY_FILE_TYPE);
    		File file=new File(filedir);
    		file.mkdirs();
			os = new FileOutputStream(filedir+fileName);   
			ret=ftp.retrieveFile(fileurl, os);	
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret; 
    }
}
