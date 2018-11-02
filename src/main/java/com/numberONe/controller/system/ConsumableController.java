package com.numberONe.controller.system;
import java.io.IOException;
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
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.ConsumableFormMap;
import com.numberONe.entity.DeviceConsumDetailFormMap;
import com.numberONe.mapper.ConsumableMapper;
import com.numberONe.mapper.DeviceConsumDetailMapper;
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
@RequestMapping("/consumable/")
public class ConsumableController extends BaseController {
	@Inject
	private ConsumableMapper consumableMapper;
	@Inject
	private DeviceConsumDetailMapper deviceConsumDetailMapper;
	
	@RequestMapping("list")
	public String listUI(Model model){
		model.addAttribute("res",findByRes());
		return Common.BACKGROUND_PATH +"/system/consumable/list";
	}
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		ConsumableFormMap consumableFormMap = getFormMap(ConsumableFormMap.class);
		consumableFormMap=toFormMap(consumableFormMap, pageNow, pageSize,consumableFormMap.getStr("orderby"));
		consumableFormMap.put("column", column);
		consumableFormMap.put("sort", sort);
        pageView.setRecords(consumableMapper.findConsumablePage(consumableFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	
	@RequestMapping("/export")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "消耗品列表";
		ConsumableFormMap consumableFormMap = findHasHMap(ConsumableFormMap.class);
		
		String exportData = consumableFormMap.getStr("exportData");// 列表头的json字符串

		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);

		List<ConsumableFormMap> lis = consumableMapper.findConsumablePage(consumableFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}
	
	
//	点击新增按钮弹出页面
	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception{
		return Common.BACKGROUND_PATH + "/system/consumable/add";
	}
	
//	新增设备
	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="消耗品管理",methods="组管理-新增组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
		ConsumableFormMap consumableFormMap = getFormMap(ConsumableFormMap.class);
		consumableMapper.addEntity(consumableFormMap);
		return "success";
	}

	/**
	 * 验证消耗品名是否存在
	 * 
	 * @author numberONe  date：2014-2-19
	 * @param name
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(String name) {
		ConsumableFormMap account = consumableMapper.findbyFrist("cname", name, ConsumableFormMap.class);
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
			model.addAttribute("consumable", consumableMapper.findbyFrist("id", id, ConsumableFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/consumable/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="消耗品管理",methods="组管理-修改组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
		ConsumableFormMap consumableFormMap = getFormMap(ConsumableFormMap.class);
		consumableMapper.editEntity(consumableFormMap);
		return "success";
	}
	
//	删除设备
	@ResponseBody
	@RequestMapping("deleteId")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="消耗品管理",methods="组管理-删除组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			consumableMapper.delete("id", id, ConsumableFormMap.class);
		}
		return "success";
	}
	
		//消耗品使用记录列表
		@RequestMapping("ConsumUseList")
		public String ConsumUseListUI(Model model) throws Exception {
			model.addAttribute("res", findByRes());
			return Common.BACKGROUND_PATH + "/system/consumable/ConsumUseList";
		}
		
		//所有消耗品使用记录
		@ResponseBody
		@RequestMapping("findConsumUseByPage")
		public PageView findConsumUseByPage( String pageNow,
				String pageSize,String column,String sort) throws Exception {
			DeviceConsumDetailFormMap deviceConsumDetailFormMap = getFormMap(DeviceConsumDetailFormMap.class);
			deviceConsumDetailFormMap=toFormMap(deviceConsumDetailFormMap, pageNow, pageSize,deviceConsumDetailFormMap.getStr("orderby"));
			deviceConsumDetailFormMap.put("column", column);
			deviceConsumDetailFormMap.put("sort", sort);
	        pageView.setRecords(deviceConsumDetailMapper.findConsumDetailPage(deviceConsumDetailFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
	        return pageView;
		}
	
}
