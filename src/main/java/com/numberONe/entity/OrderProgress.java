package com.numberONe.entity;

import java.io.Serializable;

public class OrderProgress  implements Serializable {
	private static final long serialVersionUID = 1L;


	
	private String order_no;//�������
	private String module_code;//�������
	private String curStatus;//״̬�����ã���
	private Integer process_1_status;//��Ƭ״̬
	private Integer process_2_status;//ƴ��״̬
	private Integer process_3_status;//ǰ��EL״̬
	private Integer process_4_status;//ѹ��״̬
	private Integer process_5_status;//����״̬
	private Integer process_6_status;//�е�EL״̬
	private Integer process_7_status;//װ��״̬
	private Integer process_8_status;//���״̬
	private Integer process_9_status;//��ѹ����״̬
	private Integer process_10_status;//IV����״̬
	private Integer process_11_status;//���EL״̬
	private Integer process_12_status;//FQC״̬
	private Integer process_13_status;//PKG״̬
	private Integer process_14_status;//���״̬
	public OrderProgress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderProgress(String order_no,String module_code,String curStatus,Integer process_1_status,Integer process_2_status,
			Integer process_3_status,Integer process_4_status,Integer process_5_status,Integer process_6_status,
			Integer process_7_status,Integer process_8_status,Integer process_9_status,Integer process_10_status,
			Integer process_11_status,Integer process_12_status,Integer process_13_status,Integer process_14_status) {
		super();
		this.order_no=order_no;
		this.module_code=module_code;
		this.curStatus=curStatus;
		this.process_1_status=process_1_status;
		this.process_2_status=process_2_status;
		this.process_3_status=process_3_status;
		this.process_4_status=process_4_status;
		this.process_5_status=process_5_status;
		this.process_6_status=process_6_status;
		this.process_7_status=process_7_status;
		this.process_8_status=process_8_status;
		this.process_9_status=process_9_status;
		this.process_10_status=process_10_status;
		this.process_11_status=process_11_status;
		this.process_12_status=process_12_status;
		this.process_13_status=process_13_status;
		this.process_14_status=process_14_status;
	}
	
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getModule_code() {
		return module_code;
	}
	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}
	public String getCurStatus() {
		return curStatus;
	}
	public void setCurStatus(String curStatus) {
		this.curStatus = curStatus;
	}
	public Integer getProcess_1_status() {
		return process_1_status;
	}
	public void setProcess_1_status(Integer process_1_status) {
		this.process_1_status = process_1_status;
	}
	public Integer getProcess_2_status() {
		return process_2_status;
	}
	public void setProcess_2_status(Integer process_2_status) {
		this.process_2_status = process_2_status;
	}
	public Integer getProcess_3_status() {
		return process_3_status;
	}
	public void setProcess_3_status(Integer process_3_status) {
		this.process_3_status = process_3_status;
	}
	public Integer getProcess_4_status() {
		return process_4_status;
	}
	public void setProcess_4_status(Integer process_4_status) {
		this.process_4_status = process_4_status;
	}
	public Integer getProcess_5_status() {
		return process_5_status;
	}
	public void setProcess_5_status(Integer process_5_status) {
		this.process_5_status = process_5_status;
	}
	public Integer getProcess_6_status() {
		return process_6_status;
	}
	public void setProcess_6_status(Integer process_6_status) {
		this.process_6_status = process_6_status;
	}
	public Integer getProcess_7_status() {
		return process_7_status;
	}
	public void setProcess_7_status(Integer process_7_status) {
		this.process_7_status = process_7_status;
	}
	public Integer getProcess_8_status() {
		return process_8_status;
	}
	public void setProcess_8_status(Integer process_8_status) {
		this.process_8_status = process_8_status;
	}
	public Integer getProcess_9_status() {
		return process_9_status;
	}
	public void setProcess_9_status(Integer process_9_status) {
		this.process_9_status = process_9_status;
	}
	public Integer getProcess_10_status() {
		return process_10_status;
	}
	public void setProcess_10_status(Integer process_10_status) {
		this.process_10_status = process_10_status;
	}
	public Integer getProcess_11_status() {
		return process_11_status;
	}
	public void setProcess_11_status(Integer process_11_status) {
		this.process_11_status = process_11_status;
	}
	public Integer getProcess_12_status() {
		return process_12_status;
	}
	public void setProcess_12_status(Integer process_12_status) {
		this.process_12_status = process_12_status;
	}
	public Integer getProcess_13_status() {
		return process_13_status;
	}
	public void setProcess_13_status(Integer process_13_status) {
		this.process_13_status = process_13_status;
	}
	public Integer getProcess_14_status() {
		return process_14_status;
	}
	public void setProcess_14_status(Integer process_14_status) {
		this.process_14_status = process_14_status;
	}
	@Override
	public String toString() {
		return "OrderProcess [order_no=" + order_no + ", module_code=" + module_code + ", CurStatus=" + curStatus
				+ ", process_1_status=" + process_1_status + ", process_2_status=" + process_2_status
				+ ", process_3_status=" + process_3_status + ", process_4_status=" + process_4_status
				+ ", process_5_status=" + process_5_status + ", process_6_status=" + process_6_status
				+ ", process_7_status=" + process_7_status + ", process_8_status=" + process_8_status
				+ ", process_9_status=" + process_9_status + ", process_10_status=" + process_10_status
				+ ", process_11_status=" + process_11_status + ", process_12_status=" + process_12_status
				+ ", process_13_status=" + process_13_status + ", process_14_status=" + process_14_status + "]";
	}

	

}
