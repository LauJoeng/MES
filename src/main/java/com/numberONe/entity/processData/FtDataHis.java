package com.numberONe.entity.processData;


//IV����
public class FtDataHis {
	private String module_code;//�������
	private String equipcode;//�豸��
	private String createtime;//����ʱ��
	private String computer;//���Ժ�
	private String shiftName;//���
	private String line;//�߱�
	private String test_time;
	private double ncell;
	private double rsh;
	private double rs;
	private double fF;
	private double isc;
	private double voc;
	private double imax;
	private double vmax;
	private double pmax;
	private double envTemp;
	private double surfTemp;
	private double f_power;
	private String iv_path;
	private String f_ia;
	private String nmodule;
	private String op;//������
	private String delop;//ɾ����
	private String deltime;//ɾ��ʱ��
	private String effective;
	public String getModule_code() {
		return module_code;
	}
	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}
	public String getEquipcode() {
		return equipcode;
	}
	public void setEquipcode(String equipcode) {
		this.equipcode = equipcode;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getComputer() {
		return computer;
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	public String getShiftName() {
		return shiftName;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getTest_time() {
		return test_time;
	}
	public void setTest_time(String test_time) {
		this.test_time = test_time;
	}
	public double getNcell() {
		return ncell;
	}
	public void setNcell(double ncell) {
		this.ncell = ncell;
	}
	public double getRsh() {
		return rsh;
	}
	public void setRsh(double rsh) {
		this.rsh = rsh;
	}
	public double getRs() {
		return rs;
	}
	public void setRs(double rs) {
		this.rs = rs;
	}
	public double getfF() {
		return fF;
	}
	public void setfF(double fF) {
		this.fF = fF;
	}
	public double getIsc() {
		return isc;
	}
	public void setIsc(double isc) {
		this.isc = isc;
	}
	public double getVoc() {
		return voc;
	}
	public void setVoc(double voc) {
		this.voc = voc;
	}
	public double getImax() {
		return imax;
	}
	public void setImax(double imax) {
		this.imax = imax;
	}
	public double getVmax() {
		return vmax;
	}
	public void setVmax(double vmax) {
		this.vmax = vmax;
	}
	public double getPmax() {
		return pmax;
	}
	public void setPmax(double pmax) {
		this.pmax = pmax;
	}
	public double getEnvTemp() {
		return envTemp;
	}
	public void setEnvTemp(double envTemp) {
		this.envTemp = envTemp;
	}
	public double getSurfTemp() {
		return surfTemp;
	}
	public void setSurfTemp(double surfTemp) {
		this.surfTemp = surfTemp;
	}
	public double getF_power() {
		return f_power;
	}
	public void setF_power(double f_power) {
		this.f_power = f_power;
	}
	public String getIv_path() {
		return iv_path;
	}
	public void setIv_path(String iv_path) {
		this.iv_path = iv_path;
	}
	public String getF_ia() {
		return f_ia;
	}
	public void setF_ia(String f_ia) {
		this.f_ia = f_ia;
	}
	public String getNmodule() {
		return nmodule;
	}
	public void setNmodule(String nmodule) {
		this.nmodule = nmodule;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getDelop() {
		return delop;
	}
	public void setDelop(String delop) {
		this.delop = delop;
	}
	public String getDeltime() {
		return deltime;
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
		return "FtDataHis [module_code=" + module_code + ", equipcode=" + equipcode + ", createtime=" + createtime
				+ ", computer=" + computer + ", shiftName=" + shiftName + ", line=" + line + ", test_time=" + test_time
				+ ", ncell=" + ncell + ", rsh=" + rsh + ", rs=" + rs + ", fF=" + fF + ", isc=" + isc + ", voc=" + voc
				+ ", imax=" + imax + ", vmax=" + vmax + ", pmax=" + pmax + ", envTemp=" + envTemp + ", surfTemp="
				+ surfTemp + ", f_power=" + f_power + ", iv_path=" + iv_path + ", f_ia=" + f_ia + ", nmodule=" + nmodule
				+ ", op=" + op + ", delop=" + delop + ", deltime=" + deltime + ", effective=" + effective + "]";
	}
	
/*
	
	public FtDataHis(String module_code, String equipcode, String createtime, String computer, String shiftName,
			String line, String test_time, double ncell, double rsh, double rs, double fF, double isc, double voc,
			double imax, double vmax, double pmax, double envTemp, double surfTemp, String op, double f_power,
			String iv_path, String f_ia, String nmodule, String delop, String deltime, String effective) {
		super();
		this.module_code = module_code;
		this.equipcode = equipcode;
		this.createtime = createtime;
		this.Computer = computer;
		this.ShiftName = shiftName;
		this.line = line;
		this.test_time = test_time;
		this.ncell = ncell;
		this.Rsh = rsh;
		this.Rs = rs;
		this.FF = fF;
		this.Isc = isc;
		this.Voc = voc;
		this.Imax = imax;
		this.Vmax = vmax;
		this.Pmax = pmax;
		this.EnvTemp = envTemp;
		this.SurfTemp = surfTemp;
		this.op = op;
		this.f_power = f_power;
		this.iv_path = iv_path;
		this.f_ia = f_ia;
		this.nmodule = nmodule;
		this.delop = delop;
		this.deltime = deltime;
		this.effective = effective;
	}

	public String getModule_code() {
		return module_code;
	}
	public String getTest_time() {
		return test_time;
	}
	public double getNcell() {
		return ncell;
	}
	public double getRsh() {
		return Rsh;
	}
	public double getRs() {
		return Rs;
	}
	public double getFF() {
		return FF;
	}
	public double getIsc() {
		return Isc;
	}
	public double getVoc() {
		return Voc;
	}
	public double getImax() {
		return Imax;
	}
	public double getVmax() {
		return Vmax;
	}
	public double getPmax() {
		return Pmax;
	}
	public double getEnvTemp() {
		return EnvTemp;
	}
	public double getSurfTemp() {
		return SurfTemp;
	}
	public String getOp() {
		return op;
	}
	public String getComputer() {
		return Computer;
	}
	public double getF_power() {
		return f_power;
	}
	public String getIv_path() {
		return iv_path;
	}
	public String getF_ia() {
		return f_ia;
	}
	public String getShiftName() {
		return ShiftName;
	}
	public String getLine() {
		return line;
	}
	public String getEquipcode() {
		return equipcode;
	}
	public String getNmodule() {
		return nmodule;
	}
	public String getCreatetime() {
		return createtime;
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
	public void setTest_time(String test_time) {
		this.test_time = test_time;
	}
	public void setNcell(double ncell) {
		this.ncell = ncell;
	}
	public void setRsh(double rsh) {
		this.Rsh = rsh;
	}
	public void setRs(double rs) {
		this.Rs = rs;
	}
	public void setFF(double fF) {
		this.FF = fF;
	}
	public void setIsc(double isc) {
		this.Isc = isc;
	}
	public void setVoc(double voc) {
		this.Voc = voc;
	}
	public void setImax(double imax) {
		this.Imax = imax;
	}
	public void setVmax(double vmax) {
		this.Vmax = vmax;
	}
	public void setPmax(double pmax) {
		this.Pmax = pmax;
	}
	public void setEnvTemp(double envTemp) {
		this.EnvTemp = envTemp;
	}
	public void setSurfTemp(double surfTemp) {
		this.SurfTemp = surfTemp;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public void setComputer(String computer) {
		this.Computer = computer;
	}
	public void setF_power(double f_power) {
		this.f_power = f_power;
	}
	public void setIv_path(String iv_path) {
		this.iv_path = iv_path;
	}
	public void setF_ia(String f_ia) {
		this.f_ia = f_ia;
	}
	public void setShiftName(String shiftName) {
		this.ShiftName = shiftName;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public void setEquipcode(String equipcode) {
		this.equipcode = equipcode;
	}
	public void setNmodule(String nmodule) {
		this.nmodule = nmodule;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
		return "FtDataHis [module_code=" + module_code + ", equipcode=" + equipcode + ", createtime=" + createtime
				+ ", Computer=" + Computer + ", ShiftName=" + ShiftName + ", line=" + line + ", test_time=" + test_time
				+ ", ncell=" + ncell + ", Rsh=" + Rsh + ", Rs=" + Rs + ", FF=" + FF + ", Isc=" + Isc + ", Voc=" + Voc
				+ ", Imax=" + Imax + ", Vmax=" + Vmax + ", Pmax=" + Pmax + ", EnvTemp=" + EnvTemp + ", SurfTemp="
				+ SurfTemp + ", op=" + op + ", f_power=" + f_power + ", iv_path=" + iv_path + ", f_ia=" + f_ia
				+ ", nmodule=" + nmodule + ", delop=" + delop + ", deltime=" + deltime + ", effective=" + effective
				+ "]";
	}*/
}
