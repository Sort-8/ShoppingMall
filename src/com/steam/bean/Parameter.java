package com.steam.bean;

public class Parameter {
	private int parameterid;
	private String colorAndSize;
	private int count;
	public int getParameterid() {
		return parameterid;
	}
	public void setParameterid(int parameterid) {
		this.parameterid = parameterid;
	}
	public String getColorAndSize() {
		return colorAndSize;
	}
	public void setColorAndSize(String colorAndSize) {
		this.colorAndSize = colorAndSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Parameter [parameterid=" + parameterid + ", ColorAndSize=" + colorAndSize + " , count=" + count
				+ "]";
	}
	
}
