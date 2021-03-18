package com.steam.bean;

public class Orders {
	private int ordersid;
	private String userid = "userid";
	private String goodsid;
	private String createtime = "createtime";
	private String count = "count";
	private String price = "price";
	private String status = "status";
	private String type = "type";
	private String payid;
	private String details;
	private String address;
	public int getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPayid() {
		return payid;
	}
	public void setPayid(String payid) {
		this.payid = payid;
	}
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Orders [ordersid=" + ordersid + ", userid=" + userid + ", goodsid=" + goodsid + ", createtime="
				+ createtime + ", count=" + count + ", price=" + price + ", status=" + status + ", type=" + type
				+ ", payid=" + payid + ", details=" + details + ", address=" + address + "]";
	}
	
}
