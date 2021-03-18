package com.steam.bean;

public class History {
	private int historyid;
	private String goodsid;
	private String cretime;
	private String userid;
	public int getHistoryid() {
		return historyid;
	}
	public void setHistoryid(int historyid) {
		this.historyid = historyid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getCretime() {
		return cretime;
	}
	public void setCretime(String cretime) {
		this.cretime = cretime;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "History [historyid=" + historyid + ", goodsid=" + goodsid + ", cretime=" + cretime + ", userid="
				+ userid + "]";
	}
	
	
}
