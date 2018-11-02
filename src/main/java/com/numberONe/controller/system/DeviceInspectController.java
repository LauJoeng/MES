package com.numberONe.controller.system;

import javax.inject.Inject;

import com.numberONe.entity.*;
import com.numberONe.mapper.DeviceWaitInspectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberONe.mapper.DeviceInspectMapper;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.exception.SystemException;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


/**
 * 
 * @author numberONe 2014-11-19
 * @version 3.0v
 */
@Controller
@RequestMapping("/inspect/")
public class DeviceInspectController extends BaseController {
	@Inject
	private DeviceInspectMapper  deviceInspectMapper;

	@Inject
	private DeviceWaitInspectMapper deviceWaitInspectMapper;

	
	@RequestMapping("inspectInfoList")
	public String recordUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/deviceinspect/inspectInfoList";
	}

	@RequestMapping("execInspect")
	public String execInspectUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/deviceinspect/execInspect";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DeviceInspectInfoFormMap deviceInspectInfoFormMap = getFormMap(DeviceInspectInfoFormMap.class);
		deviceInspectInfoFormMap=toFormMap(deviceInspectInfoFormMap, pageNow, pageSize,deviceInspectInfoFormMap.getStr("orderby"));
		deviceInspectInfoFormMap.put("column", column);
		deviceInspectInfoFormMap.put("sort", sort);
        pageView.setRecords(deviceInspectMapper.findDeviceInspectInfoPage(deviceInspectInfoFormMap));
        return pageView;
	}
	//添加点检项目界面
	@RequestMapping("addInspectInfoUI")
	public String addInspectInfoUI(Model model) throws Exception {	
		return Common.BACKGROUND_PATH + "/system/deviceinspect/addInspectInfoUI";
	}
	//添加点检计划界面
	@RequestMapping("addInspectPlanUI")
	public String addInspectPlanUI(Model model) throws Exception {	
		return Common.BACKGROUND_PATH + "/system/deviceinspect/addInspectPlanUI";
	}	

   //跳转到选择设备信息界面
	@RequestMapping("selDeviceUI")
	public String selDeviceUI() {
		return Common.BACKGROUND_PATH + "/system/deviceinspect/selDeviceUI";
	}
	@ResponseBody
	@RequestMapping("addInspectInfoEntity")
	@SystemLog(module="巡检管理",methods="点检项目-添加项目")//凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String addPlanEntity(){
		try {
			//获取用户输入的表单维护计划对象
			DeviceInspectInfoFormMap deviceInspectInfoFormMap = getFormMap(DeviceInspectInfoFormMap.class);
			String lastCode=deviceInspectMapper.findLastCode();
			int code=Integer.parseInt(lastCode.substring(1))+1;
			String inspectcode="E"+code;
			deviceInspectInfoFormMap.put("inspectcode", inspectcode);
			deviceInspectMapper.addEntity(deviceInspectInfoFormMap);//新增后返回新增信息
		} catch (Exception e) {
			 throw new SystemException("添加计划异常");
		}
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("deleteInspectInfoEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="巡检管理",methods="点检项目-删除项目")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			
		deviceInspectMapper.deleteByAttribute("id", id, DeviceInspectInfoFormMap.class);
		}
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("addInspectPlanEntity")
	@SystemLog(module="巡检管理",methods="设备点检计划-添加计划")//凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String addInspectPalnEntity(){
		try {
			//获取用户输入的表单维护计划对象
			DeviceInspectPlanFormMap deviceInspectPlanFormMap = getFormMap(DeviceInspectPlanFormMap.class);
			deviceInspectMapper.addEntity(deviceInspectPlanFormMap);//新增后返回新增信
		} catch (Exception e) {
			 throw new SystemException("添加计划异常");
		}
		return "success";
	}
	//跳修改计划获取界面
	@RequestMapping("editInspectPlanUI")
	public String editInspectPlanUI(Model model) throws Exception {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("inspectPlan",deviceInspectMapper.findbyFrist("id", id, DeviceInspectPlanFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/deviceinspect/editInspectPlanUI";
	}
	@ResponseBody
	@RequestMapping("editInspectPlanEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="巡检管理",methods="设备点检计划-修改计划")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editInspectPlanEntity() throws Exception {
		DeviceInspectPlanFormMap deviceInspectPlanFormMap = getFormMap(DeviceInspectPlanFormMap.class);
		deviceInspectMapper.editEntity(deviceInspectPlanFormMap);
		return "success";
	}
	@ResponseBody
	@RequestMapping("deleteInspectPlanEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="巡检管理",methods="设备点检计划-删除计划")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteInspectPlanEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			
		deviceInspectMapper.deleteByAttribute("id", id, DeviceInspectPlanFormMap.class);
		}
		return "success";
	}

	
	@RequestMapping("inspectPlan")
	public String inspectPlanUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/deviceinspect/inspectPlan";
	}
	@ResponseBody
	@RequestMapping("findInspectPlanByPage")
	public PageView findInspectPlanByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DeviceInspectPlanFormMap deviceInspectPlanFormMap = getFormMap(DeviceInspectPlanFormMap.class);
		deviceInspectPlanFormMap=toFormMap(deviceInspectPlanFormMap, pageNow, pageSize,deviceInspectPlanFormMap.getStr("orderby"));
		deviceInspectPlanFormMap.put("column", column);
		deviceInspectPlanFormMap.put("sort", sort);
        pageView.setRecords(deviceInspectMapper.findDeviceInspectPlanPage(deviceInspectPlanFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}

	@ResponseBody
	@RequestMapping("findWaitInspectByPage")
	public PageView findWaitInspectByPage(String page,String pageSize,String column,String sort){
		DeviceWaitInspectFormMap deviceWaitInspectFormMap = getFormMap(DeviceWaitInspectFormMap.class);
		deviceWaitInspectFormMap = toFormMap(deviceWaitInspectFormMap,page,pageSize,deviceWaitInspectFormMap.getStr("orderby"));
		deviceWaitInspectFormMap.put("column",column);
		deviceWaitInspectFormMap.put("sort",sort);
		pageView.setRecords(deviceWaitInspectMapper.findDeviceWaitInspectPage(deviceWaitInspectFormMap));
		return pageView;
	}

	@ResponseBody
	@RequestMapping("executeWaitInspect")
	public boolean executeWaitInspect(){
		String[] ids = getParaValues("ids");
		try {
			for (String id:ids){
				DeviceWaitInspectFormMap deviceWaitInspectFormMap = getFormMap(DeviceWaitInspectFormMap.class);
				deviceWaitInspectFormMap.put("id",id);
				deviceWaitInspectFormMap.put("state",0);
					deviceWaitInspectMapper.updateRecord(deviceWaitInspectFormMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//更新待点检信息
	@ResponseBody
	@RequestMapping("updateWaitInspect")
	public boolean updateWaitInspect(){
		DeviceInspectPlanFormMap deviceInspectPlanFormMap = getFormMap(DeviceInspectPlanFormMap.class);
		List<DeviceInspectPlanFormMap> deviceInspectPlans = deviceInspectMapper.findDeviceInspectPlanPage(deviceInspectPlanFormMap);
		try {
			for (DeviceInspectPlanFormMap deviceInspectPlan : deviceInspectPlans) {
				int planId = deviceInspectPlan.getInt("id");//点检计划id
				int inspectCycle = deviceInspectPlan.getInt("inspectcycle");//点检周期时间长(天)
				BigInteger planTime = BigInteger.valueOf(deviceInspectPlan.getDate("plantime").getTime());//计划开始时间
				BigInteger currentTime = BigInteger.valueOf(System.currentTimeMillis());
				BigInteger[] arr =  currentTime.subtract(planTime).divideAndRemainder(BigInteger.valueOf(86400000).multiply(BigInteger.valueOf(inspectCycle)));
				//本周期已过去的时间=(currentTime - planTime)%cycleMillis
				System.out.println(arr[0]+"---"+arr[1]+"---"+currentTime+"---"+planTime+"---"+BigInteger.valueOf(86400000).multiply(BigInteger.valueOf(inspectCycle)));
				if (arr[1].compareTo(BigInteger.valueOf(86400000).multiply(BigInteger.valueOf(inspectCycle-1)))>0) {//如果这个周期剩余时间少于一天则查找下个周期的记录是否已经存在表中
					List<DeviceWaitInspectFormMap> list = deviceWaitInspectMapper.selectByPlanIdAndCycle(planId, arr[0].intValue()+1);
					if (list.size() <= 0) {//如果不存在则将记录插入表
						DeviceWaitInspectFormMap deviceWaitInspect = new DeviceWaitInspectFormMap();
						deviceWaitInspect.put("inspectman",deviceInspectPlan.getStr("inspectman"));
						deviceWaitInspect.put("dnumber",deviceInspectPlan.getStr("dnumber"));
						deviceWaitInspect.put("dname",deviceInspectPlan.getStr("dname"));
						deviceWaitInspect.put("name",deviceInspectPlan.getStr("name"));
						deviceWaitInspect.put("cycle",arr[0].intValue()+1);
						deviceWaitInspect.put("planid",deviceInspectPlan.getInt("id"));
						deviceWaitInspect.put("state",0);
						deviceWaitInspectMapper.insertOneRecord(deviceWaitInspect);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}