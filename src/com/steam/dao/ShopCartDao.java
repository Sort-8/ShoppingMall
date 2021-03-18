package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.Goods;
import com.steam.bean.ShopCart;
import com.steam.bean.Types;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class ShopCartDao {
	public boolean updateShopcart(String userid , String goodsid , int shopcartid , int count , String flag) {
		int oriCount;
		int result = 0;
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql1 = "SELECT * FROM " + Constant.ShopcartTable + " WHERE shopcartid=? AND userid=?";
		String sql2 = "update " + Constant.ShopcartTable + " SET count=? WHERE shopcartid=? ";
		try {
			st = DBUtil.getPreparedStatement(sql1);
			st.setInt(1, shopcartid);
			st.setString(2, userid);
			rs = st.executeQuery();
			if(rs.next()) {
				oriCount = rs.getInt("count");
				st = DBUtil.getPreparedStatement(sql2);
				if("add".equals(flag)) st.setInt(1, count + oriCount);
				if("sub".equals(flag)) st.setInt(1, oriCount - count );
				st.setInt(2, shopcartid);
				result = st.executeUpdate();
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
		return result == 0 ? false : true;
	}
	
	public boolean AddShopcart(int userid , String goodsid , String type , int count) {
		int flag = 0;
		PreparedStatement st = null;
		ResultSet  rs = null;
		String id = "";
		String sql1 = "insert into shopcart(goodsid , type , count , userid) VALUE(?,?,?,?)";
		String sql2 = "select * from " + Constant.ShopcartTable + " WHERE goodsid = '"+goodsid+"' AND type = '"+type+"' ";
		String sql3 = "";
		st = DBUtil.getPreparedStatement(sql1);
		try {
			st.setString(1, goodsid);
			st.setString(2, type);
			st.setInt(3, count);
			st.setString(4, userid + "");
			flag = st.executeUpdate();
			st = DBUtil.getPreparedStatement(sql2);
			rs = st.executeQuery();
			if(rs.next()) {
				id = rs.getString("shopcartid");
				sql3 = "UPDATE " + Constant.UserTable + " SET shopcartid = concat(shopcartid , '"+id+";') WHERE userid = ?";
			}
			st = DBUtil.getPreparedStatement(sql3);
			st.setInt(1, userid);
			st.executeUpdate();
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
		return (flag == 0) ? false : true;
	}
	
	public String checkShopCart(int shopcartid , String type , String goodsid) {
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql = "SELECT * FROM " + Constant.ShopcartTable + " WHERE shopcartid = ? AND type = ? AND goodsid = ?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, shopcartid);
			st.setString(2, type);
			st.setString(3, goodsid);
			rs = st.executeQuery();
			if(rs.next()) {
				return rs.getString("shopcartid");
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
		return "";
	}
	
	public ShopCart getShopCart(int shopcartid) {
		
		ShopCart shopcart = null;
		
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql = "SELECT * FROM " + Constant.ShopcartTable + " WHERE shopcartid = ?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, shopcartid);
			rs = st.executeQuery();
			if(rs.next()) {
				shopcart = new ShopCart();
				shopcart.setCount(rs.getString("count"));
				shopcart.setGoodsid(rs.getString("goodsid"));
				shopcart.setShopcartid(rs.getInt("shopcartid"));
				shopcart.setType(rs.getString("type"));
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
		return shopcart;
	}
	
	public List showShopCart(String userid) {
		ShopCart shopcart = null;
		List lists = new ArrayList();
		List list = null;
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		ResultSet  rs1 = null;
		ResultSet  rs2 = null;
		String sql1 = "SELECT * FROM " + Constant.ShopcartTable + " WHERE userid = ?";
		String sql2 = "SELECT * FROM " + Constant.GoodsTable + " WHERE goodsid = ?";
		try {
			st1 = DBUtil.getPreparedStatement(sql1);
			st1.setString(1, userid);
			rs1 = st1.executeQuery();
			while(rs1.next()) {
				list = new ArrayList();
				shopcart = new ShopCart();
				shopcart.setCount(rs1.getString("count"));
				shopcart.setGoodsid(rs1.getString("goodsid"));
				shopcart.setShopcartid(rs1.getInt("shopcartid"));
				shopcart.setType(rs1.getString("type"));
				list.add(shopcart);
				
				st2 = DBUtil.getPreparedStatement(sql2);
				st2.setString(1, shopcart.getGoodsid());
				rs2 = st2.executeQuery();
				if(rs2.next()) {
					Goods good = new Goods();
					good.setCollectcount(rs2.getInt("Collectcount"));
					good.setCount(rs2.getInt("count"));
					good.setCre_time(rs2.getString("cre_time"));
					good.setDiscount(rs2.getInt("discount"));
					good.setGoodsid(rs2.getInt("goodsid"));
					good.setImg(rs2.getString("img"));
					good.setDetailsimg(rs2.getString("detailsimg"));
					good.setMod_time(rs2.getString("mod_time"));
					good.setOriginal(rs2.getFloat("original"));
					good.setParameterid(rs2.getInt("parameterid"));
					good.setPrice(rs2.getFloat("price"));
					good.setSale_count(rs2.getInt("sale_count"));
					good.setTitle(rs2.getString("title"));
					good.setTypeid(rs2.getString("typeid"));
					good.setPaycount(rs2.getString("paycount"));
					list.add(good);
				}
				lists.add(list);
			}
		} catch (SQLException e) {
			System.out.println("购物车更新失败");
			e.printStackTrace();
		}finally{
			try {
				st1.close();
				st2.close();
				rs1.close();
				rs2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}
	
public boolean deleteShopCart(String params , String shopcartid) {
		int flag = 0;
		PreparedStatement st = null;
		String sql1 = "DELETE FROM " + Constant.ShopcartTable + params;
		String sql2 = "UPDATE " + Constant.UserTable + " SET shopcartid=REPLACE(shopcartid,'"+shopcartid+"','')";
		st = DBUtil.getPreparedStatement(sql1);
		try {
			flag = st.executeUpdate();
			st = DBUtil.getPreparedStatement(sql2);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("购物车更新失败");
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

public List getPartShopCart(String params) {
	ShopCart shopCart ;
	List lists = new ArrayList();
	List list = null;
	PreparedStatement st = null;
	String sql1 = "SELECT * FROM " + Constant.ShopcartTable + params;
	String sql2 = "SELECT * FROM " + Constant.GoodsTable + " WHERE goodsid = ?";
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	st = DBUtil.getPreparedStatement(sql1);
	try {
		rs1 = st.executeQuery();
		while(rs1.next()) {
			list = new ArrayList();
			shopCart = new ShopCart();
			shopCart.setCount(rs1.getString("count"));
			shopCart.setGoodsid(rs1.getString("goodsid"));
			shopCart.setShopcartid(rs1.getInt("shopcartid"));
			shopCart.setType(rs1.getString("type"));
			list.add(shopCart);
			
			st = DBUtil.getPreparedStatement(sql2);
			st.setString(1, shopCart.getGoodsid());
			rs2 = st.executeQuery();
			if(rs2.next()) {
				Goods good = new Goods();
				good.setCollectcount(rs2.getInt("Collectcount"));
				good.setCount(rs2.getInt("count"));
				good.setCre_time(rs2.getString("cre_time"));
				good.setDiscount(rs2.getInt("discount"));
				good.setGoodsid(rs2.getInt("goodsid"));
				good.setImg(rs2.getString("img"));
				good.setDetailsimg(rs2.getString("detailsimg"));
				good.setMod_time(rs2.getString("mod_time"));
				good.setOriginal(rs2.getFloat("original"));
				good.setParameterid(rs2.getInt("parameterid"));
				good.setPrice(rs2.getFloat("price"));
				good.setSale_count(rs2.getInt("sale_count"));
				good.setTitle(rs2.getString("title"));
				good.setTypeid(rs2.getString("typeid"));
				good.setPaycount(rs2.getString("paycount"));
				list.add(good);
			}
			lists.add(list);
		}
	} catch (SQLException e) {
		System.out.println("购物车部分获取失败");
		e.printStackTrace();
	}finally{
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return lists;
}
}
