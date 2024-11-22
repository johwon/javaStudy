package com.kh.java.model;

public class CustomerVO {
	private int id;
	private String name;
	private String phone;
	private String address;
	private String membership;
	private int point;

	public CustomerVO() {}

	public CustomerVO(int id, String name, String phone, String address, String membership, int point) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.membership = membership;
		this.point = point;
	}

	public CustomerVO(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", membership="
				+ membership + ", point=" + point + "]";
	}
}
