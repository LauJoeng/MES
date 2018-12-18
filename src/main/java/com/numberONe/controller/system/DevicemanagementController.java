package com.numberONe.controller.system;


import java.io.IOException;
import java.util.*;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.numberONe.entity.*;
import com.numberONe.mapper.mapper2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberONe.mapper.DevicemanagementMapper;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
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
@RequestMapping("/devicem/")
public class DevicemanagementController extends BaseController {

	@Inject
	private DevicemanagementMapper deviceMapper;

	@Autowired
	private DeviceStorageMapper deviceStorageMapper;

	@Autowired
	private ItemStorageMapper itemStorageMapper;

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private ProviderMapper providerMapper;

	@Autowired
	private PStateMapper pStateMapper;

	@Autowired
	private WareHouseListMapper wareHouseListMapper;
	
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/devicemanagement/list";
	}
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DeviceFormMap deviceFormMap = getFormMap(DeviceFormMap.class);
		deviceFormMap=toFormMap(deviceFormMap, pageNow, pageSize,deviceFormMap.getStr("orderby"));
		deviceFormMap.put("column", column);
		deviceFormMap.put("sort", sort);
        pageView.setRecords(deviceMapper.findDevicePage(deviceFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	
//	导出excel
	@RequestMapping("export")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "设备列表";
		DeviceFormMap deviceFormMap = findHasHMap(DeviceFormMap.class);
		String exportData = deviceFormMap.getStr("exportData");// 列表头的json字符串

		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);

		List<DeviceFormMap> lis = deviceMapper.findDevicePage(deviceFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}
	
//	点击新增按钮弹出页面
	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception{
		return Common.BACKGROUND_PATH + "/system/devicemanagement/add";
	}
	
//	新增设备
	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="设备管理",methods="组管理-新增组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
		DeviceFormMap deviceFormMap = getFormMap(DeviceFormMap.class);
		deviceMapper.addEntity(deviceFormMap);
		return "success";
	}

	/**
	 * 验证设备编号是否存在
	 * 
	 * @author numberONe  date：2014-2-19
	 * @param name
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(String name) {
		DeviceFormMap account = deviceMapper.findbyFrist("number", name, DeviceFormMap.class);
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
			DeviceFormMap DeviceFormMap = deviceMapper.findbyFrist("id", id, DeviceFormMap.class);
			model.addAttribute("device", deviceMapper.findbyFrist("id", id, DeviceFormMap.class));
			System.out.println(DeviceFormMap);
		}
		return Common.BACKGROUND_PATH + "/system/devicemanagement/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="组管理-修改组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
		DeviceFormMap deviceFormMap = getFormMap(DeviceFormMap.class);
		deviceMapper.editEntity(deviceFormMap);
		return "success";
	}
	
//	删除设备
	@ResponseBody
	@RequestMapping("deleteId")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="消耗品管理",methods="组管理-删除组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids){
			//deviceMapper.deleteByAttribute("id", id, DeviceFormMap.class);
			deviceMapper.delete("id", id, DeviceFormMap.class);
			System.out.println("*****************"+id);
		}
		return "success";
	}
	
	//工序,车间
	@ResponseBody
	@RequestMapping("select")
	public Map<String,List<String>> selectProcess(){
		List<String> process = deviceMapper.processName();
		List<String> workshop = deviceMapper.workshop();
		List<String> category = deviceMapper.seletype();
		List<String> seldept = deviceMapper.seldept();
		Map<String,List<String>> map = new HashMap<String,List<String>>();
	    map.put("process", process);//工序
	    map.put("workshop", workshop);//生产车间
	    map.put("category", category);//设备类别（生产或非生产）
	    map.put("seldept", seldept);//部门
 		return map;
	}

	@RequestMapping("deviceStorageListUI")
	public String deviceStorageListUI(Model model){
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/devicemanagement/deviceStorageList";
	}

	//2018.11.30
	@ResponseBody
	@RequestMapping("findDeviceStorageList")
	public PageView findDeviceStorageList(String pageNow, String pageSize,String column,String sort){
		PageView p = getPageView(pageNow,pageSize,column);
//		Map<String,String>params = new HashMap<>();
//		params.put("pageSize",pageSize);
//		params.put("numIs",getPara("numIs"));
//		params.put("pState",getPara("pState"));
//		params.put("itemBatch",getPara("itemBatch"));
//		params.put("provID",getPara("provID"));
//		params.put("wareHouse",getPara("wareHouse"));
//		params.put("luHao",getPara("luHao"));
//		p.setRecords(deviceStorageMapper.itemStorageSelect(params, p.getPageSize(), p.getPageNow()));
		List<ItemStorage> itemStorageList = deviceStorageMapper.itemStorageSelect(p.getPageSize(), p.getPageNow(), getPara("numIs"), getPara("itemid"), getPara("pState"), getPara("itemBatch"), getPara("provId"), getPara("wareHouse"), getPara("luHao"));
		p.setRecords(itemStorageList);
		Integer pCount = deviceStorageMapper.selectCount();
		p.setPageCount(pCount%p.getPageSize()==0 ? pCount/p.getPageSize() : pCount/p.getPageSize()+1);
		return pageView;
	}
}