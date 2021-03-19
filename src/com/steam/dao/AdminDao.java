package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.steam.bean.User;
import com.steam.util.Constant;
import com.steam.util.DBUtil;


public class AdminDao {
	private static User admin =null;
	private static PreparedStatement st = null;
	private static ResultSet rsSet = null;
	private static int rs;
	private static String sql = null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式; 
	List<User> adminList = null;
	
	public int addAdmin(String userid, String username, String passwrod, String power) {
		rs = -1;
		String time = df.format(new Date());// new Date()为获取当前系统时间
		sql = "insert into " +Constant.UserTable+ " value(?,?,?,NULL,?,NULL,NULL,?,NULL,NULL,NULL,NULL,NULL);";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, userid);
			st.setString(2, username);
			st.setString(3, passwrod);
			st.setString(4, time);
			st.setString(5, power);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int delAdminByUserid(String userid) {
		rs = -1;
		sql = "delete from " +Constant.UserTable+ " where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, userid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public List<User> findAdmins() {
		adminList = new ArrayList<User>();
		sql = "select * from " + Constant.UserTable + " order by createtime desc"; //通过cre_time进行排序
																				  //desc表示逆序排序
																			      //asc表示顺序排序
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery(sql);
			if(!rsSet.next()) {
				System.out.println("管理员模块：查询所有管理员数据的结果集为空");
			}else {
				do {
					String power = rsSet.getString("power");
					if(power!=null) {
						if(power.equals("2")) {
						admin = new User();
						admin.setUserid(rsSet.getInt("userid"));
						admin.setUsername(rsSet.getString("username"));
						admin.setPassword(rsSet.getString("password"));
						admin.setPhone(rsSet.getString("regphone"));
						admin.setCreatetime(rsSet.getString("cretime"));
						admin.setModifytime(rsSet.getString("modtime"));
						admin.setHeadimg(rsSet.getString("headimg"));
						admin.setPower(rsSet.getString("power"));
						admin.setAddressid(rsSet.getString("addressid"));
						admin.setShopcartid(rsSet.getString("shopcartid"));
						admin.setAddressid(rsSet.getString("ordersid"));
						admin.setHistoryid(rsSet.getString("historyid"));
						admin.setCommentid(rsSet.getString("commentid"));
						adminList.add(admin);
						}
					}
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminList;
	}
	
	public int updateAdmin(String update_username, String update_password, String userid) {
		rs = -1;
        String time = df.format(new Date());// new Date()为获取当前系统时间
		sql = "update " +Constant.UserTable+ " set username=?,password=?,modifytime=? "
				+ "where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, update_username);
			st.setString(2, update_password);
			st.setString(3, time);
			st.setString(4, userid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
