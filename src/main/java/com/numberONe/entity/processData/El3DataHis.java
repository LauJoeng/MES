package com.numberONe.entity.processData;


//���EL
public class El3DataHis {
	private String module_code;//�������
	private String equipcode;//�豸��
	private String el_test_time;
	private String ShiftName;//���
	private String line;//�߱�
	private String op;//������
	private String imagepath;//ͼƬ·��
	private String result;
	private String delop;//ɾ����
	private String deltime;//ɾ��ʱ��
	private String effective;//��Ч״̬
	public El3DataHis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public El3DataHis(String module_code, String equipcode, String el_test_time, String shiftName, String line,
			String op, String imagepath, String result, String delop, String deltime, String effective) {
		super();
		this.module_code = module_code;
		this.equipcode = equipcode;
		this.el_test_time = el_test_time;
		this.ShiftName = shiftName;
		this.line = line;
		this.op = op;
		this.imagepath = imagepath;
		this.result = result;
		this.delop = delop;
		this.deltime = deltime;
		this.effective = effective;
	}

	public String getModule_code() {
		return module_code;
	}
	public String getEl_test_time() {
		return el_test_time;
	}
	public String getResult() {
		return result;
	}
	public String getEquipcode() {
		return equipcode;
	}
	public String getOp() {
		return op;
	}
	public String getImagepath() {
		return imagepath;
	}
	public String getShiftName() {
		return ShiftName;
	}
	public String getLine() {
		return line;
	}
	public String getDelop() {
		return delop;
	}
	public String getDeltime() {
		return deltime;
	}
	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}
	public void setEl_test_time(String el_test_time) {
		this.el_test_time = el_test_time;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setEquipcode(String equipcode) {
		this.equipcode = equipcode;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public void setShiftName(String shiftName) {
		this.ShiftName = shiftName;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public void setDelop(String delop) {
		this.delop = delop;
	}
	public void setDeltime(String deltime) {
		this.deltime = deltime;
	}
	
	public String getEffective() {
		return effective;
	}

	public void setEffective(String effective) {
		this.effective = effective;
	}

	@Override
	public String toString() {
		return "ProcessEl3DataHis [module_code=" + module_code + ", equipcode=" + equipcode + ", el_test_time="
				+ el_test_time + ", ShiftName=" + ShiftName + ", line=" + line + ", op=" + op + ", imagepath="
				+ imagepath + ", result=" + result + ", delop=" + delop + ", deltime=" + deltime + ", effective="
				+ effective + "]";
	}
}
