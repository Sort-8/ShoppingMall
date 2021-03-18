package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.History;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class HistoryDao {
	public boolean addHistory(String time , String goodsid , String userid) {
		int flag = 0;
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql1 = "SELECT * FROM " + Constant.HistoryTable + " WHERE goodsid=? AND userid=? ";
		String sql2 = "insert into " + Constant.HistoryTable + "(goodsid,cretime,userid) value(?,?,?)";
		String sql3 = "UPDATE " + Constant.HistoryTable + " SET cretime=? WHERE userid=?";
		try {
			st = DBUtil.getPreparedStatement(sql1);
			st.setString(1, goodsid);
			st.setString(2, userid);
			rs = st.executeQuery();
			if(!rs.next()) {
				st = DBUtil.getPreparedStatement(sql2);
				st.setString(1, goodsid);
				st.setString(2, time);
				st.setString(3, userid);
				flag = st.executeUpdate();
			}else {
				st = DBUtil.getPreparedStatement(sql3);
				st.setString(1, time);
				st.setString(2, userid);
				flag = st.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("购物车更新失败");
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag == 0 ? false : true;
	}
	
	public List<History> showAllHistory(String userid){
		List<History> list = new ArrayList();
		History history ;
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql = "SELECT * FROM " + Constant.HistoryTable + " WHERE userid=? ";
		try {
			st = DBUtil.getPreparedStatement(sql);
			st.setString(1, userid);
			rs = st.executeQuery();
			if(rs.next()) {
				history = new History();
				history.setCretime(rs.getString("cretime"));
				history.setGoodsid(rs.getString("goodsid"));
				history.setHistoryid(rs.getInt("historyid"));
				history.setUserid(rs.getString("userid"));
				list.add(history);
			}
		} catch (SQLException e) {
			System.out.println("历史浏览展示失败");
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
