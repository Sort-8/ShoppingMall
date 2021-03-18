package com.steam.util;

import java.util.UUID;

import com.steam.bean.User;

import redis.clients.jedis.Jedis;


public class TokenUtil {
	public static Jedis jedis = null;
	public static String initToken(User user , String token) {
		jedis = new Jedis(Constant.RedisIp , Constant.RedisHost);	//第一个参数为ip地址
		//生成Token令牌
		if(token.equals("")) {
			token = UUID.randomUUID() + "";
		}
		//存到redis数据库
		if(CheckUser(token) == "") {	//若redis中该token不存在
			jedis.set(token, String.valueOf(user.getUserid()));	//第一个参数为Token令牌，第二个参数为该用户的userid;
			jedis.expire(token, 1800);	//过期时间设置为半小时
		}else {
			resetExpire(token);		
		}
		if(jedis != null) {
			jedis.close();
		}
		return token;
	}
	
	public static void deleteToken(String token) {
		jedis = new Jedis(Constant.RedisIp , Constant.RedisHost);	//第一个参数为ip地址
		jedis.del(token);
		if(jedis != null) {
			jedis.close();
		}
	}
	
	public static void resetExpire(String token) {
		jedis = new Jedis(Constant.RedisIp , Constant.RedisHost);	//第一个参数为ip地址
		jedis.expire(token, 1800);	//重置过期时间
		if(jedis != null) {
			jedis.close();
		}
	}
	
	public static String CheckUser(String token) {
		jedis = new Jedis(Constant.RedisIp , Constant.RedisHost);	//第一个参数为ip地址
		String user = jedis.get(token);
		if(user == null) {
			return "";
		}
		if(jedis != null) {
			jedis.close();
		}
		return user;
	}
	
}
