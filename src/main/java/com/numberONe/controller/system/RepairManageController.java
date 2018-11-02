package com.numberONe.controller.system;

import java.util.Date;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberONe.mapper.RepairManageMapper;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.RepairPlanFormMap;
import com.numberONe.exception.SystemException;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;
import com.numberONe.util.DateUtil;


/**
 * 
 * @author numberONe 2014-11-19
 * @version 3.0v
 */
@Controller
@RequestMapping("/repairmanage/")
public class RepairManageController extends BaseController {
	@Inject
	private RepairManageMapper repairManageMapper;
	
	@RequestMapping("planlist")
	public String planlistUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/repairmanage/planlist";
	}
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		RepairPlanFormMap repairPlanFormMap = getFormMap(RepairPlanFormMap.class);
		repairPlanFormMap=toFormMap(repairPlanFormMap, pageNow, pageSize,repairPlanFormMap.getStr("orderby"));
		repairPlanFormMap.put("column", column);
		repairPlanFormMap.put("sort", sort);
        pageView.setRecords(repairManageMapper.findRepairPlanPage(repairPlanFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	//跳添加计划获取界面
	@RequestMapping("addPlanUI")
	public String addPlanUI() {
		return Common.BACKGROUND_PATH + "/system/repairmanage/addPlanUI";
	}
	
	@ResponseBody
	@RequestMapping("addPlanEntity")
	@SystemLog(module="维护管理",methods="设备维护计划-添加计划")//凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String addPlanEntity(){
		try {
			//获取用户输入的表单维护计划对象
			RepairPlanFormMap repairPlanFormMap = getFormMap(RepairPlanFormMap.class);
			String d1=repairPlanFormMap.getStr("plantime");
			int cycle=Integer.parseInt(repairPlanFormMap.getStr("repaircycle"))+1;
			Date d2=DateUtil.formatString(d1+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
			long diff=d2.getTime()-cycle*1000*60*60*24;
			Date d =new Date(diff);
			repairPlanFormMap.put("lasttime",DateUtil.formatDate(d,"yyyy-MM-dd HH:mm:ss"));
			repairManageMapper.addEntity(repairPlanFormMap);//新增后返回新增信息
		} catch (Exception e) {
			 throw new SystemException("添加计划异常");
		}
		return "success";
	}
	
	//跳修改计划获取界面
	@RequestMapping("editPlanUI")
	public String editUI(Model model) throws Exception {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("repairPlan", repairManageMapper.findbyFrist("id", id, RepairPlanFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/repairmanage/editPlanUI";
	}
	
	@ResponseBody
	@RequestMapping("editPlanEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="维护管理",methods="设备维护计划-修改计划")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editPlanEntity() throws Exception {
		RepairPlanFormMap repairPlanFormMap = getFormMap(RepairPlanFormMap.class);
		
		repairManageMapper.editEntity(repairPlanFormMap);
		return "success";
	}
	
	
	//跳执行计划获取界面
	@RequestMapping("excuPlanUI")
	public String excuUI(Model model) throws Exception {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("repairPlan", repairManageMapper.findbyFrist("id", id, RepairPlanFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/repairmanage/excuPlanUI";
	}
	
	//跳执行添加维护记录界面
	@RequestMapping("addRecordUI")
	public String addRecordUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/repairmanage/addRecordUI";
	}
	
	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="维护管理",methods="设备维护计划-删除计划")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			repairManageMapper.deleteByAttribute("id", id, RepairPlanFormMap.class);
		}
		return "success";
	}
	
    //跳转到选择设备信息界面
	@RequestMapping("selDeviceUI")
	public String selDeviceUI() {
		return Common.BACKGROUND_PATH + "/system/repairmanage/selDeviceUI";
	}
	
	//跳转到选择设备信息界面
	@RequestMapping("selrpmanUI")
	public String selrpmanUI() {
		return Common.BACKGROUND_PATH + "/system/repairmanage/selrpmanUI";
	}
	
	//跳转到增加配件界面
	@RequestMapping("addPartUI")
	public String addPartUI() {
		return Common.BACKGROUND_PATH + "/system/repairmanage/addPartUI";
	}
	
	//跳转到增加配件界面
	@RequestMapping("addConsumableUI")
	public String addConsumableUI() {
		return Common.BACKGROUND_PATH + "/system/repairmanage/addConsumableUI";
	}
	
}