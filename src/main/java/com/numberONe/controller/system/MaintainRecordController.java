package com.numberONe.controller.system;


import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberONe.mapper.ConsumableMapper;
import com.numberONe.mapper.DeviceConsumDetailMapper;
import com.numberONe.mapper.DevicePartMapper;
import com.numberONe.mapper.DevicePartReplaceMapper;
import com.numberONe.mapper.MaintainRecordMapper;
import com.numberONe.mapper.RepairManageMapper;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.DeviceConsumDetailFormMap;
import com.numberONe.entity.DeviceConsumDetailList;
import com.numberONe.entity.DeviceRepairDetailFormMap;
import com.numberONe.entity.DeviceRepairDetailList;
import com.numberONe.entity.MaintainRecordFormMap;
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
@RequestMapping("/maintain/")
public class MaintainRecordController extends BaseController {
	@Inject
	private MaintainRecordMapper  maintainRecordMapper;
	@Inject
	private DevicePartReplaceMapper devicePartReplaceMapper;
	@Inject
	private DeviceConsumDetailMapper deviceConsumDetailMapper;
	@Inject
	private DevicePartMapper  devicePartMapper;
	@Inject
	private ConsumableMapper  consumableMapper;
	@Inject
	private RepairManageMapper repairManageMapper;
	
	@RequestMapping("record")
	public String recordUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/repairmanage/mtRecordList";
	}
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		MaintainRecordFormMap maintainRecordFormMap = getFormMap(MaintainRecordFormMap.class);
		maintainRecordFormMap=toFormMap(maintainRecordFormMap, pageNow, pageSize,maintainRecordFormMap.getStr("orderby"));
		maintainRecordFormMap.put("column", column);
		maintainRecordFormMap.put("sort", sort);
        pageView.setRecords(maintainRecordMapper.findMaintainRecordPage(maintainRecordFormMap));
        return pageView;
	}
	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="维护管理",methods="维护记录-删除记录")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			
			maintainRecordMapper.deleteByAttribute("id", id, MaintainRecordFormMap.class);
		}
		return "success";
	}
	//执行维护
	@ResponseBody
	@RequestMapping(value="excuPlanEntity", method = RequestMethod.POST)
	public String addMaintainRecordEntity(DeviceRepairDetailList drdl,DeviceConsumDetailList dcdl){
		try {	
			//获取用户输入的表单维护计划对象
			MaintainRecordFormMap maintainRecordFormMap = getFormMap(MaintainRecordFormMap.class);
			RepairPlanFormMap repairPlanFormMap=getFormMap(RepairPlanFormMap.class);
			String starttime=maintainRecordFormMap.getStr("starttime");
			String endtime=maintainRecordFormMap.getStr("endtime");
			Date sttime=DateUtil.formatString(starttime,"yyyy-MM-dd HH:mm:ss");
			Date edtime=DateUtil.formatString(endtime,"yyyy-MM-dd HH:mm:ss");
			//总用时单位分钟
			int maintaintime=(int)(edtime.getTime()-sttime.getTime())/(60*1000);
			String maintainid= "WH-"+DateUtil.formatDate(new Date(), "yyyyMMddHHmmss");
			String repairman=maintainRecordFormMap.getStr("repairman");
			maintainRecordFormMap.put("maintainid", maintainid);
			maintainRecordFormMap.put("maintaintime",maintaintime);
			repairPlanFormMap.put("lasttime", starttime);
			repairManageMapper.editEntity(repairPlanFormMap);
			maintainRecordMapper.addEntity(maintainRecordFormMap);//新增后返回新增信息
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
					dc.put("rpnumber", maintainid);
					dc.put("op",repairman);
					dc.put("ctotal", Integer.parseInt(pricelist.get(i))*Integer.parseInt(cqtylist.get(i)));
					deviceConsumDetailMapper.addEntity(dc);
				}
			}
			if (drdl.getFnolist()!=null) {
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
					df.put("rpnumber", maintainid);
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
	
}