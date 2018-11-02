package com.numberONe.entity;

public class Document {
	private int id;
	private String filename;
	private String dname;
	private String dnumber;
	private String filetype;
	private String remark;
	private String fileurl;
	private String uploadtime;
	public Document() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDnumber() {
		return dnumber;
	}
	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", filename=" + filename + ", dname=" + dname + ", dnumber=" + dnumber
				+ ", filetype=" + filetype + ", remark=" + remark + ", fileurl=" + fileurl + ", uploadtime="
				+ uploadtime + "]";
	}
	
	
}
