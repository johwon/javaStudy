package com.kh.java.model;

public class OrdersVO {
    private String no;		//주문번호 PK
	private int c_id;		//주문고객아이디 CUSTOMER FK
	private String p_no;	//주문상품번호 PRODUCT FK 
	private int amount;		//주문수량
	
	public OrdersVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrdersVO(String no, int c_id, String p_no, int amount) {
		super();
		this.no = no;
		this.c_id = c_id;
		this.p_no = p_no;
		this.amount = amount;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "OrdersVO [no=" + no + ", c_id=" + c_id + ", p_no=" + p_no + ", amount=" + amount + "]";
	}
	
}
