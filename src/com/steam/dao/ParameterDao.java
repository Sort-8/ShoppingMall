package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.Goods;
import com.steam.bean.Parameter;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class ParameterDao {
	private static int rs;
	private static String sql = null;
	public List<Parameter> getParameter(int parameterid) {
		List<Parameter> list = new ArrayList<Parameter>();
		Parameter parameter;
		PreparedStatement st = null;
		ResultSet  rs = null;
		sql = "select * from " + Constant.ParameterTable +" where parameterid = ?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, parameterid);
			rs = st.executeQuery();
			if(rs.next()) {
				parameter = new Parameter();
				parameter.setParameterid(rs.getInt("parameterid"));
				parameter.setColorAndSize(rs.getString("colorAndSize"));
				parameter.setCount(rs.getInt("count"));
				list.add(parameter);
			}
		} catch (SQLException e) {
			System.out.println("浏览商品详情失败");
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
	public int addParameter(String parameterid, String goodssize, String goodscolor, List<String> countList) {
		rs = -1;
		sql = "insert into "+Constant.ParameterTable+" value(?,?,?,?)";
		System.out.println(goodssize);
		return rs;
	}
}
