package com.numberONe.util;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
 
/**
 * FTP服务器工具类
 * 
 * @author 码农先生
 * @version 1.0
 * @date 2013-11-18
 */
public class FTPUtils {
	
	private static FTPUtils ftpUtils;
	private FTPClient ftpClient;
	
	private String port; // 服务器端口
	private String username; // 用户登录名
	private String password; // 用户登录密码
	
	private InputStream is; // 文件下载输入流
	
	/**
	 * 私有构造方法
	 */
	private FTPUtils() {
		initConfig();
		if (null == ftpClient) {
			ftpClient = new FTPClient();
		}
	}
 
	/**
	 * 获取FTPUtils对象实例
	 * @return
	 * 		FTPUtils对象实例
	 */
	public String returnName() {
		return port+username+password;
	}
	public synchronized static FTPUtils getInstance () {
		if (null == ftpUtils) {
			ftpUtils = new FTPUtils();
		}
		return ftpUtils;
	}
	
	/**
	 * 初始化FTP服务器连接属性
	 */
	public void initConfig () {
		// 构造Properties对象
		Properties properties = new Properties();
		
		// 定义配置文件输入流
		InputStream is = null;
		try {
			// 获取配置文件输入流
			is = FTPUtils.class.getResourceAsStream("/ftp.properties");
			// 加载配置文件
			properties.load(is);
			// 读取配置文件
			port = (String) properties.get("port"); // 设置端口
			username = (String) properties.get("username"); // 设置用户名
			password = (String) properties.get("password"); // 设置密码
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 判断输入流是否为空
			if (null != is) {
				try {
					// 关闭输入流
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 连接（配置通用连接属性）至服务器
	 * 
	 * @param serverName
	 * 		服务器名称
	 * @param remotePath
	 * 		当前访问目录
	 * @return
	 * 		<b>true</b>：连接成功
	 * 		<br/>
	 * 		<b>false</b>：连接失败
	 */
	public boolean connectToTheServer (String serverName, String remotePath) {
		// 定义返回值
		boolean result = false;
		try {
			// 连接至服务器，端口默认为21时，可直接通过URL连接
			ftpClient.connect(serverName, Integer.parseInt(port));
			// 登录服务器
			ftpClient.login(username, password);
			// 判断返回码是否合法
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				// 不合法时断开连接
				ftpClient.disconnect();
				// 结束程序
				return result;
			}
			// 设置文件操作目录
			result = ftpClient.changeWorkingDirectory(remotePath);
			System.out.println("操作路径改变:"+result);
			// 设置文件类型，二进制
			result = ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 设置缓冲区大小
			ftpClient.setBufferSize(1024000);
			// 设置字符编码
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.enterLocalPassiveMode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 上传文件至FTP服务器
	 * 
	 * @param serverName
	 * 		服务器名称
	 * @param storePath
	 * 		上传文件存储路径
	 * @param fileName
	 * 		上传文件存储名称
	 * @param is
	 * 		上传文件输入流
	 * @return
	 * 		<b>true</b>：上传成功
	 * 		<br/>
	 * 		<b>false</b>：上传失败
	 */
	public boolean storeFile (String serverName, String storePath, String fileName, InputStream is) {
		boolean result = false;
		try {
			// 连接至服务器
			result = connectToTheServer(serverName, storePath);
			// 判断服务器是否连接成功
			if (result) {
				// 上传文件
				result = ftpClient.storeFile(fileName, is);
			}
			// 关闭输入流
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 判断输入流是否存在
			if (null != is) {
				try {
					// 关闭输入流
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 登出服务器并断开连接
			ftpUtils.logout();
		}
		return result;
	}
	
	/**
	 * 下载FTP服务器文件至本地<br/>
	 * 操作完成后需调用logout方法与服务器断开连接
	 * 
	 * @param serverName
	 * 		服务器名称
	 * @param remotePath
	 * 		下载文件存储路径
	 * @param fileName
	 * 		下载文件存储名称
	 * @return
	 * 		<b>InputStream</b>：文件输入流
	 */
	public InputStream retrieveFile (String serverName, String remotePath, String fileName) {
		try {
			boolean result = false;
			// 连接至服务器
			result = connectToTheServer(serverName, remotePath);
			System.out.println("result:"+result);
			// 判断服务器是否连接成功
			if (result) {
				// 获取文件输入流
				is = ftpClient.retrieveFileStream(fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}
	
	/**
	 * 删除FTP服务器文件
	 * 
	 * @param serverName
	 * 		服务器名称
	 * @param remotePath
	 * 		当前访问目录
	 * @param fileName
	 * 		文件存储名称
	 * @return
	 * 		<b>true</b>：删除成功
	 * 		<br/>
	 * 		<b>false</b>：删除失败
	 */
	public boolean deleteFile (String serverName, String remotePath, String fileName) {
		boolean result = false;
		// 连接至服务器
		result = connectToTheServer(serverName, remotePath);
		// 判断服务器是否连接成功
		if (result) {
			try {
				// 删除文件
				result = ftpClient.deleteFile(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 登出服务器并断开连接
				ftpUtils.logout();
			}
		}
		return result;
	}
	
	/**
	 * 检测FTP服务器文件是否存在
	 * 
	 * @param serverName
	 * 		服务器名称
	 * @param remotePath
	 * 		检测文件存储路径
	 * @param fileName
	 * 		检测文件存储名称
	 * @return
	 * 		<b>true</b>：文件存在
	 * 		<br/>
	 * 		<b>false</b>：文件不存在
	 */
	public boolean checkFile (String serverName, String remotePath, String fileName) {
		boolean result = false;
		try {
			// 连接至服务器
			result = connectToTheServer(serverName, remotePath);
			// 判断服务器是否连接成功
			if (result) {
				// 默认文件不存在
				result = false;
				// 获取文件操作目录下所有文件名称
				String[] remoteNames = ftpClient.listNames();
				// 循环比对文件名称，判断是否含有当前要下载的文件名
				for (String remoteName: remoteNames) {
					System.out.println("remoteName:"+remoteName);
					if (fileName.equals(remoteName)) {
						result = true;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 登出服务器并断开连接
			ftpUtils.logout();
		}
		return result;
	}
	public Long checkFileSize (String serverName, String remotePath, String fileName) {
		boolean result = false;
		FTPFile[] files = null;
		Long fileSize = -1L;
		result = connectToTheServer(serverName, remotePath);
		// 判断服务器是否连接成功
		if (result) {
			try {
				files = ftpClient.listFiles(fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			if(null != files && files.length > 0)
			{
				fileSize = files[0].getSize();
			}
			System.out.println(fileSize);
		}
		return fileSize;
	}
	
 
	/**
	 * 登出服务器并断开连接
	 * 
	 * @param ftp
	 * 		FTPClient对象实例
	  * @return
	 * 		<b>true</b>：操作成功
	 * 		<br/>
	 * 		<b>false</b>：操作失败
	 */
	public boolean logout () {
		boolean result = false;
		if (null != is) {
			try {
				// 关闭输入流
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (null != ftpClient) {
			try {
				// 登出服务器
				result = ftpClient.logout();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 判断连接是否存在
				if (ftpClient.isConnected()) {
					try {
						// 断开连接
						ftpClient.disconnect();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}
	
}