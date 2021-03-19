package com.steam.bean;

public class User {
	private int userid;
	private String username;
	private String password;
	private String phone;
	private String createtime;
	private String modifytime;
	private String headimg;
	private String power;
	private String addressid;
	private String shopcartid;
	private String ordersid;
	private String historyid;
	private String commentid;
	private String sex;
	private String email;
	private String status;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getShopcartid() {
		return shopcartid;
	}
	public void setShopcartid(String shopcartid) {
		this.shopcartid = shopcartid;
	}
	public String getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}
	public String getHistoryid() {
		return historyid;
	}
	public void setHistoryid(String historyid) {
		this.historyid = historyid;
	}
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User(int userid, String username, String password, String phone, String createtime, String modifytime,
			String headimg, String power, String addressid, String shopcartid, String ordersid, String historyid,
			String commentid, String sex, String email, String status) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.headimg = headimg;
		this.power = power;
		this.addressid = addressid;
		this.shopcartid = shopcartid;
		this.ordersid = ordersid;
		this.historyid = historyid;
		this.commentid = commentid;
		this.sex = sex;
		this.email = email;
		this.status = status;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", createtime=" + createtime + ", modifytime=" + modifytime + ", headimg=" + headimg + ", power="
				+ power + ", addressid=" + addressid + ", shopcartid=" + shopcartid + ", ordersid=" + ordersid
				+ ", historyid=" + historyid + ", commentid=" + commentid + ", sex=" + sex + ", email=" + email
				+ ", status=" + status + ", getUserid()=" + getUserid() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getPhone()=" + getPhone() + ", getCreatetime()="
				+ getCreatetime() + ", getModifytime()=" + getModifytime() + ", getHeadimg()=" + getHeadimg()
				+ ", getPower()=" + getPower() + ", getAddressid()=" + getAddressid() + ", getShopcartid()="
				+ getShopcartid() + ", getOrdersid()=" + getOrdersid() + ", getHistoryid()=" + getHistoryid()
				+ ", getCommentid()=" + getCommentid() + ", getSex()=" + getSex() + ", getEmail()=" + getEmail()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
