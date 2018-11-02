package com.numberONe.entity;

import java.util.List;

public class ModuleGrossMarginHis {
	/*
	 * 订单中板材基本信息
	 */
	private int id;
	private String order_no;//订单号
	private String itemName;//板材编号
	private String itemID;//ID
	private String orderNum;//需求数量
	private String exchRate;//瓦数	
	private List<MatertialBasicInforHis> matertialBasicInforList;//料号信息
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
	
	private String sea;//海运
	private String inland;//内陆
	private String foreign;//国外
	private String orderNum_exchRate_margin;//数量*瓦数*当月毛利额
	private String orderNum_exchRate_unitPrice;//数量*瓦数*价格
	private String orderNum_exchRate;//数量*瓦数
	private String premium;//中信保费
	private String commission;//佣金
	private String unitPrice;//单价
	private String royalty;//业务提成
	private String gross_profit_margin;//当月毛利额
	private String no_cost_silicon;//非硅成本
	private String cost_silicon;//硅成本
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<MatertialBasicInforHis> getMatertialBasicInforList() {
		return matertialBasicInforList;
	}
	public void setMatertialBasicInforList(List<MatertialBasicInforHis> matertialBasicInforList) {
		this.matertialBasicInforList = matertialBasicInforList;
	}
	public String getScrappage() {
		return scrappage;
	}
	public void setScrappage(String scrappage) {
		this.scrappage = scrappage;
	}
	public String getRoyalty_rate() {
		return royalty_rate;
	}
	public void setRoyalty_rate(String royalty_rate) {
		this.royalty_rate = royalty_rate;
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
	public String getSea() {
		return sea;
	}
	public void setSea(String sea) {
		this.sea = sea;
	}
	public String getInland() {
		return inland;
	}
	public void setInland(String inland) {
		this.inland = inland;
	}
	public String getForeign() {
		return foreign;
	}
	public void setForeign(String foreign) {
		this.foreign = foreign;
	}
	public String getOrderNum_exchRate_margin() {
		return orderNum_exchRate_margin;
	}
	public void setOrderNum_exchRate_margin(String orderNum_exchRate_margin) {
		this.orderNum_exchRate_margin = orderNum_exchRate_margin;
	}
	public String getOrderNum_exchRate_unitPrice() {
		return orderNum_exchRate_unitPrice;
	}
	public void setOrderNum_exchRate_unitPrice(String orderNum_exchRate_unitPrice) {
		this.orderNum_exchRate_unitPrice = orderNum_exchRate_unitPrice;
	}
	public String getOrderNum_exchRate() {
		return orderNum_exchRate;
	}
	public void setOrderNum_exchRate(String orderNum_exchRate) {
		this.orderNum_exchRate = orderNum_exchRate;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getRoyalty() {
		return royalty;
	}
	public void setRoyalty(String royalty) {
		this.royalty = royalty;
	}
	public String getGross_profit_margin() {
		return gross_profit_margin;
	}
	public void setGross_profit_margin(String gross_profit_margin) {
		this.gross_profit_margin = gross_profit_margin;
	}
	public String getNo_cost_silicon() {
		return no_cost_silicon;
	}
	public void setNo_cost_silicon(String no_cost_silicon) {
		this.no_cost_silicon = no_cost_silicon;
	}
	public String getCost_silicon() {
		return cost_silicon;
	}
	public void setCost_silicon(String cost_silicon) {
		this.cost_silicon = cost_silicon;
	}
	@Override
	public String toString() {
		return "ModuleGrossMarginHis [id=" + id + ", order_no=" + order_no + ", itemName=" + itemName + ", itemID="
				+ itemID + ", orderNum=" + orderNum + ", exchRate=" + exchRate + ", matertialBasicInforList="
				+ matertialBasicInforList + ", scrappage=" + scrappage + ", royalty_rate=" + royalty_rate
				+ ", water_electricity=" + water_electricity + ", cost_labor=" + cost_labor
				+ ", foreign_currency_prices=" + foreign_currency_prices + ", foreign_currency_rate="
				+ foreign_currency_rate + ", commission_rate=" + commission_rate + ", premium_rate=" + premium_rate
				+ ", basic_commission_premium=" + basic_commission_premium + ", sea=" + sea + ", inland=" + inland
				+ ", foreign=" + foreign + ", orderNum_exchRate_margin=" + orderNum_exchRate_margin
				+ ", orderNum_exchRate_unitPrice=" + orderNum_exchRate_unitPrice + ", orderNum_exchRate="
				+ orderNum_exchRate + ", premium=" + premium + ", commission=" + commission + ", unitPrice=" + unitPrice
				+ ", royalty=" + royalty + ", gross_profit_margin=" + gross_profit_margin + ", no_cost_silicon="
				+ no_cost_silicon + ", cost_silicon=" + cost_silicon + "]";
	}

	
}
