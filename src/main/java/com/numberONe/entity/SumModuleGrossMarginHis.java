package com.numberONe.entity;

import java.util.Arrays;
import java.util.List;

public class SumModuleGrossMarginHis {
	private String order_no ;
	private int id;
	private String createTime  ;
	private String sum_orderNum_exchRate_margin  ;
	private String sum_orderNum_exchRate_unitPrice ;
	private String sum_orderNum_exchRate ;
	private String total_gross_margin ;//总毛利率
	private String average_gross_profit ;//平均毛利率
	private List<ModuleGrossMarginHis> moduleGrossMarginHisList;
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getSum_orderNum_exchRate_margin() {
		return sum_orderNum_exchRate_margin;
	}
	public void setSum_orderNum_exchRate_margin(String sum_orderNum_exchRate_margin) {
		this.sum_orderNum_exchRate_margin = sum_orderNum_exchRate_margin;
	}
	public String getSum_orderNum_exchRate_unitPrice() {
		return sum_orderNum_exchRate_unitPrice;
	}
	public void setSum_orderNum_exchRate_unitPrice(String sum_orderNum_exchRate_unitPrice) {
		this.sum_orderNum_exchRate_unitPrice = sum_orderNum_exchRate_unitPrice;
	}
	public String getSum_orderNum_exchRate() {
		return sum_orderNum_exchRate;
	}
	public void setSum_orderNum_exchRate(String sum_orderNum_exchRate) {
		this.sum_orderNum_exchRate = sum_orderNum_exchRate;
	}
	public String getTotal_gross_margin() {
		return total_gross_margin;
	}
	public void setTotal_gross_margin(String total_gross_margin) {
		this.total_gross_margin = total_gross_margin;
	}
	public String getAverage_gross_profit() {
		return average_gross_profit;
	}
	public void setAverage_gross_profit(String average_gross_profit) {
		this.average_gross_profit = average_gross_profit;
	}
	public List<ModuleGrossMarginHis> getModuleGrossMarginHisList() {
		return moduleGrossMarginHisList;
	}
	public void setModuleGrossMarginHisList(List<ModuleGrossMarginHis> moduleGrossMarginHisList) {
		this.moduleGrossMarginHisList = moduleGrossMarginHisList;
	}
	@Override
	public String toString() {
		return "SumModuleGrossMarginHis [order_no=" + order_no + ", id=" + id + ", createTime=" + createTime
				+ ", sum_orderNum_exchRate_margin=" + sum_orderNum_exchRate_margin
				+ ", sum_orderNum_exchRate_unitPrice=" + sum_orderNum_exchRate_unitPrice + ", sum_orderNum_exchRate="
				+ sum_orderNum_exchRate + ", total_gross_margin=" + total_gross_margin + ", average_gross_profit="
				+ average_gross_profit + ", moduleGrossMarginHisList=" + moduleGrossMarginHisList + "]";
	}

	
}
