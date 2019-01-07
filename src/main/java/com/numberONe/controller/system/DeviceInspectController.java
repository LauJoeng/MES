package com.numberONe.controller.system;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.numberONe.entity.*;
import com.numberONe.mapper.*;
import com.numberONe.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.exception.SystemException;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


/**
 * @author numberONe 2014-11-19
 * @version 3.0v
 */
@Controller
@RequestMapping("/inspect/")
public class DeviceInspectController extends BaseController {
    @Inject
    private DeviceInspectMapper deviceInspectMapper;

    @Inject
    private DeviceWaitInspectMapper deviceWaitInspectMapper;

    @Inject
    private DeviceMapper deviceMapper;

    @Inject
    private ConsumableMapper consumableMapper;

    @Inject
    private DevicePartMapper devicePartMapper;

    @Inject
    private DeviceConsumDetailMapper deviceConsumDetailMapper;

    @Inject
    private DevicePartReplaceMapper devicePartReplaceMapper;

    @Inject
    private DeviceInspectRecordMapper deviceInspectRecordMapper;

    @RequestMapping("inspectInfoList")
    public String recordUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/deviceinspect/inspectInfoList";
    }

    @ResponseBody
    @RequestMapping("findByPage")
    public PageView findByPage(String pageNow,
                               String pageSize, String column, String sort) throws Exception {
        DeviceInspectInfoFormMap deviceInspectInfoFormMap = getFormMap(DeviceInspectInfoFormMap.class);
        deviceInspectInfoFormMap = toFormMap(deviceInspectInfoFormMap, pageNow, pageSize, deviceInspectInfoFormMap.getStr("orderby"));
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
    @SystemLog(module = "巡检管理", methods = "点检项目-添加项目")//凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addPlanEntity() {
        try {
            //获取用户输入的表单维护计划对象
            DeviceInspectInfoFormMap deviceInspectInfoFormMap = getFormMap(DeviceInspectInfoFormMap.class);
            String lastCode = deviceInspectMapper.findLastCode();
            int code = Integer.parseInt(lastCode.substring(1)) + 1;
            String inspectcode = "E" + code;
            deviceInspectInfoFormMap.put("inspectcode", inspectcode);
            deviceInspectMapper.addEntity(deviceInspectInfoFormMap);//新增后返回新增信息
        } catch (Exception e) {
            throw new SystemException("添加计划异常");
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("deleteInspectInfoEntity")
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    @SystemLog(module = "巡检管理", methods = "点检项目-删除项目")//凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteEntity() throws Exception {
        String[] ids = getParaValues("ids");
        for (String id : ids) {

            deviceInspectMapper.deleteByAttribute("id", id, DeviceInspectInfoFormMap.class);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("addInspectPlanEntity")
    @SystemLog(module = "巡检管理", methods = "设备点检计划-添加计划")//凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addInspectPalnEntity(HttpSession session) {
        try {
            //获取用户输入的表单维护计划对象
            DeviceInspectPlanFormMap deviceInspectPlanFormMap = getFormMap(DeviceInspectPlanFormMap.class);
            deviceInspectMapper.addEntity(deviceInspectPlanFormMap);//新增后返回新增信
            session.setAttribute("isLoad", false);
        } catch (Exception e) {
            throw new SystemException("添加计划异常");
        }
        return "success";
    }

    //跳修改计划获取界面
    @RequestMapping("editInspectPlanUI")
    public String editInspectPlanUI(Model model) throws Exception {
        String id = getPara("id");
        if (Common.isNotEmpty(id)) {
            model.addAttribute("inspectPlan", deviceInspectMapper.findbyFrist("id", id, DeviceInspectPlanFormMap.class));
        }
        return Common.BACKGROUND_PATH + "/system/deviceinspect/editInspectPlanUI";
    }

    @ResponseBody
    @RequestMapping("editInspectPlanEntity")
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    @SystemLog(module = "巡检管理", methods = "设备点检计划-修改计划")//凡需要处理业务逻辑的.都需要记录操作日志
    public String editInspectPlanEntity() throws Exception {
        DeviceInspectPlanFormMap deviceInspectPlanFormMap = getFormMap(DeviceInspectPlanFormMap.class);
        deviceInspectMapper.editEntity(deviceInspectPlanFormMap);
        return "success";
    }

    @ResponseBody
    @RequestMapping("deleteInspectPlanEntity")
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    @SystemLog(module = "巡检管理", methods = "设备点检计划-删除计划")//凡需要处理业务逻辑的.都需要记录操作日志
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
    public PageView findInspectPlanByPage(String pageNow,
                                          String pageSize, String column, String sort) throws Exception {
        DeviceInspectPlanFormMap deviceInspectPlanFormMap = getFormMap(DeviceInspectPlanFormMap.class);
        deviceInspectPlanFormMap = toFormMap(deviceInspectPlanFormMap, pageNow, pageSize, deviceInspectPlanFormMap.getStr("orderby"));
        deviceInspectPlanFormMap.put("column", column);
        deviceInspectPlanFormMap.put("sort", sort);
        pageView.setRecords(deviceInspectMapper.findDeviceInspectPlanPage(deviceInspectPlanFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
    }


    //返回待执行的点检项目
    @ResponseBody
    @RequestMapping("findWaitInspectByPage")
    public PageView findWaitInspectByPage(String pageNow, String pageSize, String column, String sort) {
        DeviceWaitInspectFormMap deviceWaitInspectFormMap = getFormMap(DeviceWaitInspectFormMap.class);
        deviceWaitInspectFormMap = toFormMap(deviceWaitInspectFormMap, pageNow, pageSize, deviceWaitInspectFormMap.getStr("orderby"));
        deviceWaitInspectFormMap.put("column", column);
        deviceWaitInspectFormMap.put("sort", sort);
        pageView.setRecords(deviceWaitInspectMapper.findDeviceWaitInspectPage(deviceWaitInspectFormMap));
        return pageView;
    }

    //    执行点检项目
    @ResponseBody
    @RequestMapping(value = "executeWaitInspect", method = RequestMethod.POST)
    public String executeWaitInspect(DeviceRepairDetailList drdl, DeviceConsumDetailList dcdl) {
        try {
            DeviceWaitInspectFormMap deviceWaitInspectFormMap = getFormMap(DeviceWaitInspectFormMap.class);
            System.out.println(Arrays.toString(deviceWaitInspectFormMap.getAttrValues()) + "  " + Arrays.toString(deviceWaitInspectFormMap.getAttrNames()));
            DeviceInspectPlanFormMap deviceInspectPlanFormMap = deviceInspectMapper.findbyFrist("id", deviceWaitInspectFormMap.getStr("planid"), DeviceInspectPlanFormMap.class);
            deviceInspectPlanFormMap.set("lasttime", new Date());
            deviceInspectMapper.updateEntity(deviceInspectPlanFormMap);
            String inspectman = deviceWaitInspectFormMap.getStr("inspectman");
            String date = DateUtil.formatDate(new Date(), "yyyyMMddHHmmss");
            String maintainid = "DJ-" + date;
            deviceWaitInspectFormMap.put("inspectid", maintainid);
            deviceWaitInspectFormMap.put("executed", 1);//更新待点检表
            deviceWaitInspectMapper.updateRecord(deviceWaitInspectFormMap);
//			List<DeviceWaitInspect>waitInspects = deviceWaitInspectMapper.findByAttribute("id",deviceInspectRecordFormMap.getInt("waitInspectPlanId").toString(),DeviceWaitInspect.class);
            if (dcdl.getCnamelist() != null) {
                //消耗品使用数据的采集和记录
                List<String> cnamelist = dcdl.getCnamelist();
                List<String> unitlist = dcdl.getUnitlist();
                List<String> pricelist = dcdl.getPricelist();
                List<String> cqtylist = dcdl.getCqtylist();
                for (int i = 0; i < cnamelist.size(); i++) {
                    DeviceConsumDetailFormMap dc = new DeviceConsumDetailFormMap();
                    dc.put("cid", consumableMapper.findIdByCname(cnamelist.get(i)));
                    dc.put("unit", unitlist.get(i));
                    dc.put("cname", cnamelist.get(i));
                    dc.put("price", pricelist.get(i));
                    dc.put("qty", cqtylist.get(i));
                    dc.put("rpnumber", maintainid);
                    dc.put("op", inspectman);
                    dc.put("ctotal", Integer.parseInt(pricelist.get(i)) * Integer.parseInt(cqtylist.get(i)));
                    deviceConsumDetailMapper.addEntity(dc);
                }
            }
            if (drdl.getFnolist() != null) {
                //配件更换数据的采集和记录
                List<String> fnolist = drdl.getFnolist();
                List<String> fnamelist = drdl.getFnamelist();
                List<String> fpricelist = drdl.getFpricelist();
                List<String> fqtylist = drdl.getFqtylist();
                for (int i = 0; i < fnolist.size(); i++) {
                    DeviceRepairDetailFormMap df = new DeviceRepairDetailFormMap();
                    df.put("fid", devicePartMapper.findIdByfno(fnolist.get(i)));
                    df.put("fno", fnolist.get(i));
                    df.put("fname", fnamelist.get(i));
                    df.put("fprice", fpricelist.get(i));
                    df.put("qty", fqtylist.get(i));
                    df.put("rpnumber", maintainid);
                    df.put("op", inspectman);
                    df.put("ftotal", Integer.parseInt(fpricelist.get(i)) * Integer.parseInt(fqtylist.get(i)));
                    devicePartReplaceMapper.addEntity(df);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException("添加计划异常");
        }
        return "success";
    }


    @ResponseBody
    @RequestMapping("updateWaitInspect")
    public boolean updateWaitInspect() {
        DeviceInspectPlanFormMap deviceInspectPlanFormMap = getFormMap(DeviceInspectPlanFormMap.class);
        List<DeviceInspectPlanFormMap> deviceInspectPlans = deviceInspectMapper.findDeviceInspectPlanPage(deviceInspectPlanFormMap);
        try {
            for (DeviceInspectPlanFormMap deviceInspectPlan : deviceInspectPlans) {
                int planId = deviceInspectPlan.getInt("id");//点检计划id
                int inspectCycle = deviceInspectPlan.getInt("inspectcycle");//点检周期时间长(天)
                BigInteger planTime = BigInteger.valueOf(deviceInspectPlan.getDate("plantime").getTime());//计划开始时间
                BigInteger currentTime = BigInteger.valueOf(System.currentTimeMillis());
                BigInteger[] arr = currentTime.subtract(planTime).divideAndRemainder(BigInteger.valueOf(86400000).multiply(BigInteger.valueOf(inspectCycle)));//数组第一个值是商，第二个是余数
                //本周期已过去的时间=(currentTime - planTime)%cycleMillis
                System.out.println(arr[0] + "---" + arr[1] + "---" + currentTime + "---" + planTime + "---" + BigInteger.valueOf(86400000).multiply(BigInteger.valueOf(inspectCycle)) + "----" + BigInteger.valueOf(86400000).multiply(BigInteger.valueOf(inspectCycle - 1)));
                String[] dnums = deviceInspectPlan.getStr("dnumber").split(",");//一个计划里有多个设备码，分开为多个记录
                for (int i = arr[0].intValue(); i >= (arr[0].intValue() > 20 ? arr[0].intValue() - 20 : 1); i--) {//查看近20个周期的数据
                    List<DeviceWaitInspectFormMap> list = deviceWaitInspectMapper.selectByPlanIdAndCycle(planId, i);
                    if (list.size() <= 0) {//如果不存在则将记录插入表中
                        for (String dnum : dnums) {
                            DeviceInspectInfoFormMap info = deviceInspectMapper.findDeviceInspectInfoByDeviceNumber("%" + dnum + "%");
                            DeviceFormMap deviceFormMap = deviceMapper.findbyFrist("number", dnum, DeviceFormMap.class);
                            DeviceWaitInspectFormMap deviceWaitInspect = new DeviceWaitInspectFormMap();
                            deviceWaitInspect.put("inspectinfo", info == null ? " " : info.getStr("inspectinfo"));//点检信息可能为空，下同
                            deviceWaitInspect.put("inspectrule", info == null ? " " : info.getStr("inspectrule"));
                            System.out.println(Arrays.toString(deviceFormMap.getAttrNames()));
                            deviceWaitInspect.put("dtype", deviceFormMap.getStr("typeid"));
                            deviceWaitInspect.put("standard", deviceFormMap.getStr("standard"));
                            deviceWaitInspect.put("userdept", deviceFormMap.getStr("userdept"));
                            deviceWaitInspect.put("inspectman", deviceInspectPlan.getStr("inspectman"));
                            deviceWaitInspect.put("dnumber", dnum);
                            deviceWaitInspect.put("dname", deviceFormMap.getStr("dname"));
                            deviceWaitInspect.put("name", deviceInspectPlan.getStr("name"));
                            deviceWaitInspect.put("cycle", i);
                            deviceWaitInspect.put("planid", deviceInspectPlan.getInt("id"));
                            deviceWaitInspect.put("executed", 0);//列表之显示状态为0的记录，0代表未执行，1代表已经执行
//							deviceWaitInspectMapper.insertOneRecord(deviceWaitInspect);
                            deviceWaitInspectMapper.addEntity(deviceWaitInspect);
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @ResponseBody
    @RequestMapping("findInspectRecordByPage")
    public PageView findInspectRecordByPage(String pageNow, String pageSize, String column, String sort) {
        DeviceWaitInspectFormMap deviceWaitInspectFormMap = getFormMap(DeviceWaitInspectFormMap.class);
        deviceWaitInspectFormMap = toFormMap(deviceWaitInspectFormMap, pageNow, pageSize, deviceWaitInspectFormMap.getStr("orderby"));
        deviceWaitInspectFormMap.put("column", column);
        deviceWaitInspectFormMap.put("sort", sort);
        deviceWaitInspectFormMap.set("executed",1);
        System.out.println(Arrays.toString(deviceWaitInspectFormMap.getAttrNames())+"--"+ Arrays.toString(deviceWaitInspectFormMap.getAttrValues()));
        pageView.setRecords(deviceWaitInspectMapper.findDeviceInspectRecord(deviceWaitInspectFormMap));
        return pageView;
    }

    @ResponseBody
    @RequestMapping("deleteInspectRecordEntity")
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String deleteInspectRecordEntity() throws Exception {
        String[] ids = getParaValues("ids");
        for (String id : ids) {
            deviceInspectRecordMapper.deleteByAttribute("id", id, DeviceInspectRecordFormMap.class);
        }
        return "success";
    }

    @RequestMapping("inspectRecordListUI")
    public String deviceInspectRecordListUI(Model model) {
        String id = getPara("id");
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/deviceinspect/inspectRecordList";
    }

    @RequestMapping("excuPlanUI")
    public String excutePlanUI(Model model) {
        String id = getPara("id");
        if (Common.isNotEmpty(id)) {
            model.addAttribute("waitInspectPlan", deviceWaitInspectMapper.findbyFrist("id", id, DeviceWaitInspectFormMap.class));
            model.addAttribute("planId", id);
        }
        return Common.BACKGROUND_PATH + "/system/deviceinspect/excuPlanUI";
    }

    @RequestMapping("execInspectUI")
    public String execInspectUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/deviceinspect/execInspect";
    }
}