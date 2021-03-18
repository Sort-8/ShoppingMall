package com.steam.bean;

public class Goods {
	private int goodsid;	//商品id
	private String title;	//标题
	private String typeid;	//类型
	private int count;		//库存
	private int parameterid;	//商品id
	private String img;		//图片url
	private String detailsimg;		//图片url
	private float price;	//当前价格
	private float original;	//原价
	private float discount;	//打折
	private String paycount;	//销量
	private int collectcount;
	private int sale_count;
	private String cre_time;
	private String mod_time;
	private String allCount; //总记录条数
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String type) {
		this.typeid = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getParameterid() {
		return parameterid;
	}
	public void setParameterid(int parameterid) {
		this.parameterid = parameterid;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getOriginal() {
		return original;
	}
	public void setOriginal(float original) {
		this.original = original;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getPaycount() {
		return paycount;
	}
	public void setPaycount(String paycount) {
		this.paycount = paycount;
	}
	public int getCollectcount() {
		return collectcount;
	}
	public void setCollectcount(int collectcount) {
		this.collectcount = collectcount;
	}
	public int getSale_count() {
		return sale_count;
	}
	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}
	public String getCre_time() {
		return cre_time;
	}
	public void setCre_time(String cre_time) {
		this.cre_time = cre_time;
	}
	public String getMod_time() {
		return mod_time;
	}
	public void setMod_time(String mod_time) {
		this.mod_time = mod_time;
	}
	
	public String getAllCount() {
		return allCount;
	}
	public void setAllCount(String allCount) {
		this.allCount = allCount;
	}
	
	public String getDetailsimg() {
		return detailsimg;
	}
	public void setDetailsimg(String detailsimg) {
		this.detailsimg = detailsimg;
	}
	@Override
	public String toString() {
		return "Goods [goodsid=" + goodsid + ", title=" + title + ", typeid=" + typeid + ", count=" + count
				+ ", parameterid=" + parameterid + ", img=" + img + ", detailsimg=" + detailsimg + ", price=" + price
				+ ", original=" + original + ", discount=" + discount + ", paycount=" + paycount + ", collectcount="
				+ collectcount + ", sale_count=" + sale_count + ", cre_time=" + cre_time + ", mod_time=" + mod_time
				+ ", allCount=" + allCount + "]";
	}
	
}
