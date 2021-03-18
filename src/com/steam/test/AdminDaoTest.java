package com.steam.test;

import org.junit.Test;

import com.steam.dao.AdminDao;

public class AdminDaoTest {
	int rs = -1;
	AdminDao adminDao = null;
	@Test
	public void delAdmin() {
		adminDao = new AdminDao();
		rs = adminDao.delAdminByUserid("12");
		System.out.println(rs);
	}
	
	@Test
	public void updateAdmin() {
		adminDao = new AdminDao();
		rs = adminDao.updateAdmin("好嗨哦", "1234", "12312");
		System.out.println(rs);
	}
	
	@Test
	public void addAdmin() {
		adminDao = new AdminDao();
		rs = adminDao.addAdmin("12","admi1n3", "12234", "1");
		System.out.println(rs);
	}
}
