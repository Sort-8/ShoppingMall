package com.steam.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.steam.dao.ParameterDao;
import com.steam.util.StringUtil;

public class ParamenterDaoTest {
	@Test 
	public void ParamenterDaoTest() {
		List<String> list = new ArrayList<String>();
		list.add("32");
		list.add("33");
		list.add("34");
		System.out.println(StringUtil.ArrayToString(list));
		ParameterDao p = new ParameterDao();
		System.out.println(p.addParameter("22424", "4324", "325", list));
	}
}
