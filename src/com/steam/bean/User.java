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
	private String shopcatid;
	private String odersid;
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
	public String getShopcatid() {
		return shopcatid;
	}
	public void setShopcatid(String shopcatid) {
		this.shopcatid = shopcatid;
	}
	public String getOdersid() {
		return odersid;
	}
	public void setOdersid(String odersid) {
		this.odersid = odersid;
	}
	public String getHistoryid() {
		return historyid;
	}
	public void setHistoryid(String historyid) {
		this.historyid = historyid;
	}
	public String getComment() {
		return commentid;
	}
	public void setComment(String comment) {
		this.commentid = comment;
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
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", createtime=" + createtime + ", modifytime=" + modifytime + ", headimg=" + headimg + ", power="
				+ power + ", addressid=" + addressid + ", shopcatid=" + shopcatid + ", odersid=" + odersid
				+ ", historyid=" + historyid + ", commentid=" + commentid + ", sex=" + sex + ", email=" + email
				+ ", status=" + status + "]";
	}
	
	
}
