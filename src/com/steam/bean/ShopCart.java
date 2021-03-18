package com.steam.bean;

public class ShopCart {
	public int shopcartid;
	public String goodsid;
	public String count;
	public String type;
	public int getShopcartid() {
		return shopcartid;
	}
	public void setShopcartid(int shopcartid) {
		this.shopcartid = shopcartid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ShopCart [shopcartid=" + shopcartid + ", goodsid=" + goodsid + ", count=" + count + ", type=" + type
				+ "]";
	}
	
}
