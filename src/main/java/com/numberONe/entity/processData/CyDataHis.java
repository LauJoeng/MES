package com.numberONe.entity.processData;


//��ѹ
public class CyDataHis {
	private String module_code;//�������
	private String locationno;//����
	private String op;//������
	private String createtime;//����ʱ��;
	private String computer;//���Ա��
	private String shiftName;//���
	private String line;//�߱�
	private String EquipCode;
	private String Reserve2;
	private String Reserve3;
	private String Reserve4;
	private String Reserve5;
	private String delop;//ɾ����
	private String deltime;//ɾ��ʱ��
	private String effective;//��Ч״̬
	public CyDataHis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CyDataHis(String module_code, String locationno, String op, String createtime, String computer,
			String shiftName, String line, String equipCode, String reserve2, String reserve3, String reserve4,
			String reserve5, String delop, String deltime, String effective) {
		super();
		this.module_code = module_code;
		this.locationno = locationno;
		this.op = op;
		this.createtime = createtime;
		this.computer = computer;
		this.shiftName = shiftName;
		this.line = line;
		this.EquipCode = equipCode;
		this.Reserve2 = reserve2;
		this.Reserve3 = reserve3;
		this.Reserve4 = reserve4;
		this.Reserve5 = reserve5;
		this.delop = delop;
		this.deltime = deltime;
		this.effective = effective;
	}

	public String getModule_code() {
		return module_code;
	}
	public String getLocationno() {
		return locationno;
	}
	public String getOp() {
		return op;
	}
	public String getCreatetime() {
		return createtime;
	}
	public String getComputer() {
		return computer;
	}
	public String getShiftName() {
		return shiftName;
	}
	public String getEquipCode() {
		return EquipCode;
	}
	public String getLine() {
		return line;
	}
	public String getReserve2() {
		return Reserve2;
	}
	public String getReserve3() {
		return Reserve3;
	}
	public String getReserve4() {
		return Reserve4;
	}
	public String getReserve5() {
		return Reserve5;
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
	public void setLocationno(String locationno) {
		this.locationno = locationno;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
	public void setEquipCode(String equipCode) {
		this.EquipCode = equipCode;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public void setReserve2(String reserve2) {
		this.Reserve2 = reserve2;
	}
	public void setReserve3(String reserve3) {
		this.Reserve3 = reserve3;
	}
	public void setReserve4(String reserve4) {
		this.Reserve4 = reserve4;
	}
	public void setReserve5(String reserve5) {
		this.Reserve5 = reserve5;
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
		return "CyDataHis [module_code=" + module_code + ", locationno=" + locationno + ", op=" + op + ", createtime="
				+ createtime + ", computer=" + computer + ", shiftName=" + shiftName + ", line=" + line + ", EquipCode="
				+ EquipCode + ", Reserve2=" + Reserve2 + ", Reserve3=" + Reserve3 + ", Reserve4=" + Reserve4
				+ ", Reserve5=" + Reserve5 + ", delop=" + delop + ", deltime=" + deltime + ", effective=" + effective
				+ "]";
	}
}
