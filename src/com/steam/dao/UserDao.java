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

public class UserDao {
	private static User admin =null;
	private static PreparedStatement st = null;
	private static ResultSet rsSet = null;
	private static int rs;
	private static String sql = null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式; 
	List<User> adminList = null;
	List<User> list = null;
	
	public List<User> Login(int userid , String password , String params , String url) {
		List<User> list = new ArrayList<User>();
		PreparedStatement st = null;
		rsSet = null;
		String sql = "SELECT * from " + Constant.UserTable + params;
		st = DBUtil.getPreparedStatement(sql);
		try {
			if("admin".equals(url)) {
				st.setInt(1, userid);
				st.setString(2, password);
				st.setInt(3, userid);
				st.setString(4, password);
			}else if("user".equals(url)) {
				st.setInt(1, userid);
				st.setString(2, password);
			}
			rsSet = st.executeQuery();
			if(rsSet.next()) {
					User user = new User(); //实体类
					user.setAddressid(rsSet.getString("addressid"));
					user.setComment(rsSet.getString("commentid"));
					user.setCreatetime(rsSet.getString("createtime"));
					user.setHeadimg(rsSet.getString("headimg"));
					user.setHistoryid(rsSet.getString("historyid"));
					user.setModifytime(rsSet.getString("modifytime"));
					user.setOdersid(rsSet.getString("ordersid"));
					user.setPassword(rsSet.getString("password"));
					user.setPhone(rsSet.getString("phone"));
					user.setPower(rsSet.getString("power"));
					user.setShopcatid(rsSet.getString("shopcartid"));
					user.setUserid(rsSet.getInt("userid"));
					user.setUsername(rsSet.getString("username"));
					user.setSex(rsSet.getString("sex"));
					user.setEmail(rsSet.getString("email"));
					user.setStatus(rsSet.getString("Status"));
					list.add(user);
			}
			else {
				System.out.println("查询不到符合条件的用户");
			}
		} catch (SQLException e) {
			System.out.println("查询用户失败");
			e.printStackTrace();
		}
		return list;
	}
	
	public int addAdmin(int userid, String username, String passwrod, String power) {
		rs = -1;
		String time = df.format(new Date());// new Date()为获取当前系统时间
		sql = "insert into " +Constant.UserTable+ " value(?,?,?,NULL,?,NULL,NULL,?,NULL,NULL,NULL,NULL,NULL);";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, userid);
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
	
	public int delAdminByUserid(int userid) {
		rs = -1;
		sql = "delete from " +Constant.UserTable+ " where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, userid);
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
						if(power.equals("2")||power.equals("3")) {
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
						admin.setShopcatid(rsSet.getString("shopcartid"));
						admin.setOdersid(rsSet.getString("ordersid"));
						admin.setHistoryid(rsSet.getString("historyid"));
						admin.setComment(rsSet.getString("commentid"));
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
	
	public int updateAdmin(String update_username, String update_password, int userid) {
		rs = -1;
        String time = df.format(new Date());// new Date()为获取当前系统时间
		sql = "update " +Constant.UserTable+ " set username=?,password=?,modifytime=? "
				+ "where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, update_username);
			st.setString(2, update_password);
			st.setString(3, time);
			st.setInt(4, userid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public User getUser(int userid) {
		PreparedStatement st = null;
		User user = new User(); //实体类
		rsSet = null;
		String sql = "SELECT * from " + Constant.UserTable + " where userid = ?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, userid);
			rsSet = st.executeQuery();
			if(rsSet.next()) {
				user.setAddressid(rsSet.getString("addressid"));
				user.setComment(rsSet.getString("commentid"));
				user.setCreatetime(rsSet.getString("createtime"));
				user.setHeadimg(rsSet.getString("headimg"));
				user.setHistoryid(rsSet.getString("historyid"));
				user.setModifytime(rsSet.getString("modifytime"));
				user.setOdersid(rsSet.getString("ordersid"));
				user.setPassword(rsSet.getString("password"));
				user.setPhone(rsSet.getString("phone"));
				user.setPower(rsSet.getString("power"));
				user.setShopcatid(rsSet.getString("shopcartid"));
				user.setUserid(rsSet.getInt("userid"));
				user.setUsername(rsSet.getString("username"));
				user.setSex(rsSet.getString("sex"));
				user.setEmail(rsSet.getString("email"));
				user.setStatus(rsSet.getString("Status"));
			}
			else {
				System.out.println("查询不到符合条件的用户");
			}
		} catch (SQLException e) {
			System.out.println("查询用户失败");
			e.printStackTrace();
		}
		return user;
	}

	
	public List<User> findAllUser(){
		list = new ArrayList<User>();
		User user = null;
		sql = "select * from "+Constant.UserTable+" where power='1'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("用户模块：查询所有用户数据的结果集为空");
			}else {
				do {
					user = new User();
					user.setAddressid(rsSet.getString("addressid"));
					user.setComment(rsSet.getString("commentid"));
					user.setCreatetime(rsSet.getString("createtime"));
					user.setHeadimg(rsSet.getString("headimg"));
					user.setHistoryid(rsSet.getString("historyid"));
					user.setModifytime(rsSet.getString("modifytime"));
					user.setOdersid(rsSet.getString("odersid"));
					user.setPassword(rsSet.getString("password"));
					user.setPhone(rsSet.getString("phone"));
					user.setPower(rsSet.getString("power"));
					user.setShopcatid(rsSet.getString("shopcatid"));
					user.setUserid(rsSet.getInt("userid"));
					user.setUsername(rsSet.getString("username"));
					user.setSex(rsSet.getString("sex"));
					user.setStatus(rsSet.getString("status"));
					user.setEmail(rsSet.getString("email"));
					list.add(user);
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<User> findAllAdmin(){
		List<User> list = new ArrayList<User>();
		User user = null;
		sql = "select * from "+Constant.UserTable+" where power='2'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("用户模块：查询所有用户数据的结果集为空");
			}else {
				do {
					user = new User();
					user.setAddressid(rsSet.getString("addressid"));
					user.setComment(rsSet.getString("commentid"));
					user.setCreatetime(rsSet.getString("createtime"));
					user.setHeadimg(rsSet.getString("headimg"));
					user.setHistoryid(rsSet.getString("historyid"));
					user.setModifytime(rsSet.getString("modifytime"));
					user.setOdersid(rsSet.getString("odersid"));
					user.setPassword(rsSet.getString("password"));
					user.setPhone(rsSet.getString("phone"));
					user.setPower(rsSet.getString("power"));
					user.setShopcatid(rsSet.getString("shopcatid"));
					user.setUserid(rsSet.getInt("userid"));
					user.setUsername(rsSet.getString("username"));
					user.setSex(rsSet.getString("sex"));
					user.setStatus(rsSet.getString("status"));
					user.setEmail(rsSet.getString("email"));
					list.add(user);
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<User> selectUser(String username, String sex, String phone) {
		list = new ArrayList<User>();
		User user = null;
		sql = "select * from "+Constant.UserTable+" where username like '"+username+"%' "
				+ "and sex like'"+sex+"%' and phone like'"+phone+"%'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("用户模块：查询所有用户数据的结果集为空");
			}else {
				do {
					user = new User();
					user.setAddressid(rsSet.getString("addressid"));
					user.setComment(rsSet.getString("commentid"));
					user.setCreatetime(rsSet.getString("createtime"));
					user.setHeadimg(rsSet.getString("headimg"));
					user.setHistoryid(rsSet.getString("historyid"));
					user.setModifytime(rsSet.getString("modifytime"));
					user.setOdersid(rsSet.getString("odersid"));
					user.setPassword(rsSet.getString("password"));
					user.setPhone(rsSet.getString("phone"));
					user.setPower(rsSet.getString("power"));
					user.setShopcatid(rsSet.getString("shopcatid"));
					user.setUserid(rsSet.getInt("userid"));
					user.setUsername(rsSet.getString("username"));
					user.setSex(rsSet.getString("sex"));
					user.setStatus(rsSet.getString("status"));
					user.setEmail(rsSet.getString("email"));
					list.add(user);
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int editUserStatus(int userid, String status) {
		rs = -1;
		sql = "update "+Constant.UserTable+" set status='"+status+"' where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, userid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public List<User> findadminBaseInfoByUserid(int userid) {
		adminList = new ArrayList<User>();
		User user = null;
		sql = "select * from "+Constant.UserTable+" where userid=? ";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, userid);
			rsSet = st.executeQuery();
			if(rsSet.next()) {
				user = new User();
				user.setUsername(rsSet.getString("username"));
				user.setEmail(rsSet.getString("email"));
				user.setPhone(rsSet.getString("phone"));
				adminList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminList;
	}

	public int editAdminBaseInfo(int userid, String username, String phone, String email) {
		rs = -1;
		sql = "update "+Constant.UserTable+" set username=?,phone=?,email=? where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, username);
			st.setString(2, phone);
			st.setString(3, email);
			st.setInt(4, userid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public User selectAdminByUseridAndPassword(int userid, String password) {
		User user = null;
		sql = "select * from "+Constant.UserTable+" where userid=? and password=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1,userid);
			st.setString(2, password);
			rsSet = st.executeQuery();
			if(rsSet.next()) {
				user = new User();
				user.setUserid(rsSet.getInt("userid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public int editAdminPassword(int userid, String password) {
		rs = -1;
		sql = "update "+Constant.UserTable+" set password=? where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, password);
			st.setInt(2, userid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public List<User> selectAdmin(int userid, String username, String phone) {
		adminList = new ArrayList<User>();
		User user = null;
		sql = "select * from "+Constant.UserTable+" where userid like '?%' and"
				+ " username like '"+username+"%' and phone like '"+phone+"%'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, userid);
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("用户模块：查询所有用户数据的结果集为空");
			}else {
				do {
					user = new User();
					user.setCreatetime(rsSet.getString("createtime"));
					user.setModifytime(rsSet.getString("modifytime"));
					user.setPhone(rsSet.getString("phone"));
					user.setUserid(rsSet.getInt("userid"));
					user.setUsername(rsSet.getString("username"));
					user.setSex(rsSet.getString("sex"));
					user.setStatus(rsSet.getString("status"));
					user.setEmail(rsSet.getString("email"));
					adminList.add(user);
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminList;
	}

	public User VerifyAdminUserid(int userid) {
		User user = null;
		sql = "select * from "+Constant.UserTable+" where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, userid);
			rsSet = st.executeQuery();
			if(rsSet.next()) {
				user = new User();
				user.setUserid(rsSet.getInt("userid"));
			}else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public int addAdmin(int userid, String password) {
		rs = -1;
		sql = "insert into "+Constant.UserTable+" value("
				+ "?,null,?,null,null,null,?,null,null,'2',null,null,null,null,null,null)";
		String time = df.format(new Date());
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, userid);
			st.setString(2, password);
			st.setString(3, time);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int delAdminByuserid(int userid) {
		rs = -1;
		sql = "delete from "+Constant.UserTable+" where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, userid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public boolean updateUser(int userid ,String username, String sex, String phone, String email) {
		rs = 0;
		sql = "update " + Constant.UserTable + " SET username = ? , sex = ? , phone = ? , email = ? where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, username);
			st.setString(2, sex);
			st.setString(3, phone);
			st.setString(4, email);
			st.setInt(5, userid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs == 0 ? false : true;
	}
	
	public boolean updateAddress(int userid , String addressid) {
		rs = 0;
		sql = "update " + Constant.UserTable + " SET addressid = ? where userid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, addressid);
			st.setInt(2, userid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs == 0 ? false : true;
	}
}
