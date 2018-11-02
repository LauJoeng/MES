package com.numberONe.controller.system;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberONe.controller.index.UtilityController;
import com.numberONe.entity.MatertialBasicInfor;
import com.numberONe.entity.MatertialBasicInforHis;
import com.numberONe.entity.ModuleGrossMargin;
import com.numberONe.entity.ModuleGrossMarginHis;
import com.numberONe.entity.OrderSumMoney;
import com.numberONe.entity.SumModuleGrossMarginHis;
import com.numberONe.mapper.ModuleGrossMarginUpdateMapper;
import com.numberONe.mapper.mapper2.ModuleGrossMarginMapper;
import com.numberONe.mapper.mapper2.OrderSumMoneyMapper;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;

/**
 * 
 * @author numberONe 2014-11-19
 * @version 3.0v
 */
@Controller
@RequestMapping("/module_detailed_list/")
public class ModuleDetailedListController extends UtilityController{
	@Resource
	private ModuleGrossMarginMapper moduleGrossMarginMapper;
	@Resource
	private ModuleGrossMarginUpdateMapper moduleGrossMarginUpdateMapper;
	@Resource
	private  OrderSumMoneyMapper orderSumMoneyMapper;

	@RequestMapping("moduleGrossMargin")
	public String operationDataQueryPage(Model model) throws Exception {
		/*model.addAttribute("res", findByRes());*/
		return Common.BACKGROUND_PATH + "/system/moduledetailedlist/moduleGrossMargin";
	}
	

	
	@ResponseBody
	@RequestMapping("selectModuleGrossMargin")
	public List<ModuleGrossMargin> selectModuleGrossMargin(String order_no) throws Exception {
		List<ModuleGrossMargin> listmodule=moduleGrossMarginMapper.selectModule(order_no);
		for(int i=0;i<listmodule.size();i++) {
			ModuleGrossMargin moduleGrossMargin=moduleGrossMarginUpdateMapper.selectByExchRateInfor(listmodule.get(i));
			if(moduleGrossMargin!=null) {
			listmodule.get(i).setScrappage(moduleGrossMargin.getScrappage());
			listmodule.get(i).setWater_electricity(moduleGrossMargin.getWater_electricity());
			listmodule.get(i).setCost_labor(moduleGrossMargin.getCost_labor());
			listmodule.get(i).setForeign_currency_prices(moduleGrossMargin.getForeign_currency_prices());
			listmodule.get(i).setForeign_currency_rate(moduleGrossMargin.getForeign_currency_rate());
			listmodule.get(i).setCommission_rate(moduleGrossMargin.getCommission_rate());
			listmodule.get(i).setPremium_rate(moduleGrossMargin.getPremium_rate());
			listmodule.get(i).setBasic_commission_premium(moduleGrossMargin.getBasic_commission_premium());
			listmodule.get(i).setRoyalty_rate(moduleGrossMargin.getRoyalty_rate());
			}
			/*
			 * 对应背板的物料信息
			 */
			List<MatertialBasicInfor>matertialBasicInforList=null;
			matertialBasicInforList=moduleGrossMarginMapper.selectModuleGrossMargin(listmodule.get(i));
			listmodule.get(i).setMatertialBasicInforList(matertialBasicInforList);
			/*
			 * 对应物料信息的价格查询
			 */
			int size=listmodule.get(i).getMatertialBasicInforList().size();
			for(int j=0;j<size;j++) {
				MatertialBasicInfor matertialBasicInfor=listmodule.get(i).getMatertialBasicInforList().get(j);
				String price=moduleGrossMarginUpdateMapper.selectPrice(matertialBasicInfor);
				if(price==null) {
					//物料信息不完全
					listmodule.get(i).setComplete_price(false);
					/*price="0";*/
				}
				matertialBasicInfor.setTaxPrice(price);	
			}
		}
/*		System.out.println(listmodule);
*/		return listmodule;
	}
	@ResponseBody
	@RequestMapping("updateModuleGrossMargin")
	public String updateModuleGrossMargin (ModuleGrossMargin moduleGrossMargin) throws Exception{
		//先查询是否存在 存在则更新数据 不存在则新建数据；
		if(moduleGrossMarginUpdateMapper.selectByExchRateInfor(moduleGrossMargin)!=null) {
			 boolean cheack= moduleGrossMarginUpdateMapper.updateModuleGrossMargin(moduleGrossMargin);
			 if(cheack==false) {
				 return "error";
			 }
		}else {
			int i=moduleGrossMarginUpdateMapper.insertModuleGrossMargin(moduleGrossMargin);
			if(i==0) {
				return "error";
			}
		}
		
		/*System.out.println(moduleGrossMargin);*/
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("updateMatertialBasicInforList")
	public String updateMatertialBasicInforList (@RequestBody MatertialBasicInfor[]  matertialBasicInforList) throws Exception{
		MatertialBasicInfor matertialBasicInfor;
		for(int i=0;i<matertialBasicInforList.length;i++) {
			matertialBasicInfor=matertialBasicInforList[i];
			if(moduleGrossMarginUpdateMapper.selectPrice(matertialBasicInfor)!=null) {
				boolean cheack= moduleGrossMarginUpdateMapper.updateMatertialBasicInfor(matertialBasicInfor);

			}else {
				int j=moduleGrossMarginUpdateMapper.insertMatertialBasicInfor(matertialBasicInfor);
		
			}
		}
		
		/*System.out.println(matertialBasicInforList);*/
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("updateCalculateModuleGrossMargin")
	public  String updateCalculateModuleGrossMargin (@RequestBody  ModuleGrossMarginHis []moduleGrossMarginHis,HttpServletRequest request) throws Exception{
		Map<String,String[]> map=request.getParameterMap();		
        SumModuleGrossMarginHis sumModuleGrossMarginHis=new SumModuleGrossMarginHis();
        sumModuleGrossMarginHis.setAverage_gross_profit(map.get("average_gross_profit")[0]);
        sumModuleGrossMarginHis.setOrder_no(map.get("order_no")[0]);
        sumModuleGrossMarginHis.setSum_orderNum_exchRate(map.get("sum_orderNum_exchRate")[0]);
        sumModuleGrossMarginHis.setSum_orderNum_exchRate_margin(map.get("sum_orderNum_exchRate_margin")[0]);
        sumModuleGrossMarginHis.setSum_orderNum_exchRate_unitPrice(map.get("sum_orderNum_exchRate_unitPrice")[0]);
        sumModuleGrossMarginHis.setTotal_gross_margin(map.get("total_gross_margin")[0]);

    
        moduleGrossMarginUpdateMapper.insertSumModuleGrossMarginHis(sumModuleGrossMarginHis);
        int id= sumModuleGrossMarginHis.getId();
        List <ModuleGrossMarginHis> list=new <ModuleGrossMarginHis>ArrayList();
        for(ModuleGrossMarginHis m:moduleGrossMarginHis) {
        	m.setId(id);
        	moduleGrossMarginUpdateMapper.insertModuleGrossMarginHis(m);
        	 for(MatertialBasicInforHis h:m.getMatertialBasicInforList()) {
        		 h.setModule_itemId(m.getItemID());
        		 h.setId(id);
        		 moduleGrossMarginUpdateMapper.inserttMatertialBasicInforHis(h);
        	 }
        	list.add(m);
        } 

		return "success";
	}
	
	@RequestMapping("calculateModuleMargin")
	public String calculateModuleMarginPage(Model model) throws Exception {
		/*model.addAttribute("res", findByRes());*/
		return Common.BACKGROUND_PATH + "/system/moduledetailedlist/calculateModuleMargin";
	}
	
	@RequestMapping("orderSumMoney")
	public String orderSumMoney(Model model) throws Exception {
		/*model.addAttribute("res", findByRes());*/
		return Common.BACKGROUND_PATH + "/system/moduledetailedlist/orderSumMoney";
	}
/*	@ResponseBody
	@RequestMapping("orderSumMoneySelect")
	public List<OrderSumMoney> orderSumMoneySelect(String starttime,String endtime) throws Exception {
		List<OrderSumMoney> list=orderSumMoneyMapper.orderSumMoney(starttime, endtime);
		for(OrderSumMoney e:list){
			if(e.getCompactno().equals("")) {
				double empty_money=e.getAllMoney();
				list.remove(e);
					for(OrderSumMoney x:list) {
					x.setAllMoney(x.getAllMoney()+(empty_money/list.size()));
					}
				break;
			}
			
		}
	return list;
	}*/
	@ResponseBody
	@RequestMapping("orderSumMoneySelect")
	public PageView orderSumMoneySelect(String pageNow,
			String pageSize,String starttime,String endtime) throws Exception {
		List<OrderSumMoney> list=orderSumMoneyMapper.orderSumMoney(starttime, endtime);
		//迭代看是否有为空的字段
		for(OrderSumMoney e:list){
			if(e.getCompactno().equals("")) {
				double empty_money=e.getAllMoney();
				list.remove(e);
					for(OrderSumMoney x:list) {
						BigDecimal b=	new BigDecimal(Double.toString(x.getAllMoney()+(empty_money/list.size())));
						
						x.setAllMoney(b.setScale(4, RoundingMode.HALF_UP).doubleValue());
					}
				break;
			}
			
		}
		PageView pageView=burstView(pageNow,pageSize,list);
	return pageView;
	}
	
	
}
	
	
