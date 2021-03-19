package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.Orders;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class OrdersDao {
	private List<Orders> list = null;
	private Orders orders = null;
	private PreparedStatement st = null;
	private ResultSet rsSet = null;
	private String sql = null;
	private int rs;
	public List<Orders> findAllOrders() {
		list = new ArrayList<Orders>();
		sql = "select * from " + Constant.OrderTable+" order by createtime desc";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("订单模块：查询所有订单数据的结果集为空");
			}else {
				do {
					orders = new Orders();
					orders.setOrdersid(rsSet.getInt(1));
					orders.setUserid(rsSet.getString(2));
					orders.setGoodsid(rsSet.getString(3));
					orders.setCreatetime(rsSet.getString(4));
					orders.setCount(rsSet.getString(5));
					orders.setPrice(rsSet.getString(6));
					orders.setStatus(rsSet.getString(7));
					orders.setType(rsSet.getString(8));
					orders.setPayid(rsSet.getString(9));
					list.add(orders);
				}while(rsSet.next());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Orders> searchOrderByUserid(String userid) {
		list = new ArrayList<Orders>();
		sql = "select * from " + Constant.OrderTable+" where userid=? order by createtime desc";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString( 1 , userid );
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("订单模块：查询所有订单数据的结果集为空");
			}else {
				do {
					orders = new Orders();
					orders.setOrdersid(rsSet.getInt(1));
					orders.setUserid(rsSet.getString(2));
					orders.setGoodsid(rsSet.getString(3));
					orders.setCreatetime(rsSet.getString(4));
					orders.setCount(rsSet.getString(5));
					orders.setPrice(rsSet.getString(6));
					orders.setStatus(rsSet.getString(7));
					orders.setType(rsSet.getString(8));
					orders.setPayid(rsSet.getString(9));
					orders.setDetails(rsSet.getString(10));
					
					orders.setAddress(searchAddressById(rsSet.getString(11)));
					list.add(orders);
				}while(rsSet.next());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public String searchAddressById(String addressid) {
		String address = "";
		sql = "select * from " + Constant.AddressTable+" where addressid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString( 1 , addressid );
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("订单模块：查询订单地址的结果集为空");
			}else {
				address = rsSet.getString("address");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}
	
	public List<Orders> selectOrders(String ordersid, String userid, String status) {
		list = new ArrayList<Orders>();
		sql = "select * from " + Constant.OrderTable+" where ordersid like '"+ordersid+"%'"
				+ " and username like '"+userid+"%' and status like '"+status+"%'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("订单模块：查询所有订单数据的结果集为空");
			}else {
				do {
					orders = new Orders();
					orders.setOrdersid(rsSet.getInt(1));
					orders.setUserid(rsSet.getString(2));
					orders.setGoodsid(rsSet.getString(3));
					orders.setCreatetime(rsSet.getString(4));
					orders.setCount(rsSet.getString(5));
					orders.setPrice(rsSet.getString(6));
					orders.setStatus(rsSet.getString(7));
					orders.setType(rsSet.getString(8));
					orders.setPayid(rsSet.getString(9));
					list.add(orders);
				}while(rsSet.next());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int editOrdersStatusByOrders(String ordersid, String status) {
		rs = -1;
		sql = "update "+Constant.OrderTable+" set status='"+status+"' where ordersid='"+ordersid+"'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
//				rsSet.close(); //调整订单状态会报错，需删除
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
}
