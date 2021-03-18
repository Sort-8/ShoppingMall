package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.Address;
import com.steam.bean.Comment;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class AddressDao {
	PreparedStatement st = null;
	ResultSet rs = null;
	public List<Address> showAllAddress(String userid){
		Address address = null;
		List list = new ArrayList<Address>();
		String sql = "select * from "+Constant.AddressTable + " ";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			if(rs.next()) {
				do {
					address = new Address();
					address.setAddressid(rs.getInt("addressid"));
					address.setAddress(rs.getString("address"));
					address.setName(rs.getString("name"));
					address.setPhone(rs.getString("phone"));
					list.add(address);
				}while(rs.next());
			}else {
				System.out.println("地址模块：查找所有地址的结果集为空");
			}
		} catch (SQLException e) {
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
	
	public boolean editAddress(int addressid , String name , String phone , String address) {
		int flag = 0 ;
		String sql = "update "+Constant.AddressTable + " SET name=? , phone=? , address=? WHERE addressid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, name);
			st.setString(2, phone);
			st.setString(3, address);
			st.setInt(4, addressid);
			flag = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag == 0 ? false : true;
	}
	
	public boolean addAddress(String name , String phone , String address) {
		int flag = 0 ;
		String sql = "insert into  "+Constant.AddressTable + "(name,phone,address) value(?,?,?)";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, name);
			st.setString(2, phone);
			st.setString(3, address);
			flag = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag == 0 ? false : true;
	}
	
	public boolean delAddress(int addressid) {
		int flag = 0 ;
		String sql = "delete from "+Constant.AddressTable + " where addressid=?";
		System.out.println(sql);
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, addressid);
			flag = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag == 0 ? false : true;
	}
}
