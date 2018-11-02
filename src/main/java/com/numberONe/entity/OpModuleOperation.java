package com.numberONe.entity;

public class OpModuleOperation {
	private String module_code;
	private String op;
	private String china_name;
	private String process;
	
	private String optime;
	private String step;
	
	private String order_no;
	private String ordersendno;
	public String getModule_code() {
		return module_code;
	}
	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getChina_name() {
		return china_name;
	}
	public void setChina_name(String china_name) {
		this.china_name = china_name;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getOptime() {
		return optime;
	}
	public void setOptime(String optime) {
		this.optime = optime;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getOrdersendno() {
		return ordersendno;
	}
	public void setOrdersendno(String ordersendno) {
		this.ordersendno = ordersendno;
	}
	@Override
	public String toString() {
		return "OpModuleOperation [module_code=" + module_code + ", op=" + op + ", china_name=" + china_name
				+ ", process=" + process + ", optime=" + optime + ", step=" + step + ", order_no=" + order_no
				+ ", ordersendno=" + ordersendno + "]";
	}
	
	
}
