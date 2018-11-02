package com.numberONe.controller.system;

import java.io.IOException;
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
import com.numberONe.entity.RepairPlanFormMap;
import com.numberONe.mapper.DevicemaintenanceMapper;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;
import com.numberONe.util.JsonUtils;
import com.numberONe.util.POIUtils;

@Controller
@RequestMapping("/devicemaintenance/")
public class DevicemaintenanceController extends BaseController{
	
	@Inject
	private DevicemaintenanceMapper devicemaintenanceMapper;
	
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/devicemaintenance/list";
	}
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		RepairPlanFormMap repairPlanFormMap = getFormMap(RepairPlanFormMap.class);
		repairPlanFormMap=toFormMap(repairPlanFormMap, pageNow, pageSize,repairPlanFormMap.getStr("orderby"));
		repairPlanFormMap.put("column", column);
		repairPlanFormMap.put("sort", sort);
        pageView.setRecords(devicemaintenanceMapper.findDevicemaintenancePage(repairPlanFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	
//	导出excel
	@RequestMapping("export")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "设备维护列表";
		RepairPlanFormMap repairPlanFormMap = findHasHMap(RepairPlanFormMap.class);
		String exportData = repairPlanFormMap.getStr("exportData");// 列表头的json字符串
		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
		List<RepairPlanFormMap> lis = devicemaintenanceMapper.findDevicemaintenancePage(repairPlanFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}
	
}
