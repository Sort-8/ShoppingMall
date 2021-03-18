package com.steam.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.steam.util.StringUtil;

public class StringUtilTest {
	@Test
	public void StringUtilTest() {
		List<String> list = new ArrayList<String>();
		list.add("32");
		list.add("33");
		list.add("34");
		String str = StringUtil.ArrayToString(list);
		System.out.println(str);
		
		System.out.println(StringUtil.StringToArray(str));
	}
}
