package com.steam.bean;

public class Address {
	private int addressid;
	private String name;
	private String phone;
	private String address;
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
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
	@Override
	public String toString() {
		return "address [addressid=" + addressid + ", name=" + name + ", phone=" + phone + ", adress=" + address + "]";
	}
	
}
