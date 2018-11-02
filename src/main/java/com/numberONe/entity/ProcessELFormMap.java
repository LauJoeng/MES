package com.numberONe.entity;

import java.sql.Date;





/**
 * 实体表
 */

public class ProcessELFormMap {
	private static final long serialVersionUID = 1L;
	private String order_no;
	private String module_code;
	private String createtime;
	private String el_test_time;
	private String result;
	private String equipcode;
	private String op;
	private String imagepath;
	private String ShiftName;
	private String line;
	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getModule_code() {
		return module_code;
	}
	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getEquipcode() {
		return equipcode;
	}
	public void setEquipcode(String equipcode) {
		this.equipcode = equipcode;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getShiftName() {
		return ShiftName;
	}
	public void setShiftName(String shiftName) {
		ShiftName = shiftName;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getEl_test_time() {
		return el_test_time;
	}

	public void setEl_test_time(String el_test_time) {
		this.el_test_time = el_test_time;
	}

	@Override
	public String toString() {
		return "ProcessELFormMap [order_no=" + order_no + ", module_code=" + module_code + ", createtime=" + createtime
				+ ", el_test_time=" + el_test_time + ", result=" + result + ", equipcode=" + equipcode + ", op=" + op
				+ ", imagepath=" + imagepath + ", ShiftName=" + ShiftName + ", line=" + line + "]";
	}


	
	
	

	

}
