package com.steam.service;

import com.steam.bean.User;

public interface IAdmin {
	public User adminLoginCheck(String userid, String password);
}
