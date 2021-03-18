package com.steam.bean;

public class Types {
	private int typeid;
	private String type;
	private String name;
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Types [typeid=" + typeid + ", type=" + type + ", name=" + name + "]";
	}
	
}
