package com.steam.test;

import org.junit.Test;

import com.steam.dao.TypesDao;

public class TypesTest {
	@Test 
	public void addTypesTest() {
		TypesDao typesDao = new TypesDao();
//		System.out.println(typesDao.addTypes("123", "543"));
	}
	
	@Test
	public void setIncreTest() {
		TypesDao typesDao = new TypesDao();
//		System.out.println(typesDao.setCancelIncre());
	}
	
	@Test
	public void delTypesTest() {
		TypesDao typesDao = new TypesDao();
//		System.out.println(typesDao.delTypes("1022"));
	}

	@Test
	public void updateTypesTest() {
		TypesDao typesDao = new TypesDao();
//		System.out.println(typesDao.editTypes("1234","132","543"));
	}
	
	@Test
	public void searchTypesTest() {
		TypesDao typesDao = new TypesDao();
//		System.out.println(typesDao.searchTypes("100","",""));
	}
}
