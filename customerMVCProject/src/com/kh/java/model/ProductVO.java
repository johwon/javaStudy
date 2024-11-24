package com.kh.java.model;

public class ProductVO {
    private String no; 		//상품번호 pk
    private String name;	//상품이름
    private int price;		//가격
    
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductVO(String no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductVO [no=" + no + ", name=" + name + ", price=" + price + "]";
	}
}
