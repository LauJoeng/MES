package com.numberONe.entity;

public class OrderSumMoney {
	private String compactno;
	private double allMoney;
	private String ordernum;
	private double salemoney;
	
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public double getSalemoney() {
		return salemoney;
	}
	public void setSalemoney(double salemoney) {
		this.salemoney = salemoney;
	}
	public String getCompactno() {
		return compactno;
	}
	public void setCompactno(String compactno) {
		this.compactno = compactno;
	}
	public double getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(double allMoney) {    
		this.allMoney = allMoney;
	}
	@Override
	public String toString() {
		return "OrderSumMoney [compactno=" + compactno + ", allMoney=" + allMoney + ", ordernum=" + ordernum
				+ ", salemoney=" + salemoney + "]";
	}


}
