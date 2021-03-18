package com.steam.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.steam.bean.User;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class WaitdoDao {
	private static PreparedStatement st = null;
	private static ResultSet rsSet = null;
	private static int rs;
	private static String sql = null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式; 
	
	public int getWait(String str, String table) {
		int sum = 0;
		sql = "select * from "+table;
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(rsSet.next()) {
				do {
					if(!str.equals(rsSet.getString("status"))) {
						sum += 1;
					}
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	public int getWaitComment() {
		return getWait("未审核",Constant.CommentTable);
	}
	
	public int getWaitUser() {
		return getWait("未审核",Constant.UserTable);
	}
	
	public int getWaitOrders() {
		return getWait("待发货",Constant.GoodsTable);
	}
	
	
}
