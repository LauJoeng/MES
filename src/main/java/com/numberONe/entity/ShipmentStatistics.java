package com.numberONe.entity;

public class ShipmentStatistics {
	private String ioDate;
	private String compactno;
	private String exchRate;
	private String mainNum;
	private String subNum;
	public String getIoDate() {
		return ioDate;
	}
	public void setIoDate(String ioDate) {
		this.ioDate = ioDate;
	}
	public String getCompactno() {
		return compactno;
	}
	public void setCompactno(String compactno) {
		this.compactno = compactno;
	}
	public String getExchRate() {
		return exchRate;
	}
	public void setExchRate(String exchRate) {
		this.exchRate = exchRate;
	}
	public String getMainNum() {
		return mainNum;
	}
	public void setMainNum(String mainNum) {
		this.mainNum = mainNum;
	}
	public String getSubNum() {
		return subNum;
	}
	public void setSubNum(String subNum) {
		this.subNum = subNum;
	}
	@Override
	public String toString() {
		return "ShipmentStatistics [ioDate=" + ioDate + ", compactno=" + compactno + ", exchRate=" + exchRate
				+ ", mainNum=" + mainNum + ", subNum=" + subNum + "]";
	}
	
}
