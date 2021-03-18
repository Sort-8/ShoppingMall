package com.steam.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.steam.bean.User;
import com.steam.dao.UserDao;

public class UserDaoTest {
	UserDao adminDao = null;
	User admin = null;
	int rs = -1;
	List<User> list = null;
	
	@Test
	public void loginCheckTest() {
		adminDao = new UserDao();
//		admin = adminDao.findadminByUseridAndPassword("12312", "1234");
		if(admin!=null) {
			System.out.println(admin);
		}else {
			System.out.println("admin is null");
		}

	}
	
	@Test
	public void findAllUserTest() {
		adminDao = new UserDao();
		list = adminDao.findAllUser();
		System.out.println(list);
	}
	
	@Test
	public void findAllAdminTest() {
		adminDao = new UserDao();
		list = adminDao.findAllAdmin();
		System.out.println(list);
	}
	
	@Test
	public void searchUserTestTest() {
		adminDao = new UserDao();
		list = adminDao.selectUser("321", "", "");
		System.out.println(list);
	}
	
	@Test
	public void editUserStatudTest() {
		adminDao = new UserDao();
//		rs = adminDao.editUserStatus("12", "已审核");
//		rs = adminDao.editUserStatus("12", "未审核");
		System.out.println(rs);
	}
}
