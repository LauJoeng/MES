package com.numberONe.entity.processData;


//���
public class LayingDataHis {
	private String module_code;//�齫����
	private String equipcode;//�豸��
	private String createtime;//����ʱ��
	private String Computer;//��������
	private String line;//�߱�
	private String op;//����Ա��
	private String delop;//ɾ��������
	private String deltime;//ɾ��ʱ��
	private String effective;//������Ч״̬
	public LayingDataHis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LayingDataHis(String module_code, String op, String createtime, String equipcode, String computer,
			String line, String delop, String deltime, String effective) {
		super();
		this.module_code = module_code;
		this.op = op;
		this.createtime = createtime;
		this.equipcode = equipcode;
		this.Computer = computer;
		this.line = line;
		this.delop = delop;
		this.deltime = deltime;
		this.effective = effective;
	}
	public String getModule_code() {
		return module_code;
	}
	public String getOp() {
		return op;
	}
	public String getCreatetime() {
		return createtime;
	}
	public String getEquipcode() {
		return equipcode;
	}
	public String getComputer() {
		return Computer;
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
	public String getEffective() {
		return effective;
	}
	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public void setEquipcode(String equipcode) {
		this.equipcode = equipcode;
	}
	public void setComputer(String computer) {
		this.Computer = computer;
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
	public void setEffective(String effective) {
		this.effective = effective;
	}
	@Override
	public String toString() {
		return "LayingDataHis [module_code=" + module_code + ", op=" + op + ", createtime=" + createtime
				+ ", equipcode=" + equipcode + ", Computer=" + Computer + ", line=" + line + ", delop=" + delop
				+ ", deltime=" + deltime + ", effective=" + effective + "]";
	}
	
}
