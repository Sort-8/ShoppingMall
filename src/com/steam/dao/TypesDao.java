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
}
