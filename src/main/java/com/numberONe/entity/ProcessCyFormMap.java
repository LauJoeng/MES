package com.numberONe.entity;

import java.sql.Date;

import com.numberONe.annotation.TableSeg;
import com.numberONe.util.FormMap;



/**
 * 实体表
 */

public class ProcessCyFormMap {
	private static final long serialVersionUID = 1L;
	private String module_code;
	private String locationno;
	private String op;
	private String createtime;
	private String computer;
	private String shiftName;
	private String equipCode;
	private String line;
	private String Reserve2;
	private String Reserve3;
	private String Reserve4;
	private String Reserve5;
	public String getModule_code() {
		return module_code;
	}
	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}
	public String getLocationno() {
		return locationno;
	}
	public void setLocationno(String locationno) {
		this.locationno = locationno;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getComputer() {
		return computer;
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	public String getShiftName() {
		return shiftName;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
	public String getEquipCode() {
		return equipCode;
	}
	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getReserve2() {
		return Reserve2;
	}
	public void setReserve2(String reserve2) {
		Reserve2 = reserve2;
	}
	public String getReserve3() {
		return Reserve3;
	}
	public void setReserve3(String reserve3) {
		Reserve3 = reserve3;
	}
	public String getReserve4() {
		return Reserve4;
	}
	public void setReserve4(String reserve4) {
		Reserve4 = reserve4;
	}
	public String getReserve5() {
		return Reserve5;
	}
	public void setReserve5(String reserve5) {
		Reserve5 = reserve5;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ProcessCyFormMap [module_code=" + module_code + ", locationno=" + locationno + ", op=" + op
				+ ", createtime=" + createtime + ", computer=" + computer + ", shiftName=" + shiftName + ", equipCode="
				+ equipCode + ", line=" + line + ", Reserve2=" + Reserve2 + ", Reserve3=" + Reserve3 + ", Reserve4="
				+ Reserve4 + ", Reserve5=" + Reserve5 + "]";
	}
	
	
	

}
