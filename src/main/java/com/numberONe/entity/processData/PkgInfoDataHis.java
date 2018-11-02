package com.numberONe.entity.processData;


//PKG
public class PkgInfoDataHis {
	private int id;
	private String module_code;//�������
	private String package_code;//��װ����
	private String module_model;//����ͺ�
	private String Material_Number;//��Ʒ���ı���
	private String grade;//����ȼ�
	private String fPower;//�����
	private String moduleseries;//���ϵ�к�
	private String op;//������
	private String delop;//ɾ����
	private String deltime;//ɾ��ʱ��
	private String effective;
	
	public PkgInfoDataHis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PkgInfoDataHis(int id, String module_code, String package_code, String module_model, String material_Number,
			String grade, String fPower, String moduleseries, String op, String delop, String deltime,
			String effective) {
		super();
		this.id = id;
		this.module_code = module_code;
		this.package_code = package_code;
		this.module_model = module_model;
		this.Material_Number = material_Number;
		this.grade = grade;
		this.fPower = fPower;
		this.moduleseries = moduleseries;
		this.op = op;
		this.delop = delop;
		this.deltime = deltime;
		this.effective = effective;
	}

	public int getId() {
		return id;
	}

	public String getModule_code() {
		return module_code;
	}


	public String getModule_model() {
		return module_model;
	}

	public String getMaterial_Number() {
		return Material_Number;
	}

	public String getGrade() {
		return grade;
	}

	public String getfPower() {
		return fPower;
	}

	public String getModuleseries() {
		return moduleseries;
	}

	public String getOp() {
		return op;
	}

	public String getDelop() {
		return delop;
	}

	public String getDeltime() {
		return deltime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}


	public void setModule_model(String module_model) {
		this.module_model = module_model;
	}

	public void setMaterial_Number(String material_Number) {
		Material_Number = material_Number;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setfPower(String fPower) {
		this.fPower = fPower;
	}

	public void setModuleseries(String moduleseries) {
		this.moduleseries = moduleseries;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public void setDelop(String delop) {
		this.delop = delop;
	}

	public void setDeltime(String deltime) {
		this.deltime = deltime;
	}

	public String getPackage_code() {
		return package_code;
	}


	public void setPackage_code(String package_code) {
		this.package_code = package_code;
	}


	public String getEffective() {
		return effective;
	}

	public void setEffective(String effective) {
		this.effective = effective;
	}

	@Override
	public String toString() {
		return "PkgInfoDataHis [id=" + id + ", module_code=" + module_code + ", package_code=" + package_code
				+ ", module_model=" + module_model + ", Material_Number=" + Material_Number + ", grade=" + grade
				+ ", fPower=" + fPower + ", moduleseries=" + moduleseries + ", op=" + op + ", delop=" + delop
				+ ", deltime=" + deltime + ", effective=" + effective + "]";
	}

}
