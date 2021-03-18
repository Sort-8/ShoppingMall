package com.steam.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.steam.bean.User;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class SalesDao {
	private static User admin =null;
	private static PreparedStatement st = null;
	private static ResultSet rsSet = null;
	private static int rs;
	private static String sql = null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式; 
	
	public float getAllSalesByOrders() {
		float sum = 0;
		sql = "select * from "+Constant.OrderTable;
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(rsSet.next()) {
				do {
					if(!"待付款".equals(rsSet.getString("status"))) {
						sum += rsSet.getFloat("price");
					}
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
