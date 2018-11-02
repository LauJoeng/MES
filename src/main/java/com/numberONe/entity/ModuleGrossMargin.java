package com.numberONe.entity;

import java.util.List;

import com.numberONe.entity.MatertialBasicInfor;

public class ModuleGrossMargin{
	/*
	 * 订单中板材基本信息
	 */
	private String order_no;//订单号
	private String itemName;//板材编号
	private String itemID;//ID
	private String orderNum;//需求数量
	private String exchRate;//瓦数
	
	private List<MatertialBasicInfor> matertialBasicInforList;//料号信息
	private Boolean complete_price=true;//判断料号价格是否健全
	/*
	 * 需要自己建表维护信息
	 * 根据瓦数区分
	 */
	private String scrappage;//报废率
	private String royalty_rate;//业务提成
	private String water_electricity;//水电费
	private String cost_labor;//人工费
	private String foreign_currency_prices;//外币价格
	private String foreign_currency_rate;//外币汇率
	private String commission_rate;//佣金率
	private String premium_rate;//中信保费率
	private String basic_commission_premium;//佣金 保费 基础数；
	
	public String getRoyalty_rate() {
		return royalty_rate;
	}
	public void setRoyalty_rate(String royalty_rate) {
		this.royalty_rate = royalty_rate;
	}
	public Boolean getComplete_price() {
		return complete_price;
	}
	public void setComplete_price(Boolean complete_price) {
		this.complete_price = complete_price;
	}
	public String getScrappage() {
		return scrappage;
	}
	public void setScrappage(String scrappage) {
		this.scrappage = scrappage;
	}
	public String getWater_electricity() {
		return water_electricity;
	}
	public void setWater_electricity(String water_electricity) {
		this.water_electricity = water_electricity;
	}
	public String getCost_labor() {
		return cost_labor;
	}
	public void setCost_labor(String cost_labor) {
		this.cost_labor = cost_labor;
	}
	public String getForeign_currency_prices() {
		return foreign_currency_prices;
	}
	public void setForeign_currency_prices(String foreign_currency_prices) {
		this.foreign_currency_prices = foreign_currency_prices;
	}
	public String getForeign_currency_rate() {
		return foreign_currency_rate;
	}
	public void setForeign_currency_rate(String foreign_currency_rate) {
		this.foreign_currency_rate = foreign_currency_rate;
	}
	public String getCommission_rate() {
		return commission_rate;
	}
	public void setCommission_rate(String commission_rate) {
		this.commission_rate = commission_rate;
	}
	public String getPremium_rate() {
		return premium_rate;
	}
	public void setPremium_rate(String premium_rate) {
		this.premium_rate = premium_rate;
	}
	public String getBasic_commission_premium() {
		return basic_commission_premium;
	}
	public void setBasic_commission_premium(String basic_commission_premium) {
		this.basic_commission_premium = basic_commission_premium;
	}
	public List<MatertialBasicInfor> getMatertialBasicInforList() {
		return matertialBasicInforList;
	}
	public void setMatertialBasicInforList(List<MatertialBasicInfor> matertialBasicInforList) {
		this.matertialBasicInforList = matertialBasicInforList;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getExchRate() {
		return exchRate;
	}
	public void setExchRate(String exchRate) {
		this.exchRate = exchRate;
	}
	@Override
	public String toString() {
		return "ModuleGrossMargin [order_no=" + order_no + ", itemName=" + itemName + ", itemID=" + itemID
				+ ", orderNum=" + orderNum + ", exchRate=" + exchRate + ", matertialBasicInforList="
				+ matertialBasicInforList + ", complete_price=" + complete_price + ", scrappage=" + scrappage
				+ ", royalty_rate=" + royalty_rate + ", water_electricity=" + water_electricity + ", cost_labor="
				+ cost_labor + ", foreign_currency_prices=" + foreign_currency_prices + ", foreign_currency_rate="
				+ foreign_currency_rate + ", commission_rate=" + commission_rate + ", premium_rate=" + premium_rate
				+ ", basic_commission_premium=" + basic_commission_premium + "]";
	}
	
	
	

	
	/**
	 * 板材的详细信息
	 * @return
	 */
	
	
	
}
