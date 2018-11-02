package com.numberONe.entity.processData;


//װ��
public class FrameDataHis {
	private String module_code;//�������
	private String equipcode;//�豸��
	private String ShiftName;//���
	private String line;//�߱�
	private String createtime;//����ʱ��
	private String op;//������
	private String computername;
	private String delop;//ɾ����
	private String deltime;//ɾ��ʱ��
	private String effective;//��Ч״̬
	public FrameDataHis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FrameDataHis(String module_code, String equipcode, String shiftName, String line, String createtime,
			String op, String computername, String delop, String deltime, String effective) {
		super();
		this.module_code = module_code;
		this.equipcode = equipcode;
		this.ShiftName = shiftName;
		this.line = line;
		this.createtime = createtime;
		this.op = op;
		this.computername = computername;
		this.delop = delop;
		this.deltime = deltime;
		this.effective = effective;
	}

	public String getModule_code() {
		return module_code;
	}
	public String getCreatetime() {
		return createtime;
	}
	public String getOp() {
		return op;
	}
	public String getEquipcode() {
		return equipcode;
	}
	public String getShiftName() {
		return ShiftName;
	}
	public String getLine() {
		return line;
	}
	public String getComputername() {
		return computername;
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
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public void setEquipcode(String equipcode) {
		this.equipcode = equipcode;
	}
	public void setShiftName(String shiftName) {
		this.ShiftName = shiftName;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public void setComputername(String computername) {
		this.computername = computername;
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
		return "FrameDataHis [module_code=" + module_code + ", equipcode=" + equipcode + ", ShiftName=" + ShiftName
				+ ", line=" + line + ", createtime=" + createtime + ", op=" + op + ", computername=" + computername
				+ ", delop=" + delop + ", deltime=" + deltime + ", effective=" + effective + "]";
	}
	
}
