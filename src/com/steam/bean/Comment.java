package com.steam.bean;

public class Comment {
	private int commentid;
	private String goodsid;
	private String username;
	private String createtime;
	private String comment;
	private String status;
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Comment(int commentid, String goodsid, String username, String createtime, String comment,
			String status) {
		super();
		this.commentid = commentid;
		this.goodsid = goodsid;
		this.username = username;
		this.createtime = createtime;
		this.comment = comment;
		this.status = status;
	}
	public Comment() {
		super();
	}
	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", goodsid=" + goodsid + ", username=" + username + ", createtime="
				+ createtime + ", comment=" + comment + ", status=" + status + "]";
	}
}
