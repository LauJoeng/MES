package com.numberONe.controller.system;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.numberONe.mapper.ConsumableMapper;
import com.numberONe.mapper.DeviceConsumDetailMapper;
import com.numberONe.mapper.DevicePartMapper;
import com.numberONe.mapper.DevicePartReplaceMapper;
import com.numberONe.mapper.DevicerepairMapper;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.DeviceConsumDetailFormMap;
import com.numberONe.entity.DeviceConsumDetailList;
import com.numberONe.entity.DeviceRepairDetailFormMap;
import com.numberONe.entity.DeviceRepairDetailList;
import com.numberONe.entity.DeviceRepairFormMap;
import com.numberONe.entity.UserFormMap;
import com.numberONe.exception.SystemException;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;
import com.numberONe.util.DateUtil;
import com.numberONe.util.JsonUtils;
import com.numberONe.util.POIUtils;


/**
 * 
 * @author numberONe 2014-11-19
 * @version 3.0v
 */
@Controller
@RequestMapping("/devicerepair/")
public class DeviceRepairController extends BaseController {

	@Inject
	private DevicerepairMapper devicerepairMapper;
	@Inject
	private DevicePartReplaceMapper devicePartReplaceMapper;
	@Inject
	private DeviceConsumDetailMapper deviceConsumDetailMapper;
	@Inject
	private DevicePartMapper  devicePartMapper;
	@Inject
	private ConsumableMapper  consumableMapper;
	
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/devicerepair/list";
	}
	@RequestMapping("rprecord")
	public String rprecordUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/devicerepair/rpRecordList";
	}
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DeviceRepairFormMap devicerepairFormMap = getFormMap(DeviceRepairFormMap.class);
		devicerepairFormMap=toFormMap(devicerepairFormMap, pageNow, pageSize,devicerepairFormMap.getStr("orderby"));
		devicerepairFormMap.put("column", column);
		devicerepairFormMap.put("sort", sort);
        pageView.setRecords(devicerepairMapper.findDevicePage(devicerepairFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	//设备维修记录
	@ResponseBody
	@RequestMapping("findRpRecordByPage")
	public PageView findRpRecordByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DeviceRepairFormMap devicerepairFormMap = getFormMap(DeviceRepairFormMap.class);
		devicerepairFormMap=toFormMap(devicerepairFormMap, pageNow, pageSize,devicerepairFormMap.getStr("orderby"));
		devicerepairFormMap.put("column", column);
		devicerepairFormMap.put("sort", sort);
        pageView.setRecords(devicerepairMapper.findRpRecordPage(devicerepairFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	
	@RequestMapping("waitRepairList")
	public String listwaitRepairListUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/devicerepair/waitRepairList";
	}
	
	@ResponseBody
	@RequestMapping("findWaitRepairByPage")
	public PageView findWaitRepairByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DeviceRepairFormMap devicerepairFormMap = getFormMap(DeviceRepairFormMap.class);
		devicerepairFormMap=toFormMap(devicerepairFormMap, pageNow, pageSize,devicerepairFormMap.getStr("orderby"));
		devicerepairFormMap.put("column", column);
		devicerepairFormMap.put("sort", sort);
        pageView.setRecords(devicerepairMapper.findWaitRepairPage(devicerepairFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	//跳执行维修获取界面
	@RequestMapping("excuRepairUI")
	public String excuRepairUI(Model model) throws Exception {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			/*DeviceRepairFormMap drfm=devicerepairMapper.findbyFrist("id", id, DeviceRepairFormMap.class);
			String reporttime=drfm.getStr("reporttime");
			drfm.put("reporttime", reporttime.substring(0, 15));
			System.out.println(drfm);
			//根据ID获取报修详情数据
			model.addAttribute("reportInfo",drfm);*/
			//根据ID获取报修详情数据
			model.addAttribute("reportInfo", devicerepairMapper.findbyFrist("id", id, DeviceRepairFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/devicerepair/excuRepairUI";
	}
	//添加维修记录界面
	@RequestMapping("addRecordUI")
	public String addRecordUI(Model model) throws Exception {	
		return Common.BACKGROUND_PATH + "/system/devicerepair/addRecordUI";
	}
	
	//添加维修计划
	@ResponseBody
	@RequestMapping("addRepairEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="维护管理",methods="维修记录-添加记录")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addRepairEntity() throws Exception {
		DeviceRepairFormMap devicerepairFormMap = getFormMap(DeviceRepairFormMap.class);
		String begintime=devicerepairFormMap.getStr("begintime");
		String stoptime=devicerepairFormMap.getStr("stoptime");
		Date sttime=DateUtil.formatString(begintime,"yyyy-MM-dd HH:mm:ss");
		Date edtime=DateUtil.formatString(stoptime,"yyyy-MM-dd HH:mm:ss");
		devicerepairFormMap.put("confirm_status", 2);
		devicerepairFormMap.put("rp_number", devicerepairMapper.rp_number());
		//总用时单位分钟
		int repairtime=(int)(edtime.getTime()-sttime.getTime())/(60*1000);
		devicerepairFormMap.put("repairtime",repairtime);
		devicerepairMapper.addEntity(devicerepairFormMap);
		return "success";
	}
	
	
	@ResponseBody
	@RequestMapping(value="excuRepairEntity", method = RequestMethod.POST)
	public String addRepairRecordEntity(DeviceRepairDetailList drdl,DeviceConsumDetailList dcdl){
		try {	
			//获取用户输入的表单维修详情对象
			DeviceRepairFormMap devicerepairFormMap = getFormMap(DeviceRepairFormMap .class);
			String begintime=devicerepairFormMap.getStr("begintime");
			String stoptime=devicerepairFormMap.getStr("stoptime");
			String rpnumber=devicerepairFormMap.getStr("rp_number");
			Date sttime=DateUtil.formatString(begintime,"yyyy-MM-dd HH:mm:ss");
			Date edtime=DateUtil.formatString(stoptime,"yyyy-MM-dd HH:mm:ss");
			//总用时单位分钟
			int repairtime=(int)(edtime.getTime()-sttime.getTime())/(60*1000);
			String repairman=devicerepairFormMap.getStr("repairman");
			devicerepairFormMap.put("repairtime",repairtime);
			devicerepairFormMap.put("confirm_status",1);
			devicerepairMapper.editEntity(devicerepairFormMap);//新增后返回新增信息
			if (dcdl.getCnamelist()!=null) {
				//消耗品使用数据的采集和记录
				List<String> cnamelist=dcdl.getCnamelist();
				List<String> unitlist=dcdl.getUnitlist();
				List<String> pricelist=dcdl.getPricelist();
				List<String> cqtylist=dcdl.getCqtylist();
				for (int i = 0; i < cnamelist.size(); i++) {
					DeviceConsumDetailFormMap dc=new DeviceConsumDetailFormMap();
					dc.put("cid", consumableMapper.findIdByCname(cnamelist.get(i)));
					dc.put("unit",unitlist.get(i));
					dc.put("cname", cnamelist.get(i));
					dc.put("price", pricelist.get(i));
					dc.put("qty", cqtylist.get(i));
					dc.put("rpnumber", rpnumber);
					dc.put("op",repairman);
					dc.put("ctotal", Integer.parseInt(pricelist.get(i))*Integer.parseInt(cqtylist.get(i)));
					deviceConsumDetailMapper.addEntity(dc);
				}
			}
			if (drdl.getFnamelist()!=null) {
				//配件更换数据的采集和记录
				List<String> fnolist=drdl.getFnolist();
				List<String> fnamelist=drdl.getFnamelist();
				List<String> fpricelist=drdl.getFpricelist();
				List<String> fqtylist=drdl.getFqtylist();
				for (int i = 0; i < fnolist.size(); i++) {
					DeviceRepairDetailFormMap df=new DeviceRepairDetailFormMap();
					df.put("fid", devicePartMapper.findIdByfno(fnolist.get(i)));
					df.put("fno",fnolist.get(i));
					df.put("fname", fnamelist.get(i));
					df.put("fprice", fpricelist.get(i));
					df.put("qty", fqtylist.get(i));
					df.put("rpnumber", rpnumber);
					df.put("op",repairman);
					df.put("ftotal", Integer.parseInt(fpricelist.get(i))*Integer.parseInt(fqtylist.get(i)));
					devicePartReplaceMapper.addEntity(df);
				}		
			}	
		} catch (Exception e) {
			 throw new SystemException("添加计划异常");
		}
		return "success";
	}
//	导出excel
	@RequestMapping("export")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "设备报修记录";
		DeviceRepairFormMap devicerepairFormMap = findHasHMap(DeviceRepairFormMap.class);
		String exportData = devicerepairFormMap.getStr("exportData");// 列表头的json字符串

		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);

		List<DeviceRepairFormMap> lis = devicerepairMapper.findDevicePage(devicerepairFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}
	
//	导出设备维修记录excel
	@RequestMapping("exportR")
	public void download2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "设备维修记录";
		DeviceRepairFormMap devicerepairFormMap = findHasHMap(DeviceRepairFormMap.class);
		String exportData = devicerepairFormMap.getStr("exportData");// 列表头的json字符串

		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);

		List<DeviceRepairFormMap> lis = devicerepairMapper.findRpRecordPage(devicerepairFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}
	
//	点击新增按钮弹出页面
	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception{
		return Common.BACKGROUND_PATH + "/system/devicerepair/add";
	}
	
//	新增设备报修
	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="报修管理",methods="组管理-新增组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
		DeviceRepairFormMap devicerepairFormMap = getFormMap(DeviceRepairFormMap.class);
		String dnumber = (String) devicerepairFormMap.get("dnumber");
		//设备编号
		DeviceRepairFormMap number = devicerepairMapper.selectDnumber(dnumber);
		if(number == null){
			 devicerepairMapper.addEntity(devicerepairFormMap);
			 return "success";
		}else{
			return "existing";
		}
	}
	
	@ResponseBody
	@RequestMapping("deleteRpEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="维护管理",methods="维修记录-删除记录")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteRpEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			devicerepairMapper.deleteByAttribute("id", id, DeviceRepairFormMap.class);
		}
		return "success";
	}
	/**
	 * 验证维修单号是否存在
	 * 
	 * @author numberONe  date：2014-2-19
	 * @param name
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(String name) {
		DeviceRepairFormMap account = devicerepairMapper.findbyFrist("rp_number", name, DeviceRepairFormMap.class);
		if(account == null){
			return true;
		} else {
			return false;
		}
	}
	
//	删除设备
	@ResponseBody
	@RequestMapping("deleteId")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="报修管理",methods="组管理-删除组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			devicerepairMapper.delete("id", id, DeviceRepairFormMap.class);
		}
		return "success";
	}
	
	//维修单号和用户登录信息
	@ResponseBody
	@RequestMapping("selectRpnumber")
	public Map<String,Object> selectRpnumber(){
		Map<String,Object> sMap = new HashMap<String, Object>(); 
		String rp_number = devicerepairMapper.rp_number();
		System.out.println("*************"+rp_number);
		// 获取登录的bean
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);
		sMap.put("userFormMap",userFormMap);
		sMap.put("rp_number",rp_number);
		return sMap;
	}
	
	 //跳转到选择设备信息界面
		@RequestMapping("selDeviceUI")
		public String selDeviceUI() {
			return Common.BACKGROUND_PATH + "/system/devicerepair/selDeviceUI";
		}
	
}