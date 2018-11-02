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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.DeviceRepairFormMap;
import com.numberONe.entity.UserFormMap;
import com.numberONe.mapper.AuditMapper;
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
@RequestMapping("/audit/")
public class AuditController extends BaseController {
	
	@Inject
	private AuditMapper auditMapper;
	
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/audit/list";
	}
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		// 获取登录的bean
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);
		String reportman = (String) userFormMap.get("accountName");
		
		DeviceRepairFormMap devicerepairFormMap = getFormMap(DeviceRepairFormMap.class);
		devicerepairFormMap=toFormMap(devicerepairFormMap, pageNow, pageSize,devicerepairFormMap.getStr("orderby"));
		devicerepairFormMap.put("column", column);
		devicerepairFormMap.put("sort", sort);
		devicerepairFormMap.put("reportman", reportman);
		
        pageView.setRecords(auditMapper.findAuditPage(devicerepairFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	
//	导出excel
	@RequestMapping("export")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "工单审核记录";
		DeviceRepairFormMap devicerepairFormMap = findHasHMap(DeviceRepairFormMap.class);
		String exportData = devicerepairFormMap.getStr("exportData");// 列表头的json字符串

		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);

		List<DeviceRepairFormMap> lis = auditMapper.findAuditPage(devicerepairFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}
	
	//	审核通过
	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("audit", auditMapper.findbyFrist("id", id, DeviceRepairFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/audit/edit";
	}

	//审核通过
	@ResponseBody
	@RequestMapping("through")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="工单审核",methods="通过")//凡需要处理业务逻辑的.都需要记录操作日志
	public String through() throws Exception {
		DeviceRepairFormMap deviceRepairFormMap = getFormMap(DeviceRepairFormMap.class);
		String rp_number = (String) deviceRepairFormMap.get("rp_number");
		int confirm_status = auditMapper.confirm_status(rp_number);
		if(confirm_status == 0 || confirm_status == 2){
			return "Audited";
		}else if(confirm_status == 1){
			auditMapper.through(rp_number);
			return "success";
		}
		return "";
	}
	
//	审核退回
	@RequestMapping("backUI")
	public String backUI(Model model) throws Exception {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("audit", auditMapper.findbyFrist("id", id, DeviceRepairFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/audit/back";
	}

	//审核退回
	@ResponseBody
	@RequestMapping("back")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="工单审核",methods="退回")//凡需要处理业务逻辑的.都需要记录操作日志
	public String back() throws Exception {
		DeviceRepairFormMap deviceRepairFormMap = getFormMap(DeviceRepairFormMap.class);
		String rp_number = (String) deviceRepairFormMap.get("rp_number");
		int confirm_status = auditMapper.confirm_status(rp_number);
		if(confirm_status == 0 || confirm_status == 2){
			return "Audited";
		}else if(confirm_status == 1){
			auditMapper.back(rp_number);
			return "success";
		}
		return "";
	}
	
}
