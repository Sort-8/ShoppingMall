package com.steam.service.serviceimp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.steam.bean.User;
import com.steam.dao.UserDao;
import com.steam.service.IUser;
import com.steam.util.TokenUtil;

import redis.clients.jedis.Jedis;

public class UserServiceImp implements IUser{
	private UserDao userDao;
	public List UserLogin(String userid , String password , String token , String url) {
		userDao = new UserDao();
		String params = "";
		if("admin".equals(url)) {
			params += "  where (userid=? and password=? and power='2') or (userid=? and password=? and power='3') ";
		}else if("user".equals(url)) {
			params += "  where userid=? and password=?";
		}
		List<User> list = userDao.Login(Integer.parseInt(userid) , password , params , url);
		List lists = new ArrayList();
		if(!list.isEmpty()) {	//登陆成功
			User user = list.get(0);
			token = TokenUtil.initToken(user , token) + "";
			lists.add(token);
			lists.add(user.getPower());
			lists.add(user.getUsername());
		}else {
			System.out.println("登陆失败");
			lists.add("");
		}
		return lists;
	}
	
	public User getUser(String userid) {
		userDao = new UserDao();
		return userDao.getUser(Integer.parseInt(userid));
	}
	
	public List<User> getAllUser(){
		userDao = new UserDao();
		return userDao.findAllUser();
	}
	
	public List<User> getAllAdmin(){
		userDao = new UserDao();
		return userDao.findAllAdmin();
	}

	public List<User> searchUser(String username, String sex, String phone) {
		userDao = new UserDao();
		return userDao.selectUser(username,sex,phone);
	}

	public boolean editUserStatus(String userid, String status) {
		userDao = new UserDao();
		if(userDao.editUserStatus(Integer.parseInt(userid), status)!=-1) {
			return true;
		}else {
			return false;
		}
	}

	public List<User> getAdminBaseInfo(String userid) {
		userDao = new UserDao();
		return userDao.findadminBaseInfoByUserid(Integer.parseInt(userid));
	}

	public boolean editAdminBaseInfo(String userid, String username, String phone, String email) {
		userDao = new UserDao();
		if(userDao.editAdminBaseInfo(Integer.parseInt(userid),username,phone,email)!=-1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean verifyPassword(String userid, String password) {
		userDao = new UserDao();
		if(userDao.selectAdminByUseridAndPassword(Integer.parseInt(userid),password)!=null) {
			return true;
		}else {
			return false;
		}
	}

	public boolean editAdminPassword(String userid, String password) {
		userDao = new UserDao();
		if(userDao.editAdminPassword(userid, password)!=-1) {
			return true;
		}else {
			return false;
		}
	}

	public List<User> searchAdmin(String userid, String username, String phone) {
		userDao = new UserDao();
		userid = userid == null ? "" : userid;
		username = username == null ? "" : username;
		phone = phone == null ? "" : phone;
		return userDao.selectAdmin(userid, username, phone);
	}

	public boolean VerifyUserid(String userid) {
		userDao = new UserDao();
		if(userDao.VerifyAdminUserid(Integer.parseInt(userid))==null) {
			return true;
		}else {
			return false;
		}
	}

	public boolean addAdmin(String userid, String password) {
		userDao = new UserDao();
		if(userDao.addAdmin(Integer.parseInt(userid), password)!=-1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean delAdmin(String userid) {
		userDao = new UserDao();
		if(userDao.delAdminByuserid(Integer.parseInt(userid))!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean updateUser(String token , String username , String sex , String phone , String email) {
		userDao = new UserDao();
		String userid = TokenUtil.CheckUser(token);
		return userDao.updateUser(Integer.parseInt(userid) , username , sex , phone , email);
	}
	
	public boolean updateAddress(String token , String addressid) {
		userDao = new UserDao();
		String userid = TokenUtil.CheckUser(token);
		return userDao.updateAddress(Integer.parseInt(userid) , addressid);
	}
}
