package com.numberONe.entity.processData;


//FQC
public class FqcDataHis {
	private String module_code;//�������
	private String equipcode;//�豸��
	private String ShiftName;//���
	private String line;//�߱�
	private String fqc_time;
	private String grade;
	private String defectdetail;
	private String Computer;//���Ա��
	private String back_code;
	private String bk_code;
	private String color;
	private String op;//������
	private String remark;//��ע
	private String delop;//ɾ����
	private String deltime;//ɾ��ʱ��
	private String effective;//��Ч״̬
	public FqcDataHis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FqcDataHis(String module_code, String equipcode, String shiftName, String line, String fqc_time,
			String grade, String defectdetail, String computer, String back_code, String bk_code, String color,
			String op, String remark, String delop, String deltime, String effective) {
		super();
		this.module_code = module_code;
		this.equipcode = equipcode;
		this.ShiftName = shiftName;
		this.line = line;
		this.fqc_time = fqc_time;
		this.grade = grade;
		this.defectdetail = defectdetail;
		this.Computer = computer;
		this.back_code = back_code;
		this.bk_code = bk_code;
		this.color = color;
		this.op = op;
		this.remark = remark;
		this.delop = delop;
		this.deltime = deltime;
		this.effective = effective;
	}

	public String getModule_code() {
		return module_code;
	}
	public String getFqc_time() {
		return fqc_time;
	}
	public String getGrade() {
		return grade;
	}
	public String getDefectdetail() {
		return defectdetail;
	}
	public String getRemark() {
		return remark;
	}
	public String getOp() {
		return op;
	}
	public String getComputer() {
		return Computer;
	}
	public String getBack_code() {
		return back_code;
	}
	public String getBk_code() {
		return bk_code;
	}
	public String getShiftName() {
		return ShiftName;
	}
	public String getColor() {
		return color;
	}
	public String getLine() {
		return line;
	}
	public String getEquipcode() {
		return equipcode;
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
	public void setFqc_time(String fqc_time) {
		this.fqc_time = fqc_time;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setDefectdetail(String defectdetail) {
		this.defectdetail = defectdetail;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public void setComputer(String computer) {
		this.Computer = computer;
	}
	public void setBack_code(String back_code) {
		this.back_code = back_code;
	}
	public void setBk_code(String bk_code) {
		this.bk_code = bk_code;
	}
	public void setShiftName(String shiftName) {
		this.ShiftName = shiftName;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public void setEquipcode(String equipcode) {
		this.equipcode = equipcode;
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
		return "FqcDataHis [module_code=" + module_code + ", equipcode=" + equipcode + ", ShiftName=" + ShiftName
				+ ", line=" + line + ", fqc_time=" + fqc_time + ", grade=" + grade + ", defectdetail=" + defectdetail
				+ ", Computer=" + Computer + ", back_code=" + back_code + ", bk_code=" + bk_code + ", color=" + color
				+ ", op=" + op + ", remark=" + remark + ", delop=" + delop + ", deltime=" + deltime + ", effective="
				+ effective + "]";
	}
}
