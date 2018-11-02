package com.numberONe.entity;

public class MateriaModeForMap {
	/*private String orderno;
	private String moduleCode;
	private String mname;//物料名称
	private String mcode;
	private String sup;//物料厂商
	private String lotNum;//ERP批次
*/	
	private String orderno;
	private String moduleCode;   
	
	private String eva1Bar ;		
	private String eva1Fac ;     
	private String eva1Erp ;     
	
	private String eva2Bar ;     
	private String eva2Fac ;     
	private String eva2Erp ;     
	
	private String evaSmalBar ;  
	private String evaSmalFac ;  
	private String evaSmalErp ;  
	
	private String backBar  ;    
	private String backFac ;     
	private String backErp ;     
	
	private String frameBar;     
	private String frameFac;     
	private String frameErp ;    
	
	private String glassBar  ;   
	private String glassFac  ;   
	private String glassErp  ;   
	
	private String longFrameBar;    
	private String longFrameFac ;   
	private String longFrameErp ;   
	
	private String shortFrameBar ;  
	private String shortFrameFac ;  
	private String shortFrameErp  ;     
	
	private String pourBar ;      
	private String pourFac ;      
	private String pourErp;       
	
	private String interBar ;     
	private String interFac ;     
	private String interErp ;     
	
	private String infallBar;     
	private String infallFac ;    
	private String infallErp ;    
	
	private String boxBar ;      
	private String boxFac ;      
	private String boxErp;       
	
	private String insulatBar ;   
	private String insulatFac ;   
	private String insulatErp ;   
	
	private String baffleBar;     
	private String baffleFac ;    
	private String baffleErp ;
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public String getEva1Bar() {
		return eva1Bar;
	}
	public void setEva1Bar(String eva1Bar) {
		this.eva1Bar = eva1Bar;
	}
	public String getEva1Fac() {
		return eva1Fac;
	}
	public void setEva1Fac(String eva1Fac) {
		this.eva1Fac = eva1Fac;
	}
	public String getEva1Erp() {
		return eva1Erp;
	}
	public void setEva1Erp(String eva1Erp) {
		this.eva1Erp = eva1Erp;
	}
	public String getEva2Bar() {
		return eva2Bar;
	}
	public void setEva2Bar(String eva2Bar) {
		this.eva2Bar = eva2Bar;
	}
	public String getEva2Fac() {
		return eva2Fac;
	}
	public void setEva2Fac(String eva2Fac) {
		this.eva2Fac = eva2Fac;
	}
	public String getEva2Erp() {
		return eva2Erp;
	}
	public void setEva2Erp(String eva2Erp) {
		this.eva2Erp = eva2Erp;
	}
	public String getEvaSmalBar() {
		return evaSmalBar;
	}
	public void setEvaSmalBar(String evaSmalBar) {
		this.evaSmalBar = evaSmalBar;
	}
	public String getEvaSmalFac() {
		return evaSmalFac;
	}
	public void setEvaSmalFac(String evaSmalFac) {
		this.evaSmalFac = evaSmalFac;
	}
	public String getEvaSmalErp() {
		return evaSmalErp;
	}
	public void setEvaSmalErp(String evaSmalErp) {
		this.evaSmalErp = evaSmalErp;
	}
	public String getBackBar() {
		return backBar;
	}
	public void setBackBar(String backBar) {
		this.backBar = backBar;
	}
	public String getBackFac() {
		return backFac;
	}
	public void setBackFac(String backFac) {
		this.backFac = backFac;
	}
	public String getBackErp() {
		return backErp;
	}
	public void setBackErp(String backErp) {
		this.backErp = backErp;
	}
	public String getFrameBar() {
		return frameBar;
	}
	public void setFrameBar(String frameBar) {
		this.frameBar = frameBar;
	}
	public String getFrameFac() {
		return frameFac;
	}
	public void setFrameFac(String frameFac) {
		this.frameFac = frameFac;
	}
	public String getFrameErp() {
		return frameErp;
	}
	public void setFrameErp(String frameErp) {
		this.frameErp = frameErp;
	}
	public String getGlassBar() {
		return glassBar;
	}
	public void setGlassBar(String glassBar) {
		this.glassBar = glassBar;
	}
	public String getGlassFac() {
		return glassFac;
	}
	public void setGlassFac(String glassFac) {
		this.glassFac = glassFac;
	}
	public String getGlassErp() {
		return glassErp;
	}
	public void setGlassErp(String glassErp) {
		this.glassErp = glassErp;
	}
	public String getLongFrameBar() {
		return longFrameBar;
	}
	public void setLongFrameBar(String longFrameBar) {
		this.longFrameBar = longFrameBar;
	}
	public String getLongFrameFac() {
		return longFrameFac;
	}
	public void setLongFrameFac(String longFrameFac) {
		this.longFrameFac = longFrameFac;
	}
	public String getLongFrameErp() {
		return longFrameErp;
	}
	public void setLongFrameErp(String longFrameErp) {
		this.longFrameErp = longFrameErp;
	}
	public String getShortFrameBar() {
		return shortFrameBar;
	}
	public void setShortFrameBar(String shortFrameBar) {
		this.shortFrameBar = shortFrameBar;
	}
	public String getShortFrameFac() {
		return shortFrameFac;
	}
	public void setShortFrameFac(String shortFrameFac) {
		this.shortFrameFac = shortFrameFac;
	}
	public String getShortFrameErp() {
		return shortFrameErp;
	}
	public void setShortFrameErp(String shortFrameErp) {
		this.shortFrameErp = shortFrameErp;
	}
	public String getPourBar() {
		return pourBar;
	}
	public void setPourBar(String pourBar) {
		this.pourBar = pourBar;
	}
	public String getPourFac() {
		return pourFac;
	}
	public void setPourFac(String pourFac) {
		this.pourFac = pourFac;
	}
	public String getPourErp() {
		return pourErp;
	}
	public void setPourErp(String pourErp) {
		this.pourErp = pourErp;
	}
	public String getInterBar() {
		return interBar;
	}
	public void setInterBar(String interBar) {
		this.interBar = interBar;
	}
	public String getInterFac() {
		return interFac;
	}
	public void setInterFac(String interFac) {
		this.interFac = interFac;
	}
	public String getInterErp() {
		return interErp;
	}
	public void setInterErp(String interErp) {
		this.interErp = interErp;
	}
	public String getInfallBar() {
		return infallBar;
	}
	public void setInfallBar(String infallBar) {
		this.infallBar = infallBar;
	}
	public String getInfallFac() {
		return infallFac;
	}
	public void setInfallFac(String infallFac) {
		this.infallFac = infallFac;
	}
	public String getInfallErp() {
		return infallErp;
	}
	public void setInfallErp(String infallErp) {
		this.infallErp = infallErp;
	}
	public String getBoxBar() {
		return boxBar;
	}
	public void setBoxBar(String boxBar) {
		this.boxBar = boxBar;
	}
	public String getBoxFac() {
		return boxFac;
	}
	public void setBoxFac(String boxFac) {
		this.boxFac = boxFac;
	}
	public String getBoxErp() {
		return boxErp;
	}
	public void setBoxErp(String boxErp) {
		this.boxErp = boxErp;
	}
	public String getInsulatBar() {
		return insulatBar;
	}
	public void setInsulatBar(String insulatBar) {
		this.insulatBar = insulatBar;
	}
	public String getInsulatFac() {
		return insulatFac;
	}
	public void setInsulatFac(String insulatFac) {
		this.insulatFac = insulatFac;
	}
	public String getInsulatErp() {
		return insulatErp;
	}
	public void setInsulatErp(String insulatErp) {
		this.insulatErp = insulatErp;
	}
	public String getBaffleBar() {
		return baffleBar;
	}
	public void setBaffleBar(String baffleBar) {
		this.baffleBar = baffleBar;
	}
	public String getBaffleFac() {
		return baffleFac;
	}
	public void setBaffleFac(String baffleFac) {
		this.baffleFac = baffleFac;
	}
	public String getBaffleErp() {
		return baffleErp;
	}
	public void setBaffleErp(String baffleErp) {
		this.baffleErp = baffleErp;
	}
	@Override
	public String toString() {
		return "MateriaModeForMap [orderno=" + orderno + ", moduleCode=" + moduleCode + ", eva1Bar=" + eva1Bar
				+ ", eva1Fac=" + eva1Fac + ", eva1Erp=" + eva1Erp + ", eva2Bar=" + eva2Bar + ", eva2Fac=" + eva2Fac
				+ ", eva2Erp=" + eva2Erp + ", evaSmalBar=" + evaSmalBar + ", evaSmalFac=" + evaSmalFac + ", evaSmalErp="
				+ evaSmalErp + ", backBar=" + backBar + ", backFac=" + backFac + ", backErp=" + backErp + ", frameBar="
				+ frameBar + ", frameFac=" + frameFac + ", frameErp=" + frameErp + ", glassBar=" + glassBar
				+ ", glassFac=" + glassFac + ", glassErp=" + glassErp + ", longFrameBar=" + longFrameBar
				+ ", longFrameFac=" + longFrameFac + ", longFrameErp=" + longFrameErp + ", shortFrameBar="
				+ shortFrameBar + ", shortFrameFac=" + shortFrameFac + ", shortFrameErp=" + shortFrameErp + ", pourBar="
				+ pourBar + ", pourFac=" + pourFac + ", pourErp=" + pourErp + ", interBar=" + interBar + ", interFac="
				+ interFac + ", interErp=" + interErp + ", infallBar=" + infallBar + ", infallFac=" + infallFac
				+ ", infallErp=" + infallErp + ", boxBar=" + boxBar + ", boxFac=" + boxFac + ", boxErp=" + boxErp
				+ ", insulatBar=" + insulatBar + ", insulatFac=" + insulatFac + ", insulatErp=" + insulatErp
				+ ", baffleBar=" + baffleBar + ", baffleFac=" + baffleFac + ", baffleErp=" + baffleErp + "]";
	}    
	
}
