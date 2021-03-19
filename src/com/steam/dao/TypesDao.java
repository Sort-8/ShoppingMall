package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.Types;
import com.steam.bean.User;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class TypesDao {
	public List<Types> getAllTypes() {
		List<Types> list = new ArrayList<Types>();
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql = "SELECT * from types";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			while(rs.next()) {
					Types types = new Types(); //实体类
					types.setName(rs.getString("name"));
					types.setType(rs.getString("type"));
					types.setTypeid(rs.getInt("typeid"));
					list.add(types);
			}
		} catch (SQLException e) {
			System.out.println("查询用户失败");
			e.printStackTrace();
		}
		return list;
	}
	
	public static int setCancelIncre() {
		int rs = -1;
		String sql = "ALTER TABLE "+Constant.TypesTable+" AUTO_INCREMENT = 1;";
		PreparedStatement st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int addTypes(String type, String name) {
		setCancelIncre(); //防止插入数据后的主键与最后一条数据的主键相差不为1
		int rs = -1;
		String sql = "insert into " +Constant.TypesTable+ " value(0,'"+type+"','"+name+"')";
		PreparedStatement st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int delTypes(String typeid) {
		setCancelIncre();
		int rs = -1;
		String sql = "delete from "+Constant.TypesTable+" where typeid=?";
		PreparedStatement st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, typeid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int editTypes(String typeid, String type, String name) {
		setCancelIncre();
		int rs = -1;
		String sql = "update " +Constant.TypesTable+ " set type='"+type+"', name='"+name
				+"' where typeid='"+typeid+"'";
		PreparedStatement st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public List<Types> searchTypes(String typeid, String type, String name){
		List<Types> typesList = new ArrayList<Types>();
		String sql = "select * from "+Constant.TypesTable+" where typeid like '"+typeid+"%'"
				+ " and type like '"+type+"%' and name like '"+name+"%' order by typeid desc";
		PreparedStatement st = DBUtil.getPreparedStatement(sql);
		try {
			ResultSet rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("商品类目模块：模糊搜索所有商品类目数据的结果集为空");
			}else {
				do {
					Types types = new Types();
					types.setTypeid(rsSet.getInt(1));
					types.setType(rsSet.getString(2));
					types.setName(rsSet.getString(3));
					typesList.add(types);
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return typesList;
	}
}
