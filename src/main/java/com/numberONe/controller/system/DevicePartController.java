package com.numberONe.controller.system;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.DevicePartFormMap;
import com.numberONe.entity.DeviceRepairDetailFormMap;
import com.numberONe.entity.UserFormMap;
import com.numberONe.mapper.DeviceMapper;
import com.numberONe.mapper.DevicePartMapper;
import com.numberONe.mapper.DevicePartReplaceMapper;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;
import com.numberONe.util.JsonUtils;
import com.numberONe.util.POIUtils;

/**
 * 
 * @author numberONe 2014-11-19
 * @version 3.0v
 */
@Controller
@RequestMapping("/SpareParts/")
public class DevicePartController extends BaseController {
	@Inject
	private DeviceMapper deviceMapper;
	@Inject
	private DevicePartMapper devicePartMapper;
	@Inject
	private DevicePartReplaceMapper devicePartReplaceMapper;
	
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/devicepart/list";
	}
	
	//	所有配件信息
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DevicePartFormMap devicepartFormMap = getFormMap(DevicePartFormMap.class);
		System.out.println(devicepartFormMap);
		devicepartFormMap=toFormMap(devicepartFormMap, pageNow, pageSize,devicepartFormMap.getStr("orderby"));
		devicepartFormMap.put("column", column);
		devicepartFormMap.put("sort", sort);
        pageView.setRecords(devicePartMapper.findDevicePartPage(devicepartFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	
//	导出excel
	@RequestMapping("export")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "配件列表";
		DevicePartFormMap devicepartFormMap = findHasHMap(DevicePartFormMap.class);
		String exportData = devicepartFormMap.getStr("exportData");// 列表头的json字符串

		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);

		List<DevicePartFormMap> lis = devicePartMapper.findDevicePartPage(devicepartFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}
	
//	点击新增按钮弹出页面
	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception{
		return Common.BACKGROUND_PATH + "/system/devicepart/add";
	}
	
//	新增设备
	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="设备管理",methods="组管理-新增组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
		DevicePartFormMap devicepartFormMap = getFormMap(DevicePartFormMap.class);
		devicePartMapper.addEntity(devicepartFormMap);
		return "success";
	}

	/**
	 * 验证配件规格型号是否存在
	 * 
	 * @author numberONe  date：2014-2-19
	 * @param name
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(String name) {
		DevicePartFormMap account = devicePartMapper.findbyFrist("Spec", name, DevicePartFormMap.class);
		if (account == null) {
			return true;
		} else {
			return false;
		}
	}
	
//	编辑设备
	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("devicepart", devicePartMapper.findbyFrist("id", id, DevicePartFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/devicepart/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="配件系统管理",methods="组管理-修改组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
		DevicePartFormMap devicepartFormMap = getFormMap(DevicePartFormMap.class);
		devicePartMapper.editEntity(devicepartFormMap);
		return "success";
	}
	
//	删除设备
	@ResponseBody
	@RequestMapping("deleteId")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="配件管理",methods="组管理-删除组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		// 获取登录的bean
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);
		String delop = (String) userFormMap.get("accountName");
		//当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		String[] ids = getParaValues("ids");
		
		for (String id : ids) {
			devicePartMapper.delete("id", id,delop,df,DevicePartFormMap.class);
		}
		return "success";
	}
	
	//配件更换记录列表
	@RequestMapping("PartReplaceList")
	public String PartReplaceListUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/devicepart/PartReplaceList";
	}
	
	//所有配件更换记录
	@ResponseBody
	@RequestMapping("findPartReplaceByPage")
	public PageView findPartReplaceByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DeviceRepairDetailFormMap deviceRepairDetailFormMap = getFormMap(DeviceRepairDetailFormMap.class);
		deviceRepairDetailFormMap=toFormMap(deviceRepairDetailFormMap, pageNow, pageSize,deviceRepairDetailFormMap.getStr("orderby"));
		deviceRepairDetailFormMap.put("column", column);
		deviceRepairDetailFormMap.put("sort", sort);
        pageView.setRecords(devicePartReplaceMapper.findPartReplacePage(deviceRepairDetailFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	//查询所配件类型
	@ResponseBody
	@RequestMapping("findallftype")
	public List<String> findallftype(Model model) throws Exception {	
		return deviceMapper.seltype();
	}
}