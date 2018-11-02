package com.numberONe.entity.processData;


//����
public class Cuttingdatahis {
	private String modulecode;//�������
	private String equipcode;//�豸��
	private String line;//�߱�
	private String shift;//���
	private String createtime;//����ʱ��
	private String op;//������
	private String isprint;//
	private String isrfid;
	private String delop;//ɾ����
	private String deltime;//ɾ��ʱ��
	private String effective;//��Ч״̬
	
	public Cuttingdatahis(String modulecode, String equipcode, String line, String shift, String createtime, String op,
			String isprint, String isrfid, String delop, String deltime, String effective) {
		super();
		this.modulecode = modulecode;
		this.equipcode = equipcode;
		this.line = line;
		this.shift = shift;
		this.createtime = createtime;
		this.op = op;
		this.isprint = isprint;
		this.isrfid = isrfid;
		this.delop = delop;
		this.deltime = deltime;
		this.effective = effective;
	}
	public Cuttingdatahis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getModulecode() {
		return modulecode;
	}
	public String getIsprint() {
		return isprint;
	}
	public String getIsrfid() {
		return isrfid;
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
	public String getLine() {
		return line;
	}
	public String getShift() {
		return shift;
	}
	public String getDelop() {
		return delop;
	}
	public String getDeltime() {
		return deltime;
	}
	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}
	public void setIsprint(String isprint) {
		this.isprint = isprint;
	}
	public void setIsrfid(String isrfid) {
		this.isrfid = isrfid;
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
	public void setLine(String line) {
		this.line = line;
	}
	public void setShift(String shift) {
		this.shift = shift;
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
		return "Cuttingdatahis [modulecode=" + modulecode + ", equipcode=" + equipcode + ", line=" + line + ", shift="
				+ shift + ", createtime=" + createtime + ", op=" + op + ", isprint=" + isprint + ", isrfid=" + isrfid
				+ ", delop=" + delop + ", deltime=" + deltime + ", effective=" + effective + "]";
	}
}
