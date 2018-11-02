package com.numberONe.entity.processData;
//��Ƭ
public class CellDataHis {
	private String module_code;//�������
	private String cell_code;//�������
	private String cell_code2;//�������2
	private String cell_code3;//�������3
	private String cell_op;//�豸��
	private String cell_mc;//���Ա��
	private String createtime;//����ʱ��
	private String line;//�߱�
	private String delop;//ɾ��������
	private String deltime;//ɾ��ʱ��
	private String op;//������
	private String effective;//��Ч״̬
	
	public CellDataHis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CellDataHis(String module_code, String cell_code, String cell_code2, String cell_code3, String cell_op,
			String cell_mc, String createtime, String line, String delop, String deltime, String op,
			String effective) {
		super();
		this.module_code = module_code;
		this.cell_code = cell_code;
		this.cell_code2 = cell_code2;
		this.cell_code3 = cell_code3;
		this.cell_op = cell_op;
		this.cell_mc = cell_mc;
		this.createtime = createtime;
		this.line = line;
		this.delop = delop;
		this.deltime = deltime;
		this.op = op;
		this.effective = effective;
	}

	public String getModule_code() {
		return module_code;
	}

	public String getCell_code() {
		return cell_code;
	}

	public String getCell_code2() {
		return cell_code2;
	}

	public String getCell_code3() {
		return cell_code3;
	}

	public String getCell_op() {
		return cell_op;
	}

	public String getCell_mc() {
		return cell_mc;
	}

	public String getCreatetime() {
		return createtime;
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

	public String getOp() {
		return op;
	}

	public String getEffective() {
		return effective;
	}

	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}

	public void setCell_code(String cell_code) {
		this.cell_code = cell_code;
	}

	public void setCell_code2(String cell_code2) {
		this.cell_code2 = cell_code2;
	}

	public void setCell_code3(String cell_code3) {
		this.cell_code3 = cell_code3;
	}

	public void setCell_op(String cell_op) {
		this.cell_op = cell_op;
	}

	public void setCell_mc(String cell_mc) {
		this.cell_mc = cell_mc;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
	public void setOp(String op) {
		this.op = op;
	}

	public void setEffective(String effective) {
		this.effective = effective;
	}

	@Override
	public String toString() {
		return "CellDataHis [module_code=" + module_code + ", cell_code=" + cell_code + ", cell_code2=" + cell_code2
				+ ", cell_code3=" + cell_code3 + ", cell_op=" + cell_op + ", cell_mc=" + cell_mc + ", createtime="
				+ createtime + ", line=" + line + ", delop=" + delop + ", deltime=" + deltime + ", op=" + op + "]";
	}

	
}
