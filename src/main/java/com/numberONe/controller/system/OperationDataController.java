package com.numberONe.controller.system;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.controller.index.UtilityController;
import com.numberONe.entity.DevicePartFormMap;
import com.numberONe.entity.DeviceRepairDetailFormMap;
import com.numberONe.entity.DeviceRepairFormMap;
import com.numberONe.entity.OpModuleOperation;
import com.numberONe.entity.OperationDataFormMap;
import com.numberONe.entity.ShipmentStatistics;
import com.numberONe.entity.UserFormMap;
import com.numberONe.entity.processData.ComponentDetails;
import com.numberONe.mapper.DeviceMapper;
import com.numberONe.mapper.DevicePartMapper;
import com.numberONe.mapper.DevicePartReplaceMapper;
import com.numberONe.mapper.OperationDataMapper;
import com.numberONe.mapper.mapper2.ShipmentDataMapper;
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
@RequestMapping("/operationData/")
public class OperationDataController extends UtilityController{
	@Inject
	//引用接口方法
	private OperationDataMapper operationDataMapper;
	@Inject
	private ShipmentDataMapper shipmentDataMapper;
	/**显示员工数据操作管理页面
	 * 数据操作管理
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("operationDataQuery")
	public String operationDataQueryPage(Model model) throws Exception {
		/*model.addAttribute("res", findByRes());*/
		return Common.BACKGROUND_PATH + "/system/operationdate/operationDataQuery";
	}
	@RequestMapping("opModuleOperationQuery")
	public String opModuleOperationQueryPage(Model model) throws Exception {
		/*model.addAttribute("res", findByRes());*/
		return Common.BACKGROUND_PATH + "/system/operationdate/opModuleOperationQuery";
	}
	
	/**
	 * 查询Base_Process表中status=0的工序
	 * @return
	 * @throws Exception
	 */
		@ResponseBody
		@RequestMapping("selectName")
		public List<String> selectProcessName() throws Exception {	
			return operationDataMapper.selectProcessName();
			
		}
		
		
	/**
	 * 查询员工数据操作
	 * @param pageNow
	 * @param pageSize
	 * @param column
	 * @param sort
	 * @param begintime
	 * @param endtime
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("selectData")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort,String begintime,String endtime) throws Exception {
		OperationDataFormMap operationDataFormMap = getFormMap(OperationDataFormMap.class);
/*		System.out.println(operationDataFormMap);
*/		operationDataFormMap=toFormMap(operationDataFormMap, pageNow, pageSize,operationDataFormMap.getStr("orderby"));
        pageView.setRecords(operationDataMapper.selectDataPage(operationDataFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	
	@RequestMapping("selectDataExport")
	public void selectDataExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "查询员工数据操作";
		OperationDataFormMap operationDataFormMap = findHasHMap(OperationDataFormMap.class);
		String exportData = operationDataFormMap.getStr("exportData");// 列表头的json字符串

		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);

		List<OperationDataFormMap> lis = operationDataMapper.selectDataPage(operationDataFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}
	
	@ResponseBody
	@RequestMapping("selectOpModuleData")
	public PageView selectOpModuleData( String pageNow,
			String pageSize,String sort,String begintime,String endtime,String module_code,String order_no,String op) throws Exception {
		Map<String ,Object>map=new HashMap<String ,Object>();
		map.put("paging", getPageView(pageNow, pageSize,sort));
		map.put("begintime", begintime);
		map.put("endtime", endtime);
		map.put("module_code", module_code);
		map.put("order_no", order_no);
		map.put("op", op);
		 pageView.setRecords(operationDataMapper.selectOpModuleData(map));//不调用默认分页,调用自已的mapper中findDevicePage
	     return pageView;
	}
	
	@RequestMapping("selectOpModuleDataExport")
	public void selectOpModuleDataExport(HttpServletRequest request, HttpServletResponse response,String begintime,String endtime,String module_code,String order_no,String op) throws IOException {
		Map<String ,Object>selectmap=new HashMap<String ,Object>();
		/*map.put("paging", getPageView(pageNow, pageSize,sort));*/
		selectmap.put("begintime", begintime);
		selectmap.put("endtime", endtime);
		selectmap.put("module_code", module_code);
		selectmap.put("order_no", order_no);
		selectmap.put("op", op);
		String fileName = "员工工序操作列表";
		String exportData =request.getParameterValues("exportData")[0];
		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
		List<OpModuleOperation> lis = operationDataMapper.selectOpModuleData(selectmap);
		List<Map<String, Object>> select=new ArrayList<Map<String, Object>>();
		for(int j=0;j<lis.size();j++){
			select.add(ProcessManagementController.ConvertObjToMap(lis.get(j)));
		 }
		POIUtils.exportToExcel(response, listMap, select, fileName);
	}
	
	//2018-05-24
	@RequestMapping("shipmentStatisticsModule")
	public String shipmentStatisticsPage(Model model) throws Exception {
		/*model.addAttribute("res", findByRes());*/
		return Common.BACKGROUND_PATH + "/system/operationdate/shipmentStatisticsModule";
	}
	
	
	@ResponseBody
	@RequestMapping("selectShipmentModule")
	public PageView selectShipmentModule( String pageNow,
			String pageSize,String column,String sort,String begintime,String endtime) throws Exception {
		Map<String ,Object>map=new HashMap<String ,Object>();
		map.put("begintime", begintime);
		map.put("endtime", endtime);
		pageView=burstView(pageNow,pageSize,shipmentDataMapper.selectShipmentModule(map));
	     return pageView;
	}
	@RequestMapping("selectShipmentModuleExport")
	public void sselectShipmentModuleExport(HttpServletRequest request, HttpServletResponse response,String begintime,String endtime) throws IOException {
		Map<String ,Object>selectmap=new HashMap<String ,Object>();
		/*map.put("paging", getPageView(pageNow, pageSize,sort));*/
		selectmap.put("begintime", begintime);
		selectmap.put("endtime", endtime);
		String fileName = "组件出货订单列表";
		String exportData =request.getParameterValues("exportData")[0];
		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
		List<ShipmentStatistics> lis = shipmentDataMapper.selectShipmentModule(selectmap);
		List<Map<String, Object>> select=new ArrayList<Map<String, Object>>();
		for(int j=0;j<lis.size();j++){
			select.add(ConvertObjToMap(lis.get(j)));
		 }
		POIUtils.exportToExcel(response, listMap, select, fileName);
	}
	

	@RequestMapping("shipmentStatisticsBattery")
	public String shipmentStatisticsBatteryPage(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/operationdate/shipmentStatisticsBattery";
	}

	@ResponseBody
	@RequestMapping("selectShipmentBattery")
	public PageView selectShipmentBattery( String pageNow,
			String pageSize,String column,String sort,String begintime,String endtime) throws Exception {
		
		
		Map<String ,Object>map=new HashMap<String ,Object>();
		map.put("begintime", begintime);
		map.put("endtime", endtime);
		pageView=burstView(pageNow,pageSize,shipmentDataMapper.selectShipmentBattery(map));
		return pageView;
	}
	@RequestMapping("selectShipmentBatteryExport")
	public void sselectShipmentBatteryExport(HttpServletRequest request, HttpServletResponse response,String begintime,String endtime) throws IOException {
		Map<String ,Object>selectmap=new HashMap<String ,Object>();
		selectmap.put("begintime", begintime);
		selectmap.put("endtime", endtime);
		String fileName = "电池出货订单列表";
		String exportData =request.getParameterValues("exportData")[0];
		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
		List<ShipmentStatistics> lis = shipmentDataMapper.selectShipmentBattery(selectmap);
		List<Map<String, Object>> select=new ArrayList<Map<String, Object>>();
		for(int j=0;j<lis.size();j++){
			select.add(ConvertObjToMap(lis.get(j)));
		 }
		POIUtils.exportToExcel(response, listMap, select, fileName);
	}
	/**
	 * 单组件毛利润查询
	 * @param model
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("moduleGrossMargin")
	public String moduleGrossMarginPage(Model model) throws Exception {
		/*model.addAttribute("res", findByRes());*/
		return Common.BACKGROUND_PATH + "/system/operationdate/moduleGrossMargin";
	}
	@ResponseBody
	@RequestMapping("selectModuleGrossMargin")
	public List<Map> selectModuleGrossMargin(String order_no) throws Exception {
		Map<String,String> map=new HashMap<String,String>();
		map.put("name", "PS100WPS-95");
		map.put("unitPrice", "3.991");
		map.put("cost_silicon", "1.41");
		map.put("no_cost_silicon", "1.969");
		map.put("water_electricity", "0");
		map.put("cost_labor", "0.316");
		map.put("commission", "0.09654");
		map.put("premium", "0.03218");
		
		map.put("royalty_rate", "0.004");
		
		map.put("amount", "174");
		
		map.put("wattage", "95");
		
		
		List<Map>list=new ArrayList<Map>();
		list.add(map);
		list.add(map);
		 return list;
	}
	
}