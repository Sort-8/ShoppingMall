package com.steam.test;

import org.junit.Test;

import com.steam.util.IDUtil;

public class IDUtilTest {
	IDUtil id = null;
	@Test
	public void getOrderIDTest(){
		System.out.println(IDUtil.getGoodsCode(null));
	}
}
