package com.steam.test;

import org.junit.Test;

import com.steam.util.TokenUtil;

public class TokenUtilTest {
	@Test
	public void TokenTest() {
		System.out.println("token=="+TokenUtil.CheckUser("ea2d5e99-5f2f-48d9-8f53-9bc20428af09"));
	}
}
