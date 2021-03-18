package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.steam.bean.Goods;
import com.steam.bean.User;
import com.steam.util.Constant;
import com.steam.util.DBUtil;
import com.steam.util.IDUtil;
import com.steam.util.ResultUtil;

public class GoodsDao {
	ResultUtil resultUtil = new ResultUtil();
	private static Goods goods =null;
	private static PreparedStatement st = null;
	private static ResultSet rsSet = null;
	private static int rs;
	private static String sql = null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式; 
	List<Goods> goodsList = null;
	
	public ResultUtil getAllGoods(String params1 , String params2) {
		List<Goods> list = new ArrayList<Goods>();
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql = "select * from " + Constant.GoodsTable + params1;
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			while(rs.next()) {
				Goods good = new Goods();
				good.setCollectcount(rs.getInt("Collectcount"));
				good.setCount(rs.getInt("count"));
				good.setCre_time(rs.getString("cre_time"));
				good.setDiscount(rs.getInt("discount"));
				good.setGoodsid(rs.getInt("goodsid"));
				good.setImg(rs.getString("img"));
				good.setDetailsimg(rs.getString("detailsimg"));
				good.setMod_time(rs.getString("mod_time"));
				good.setOriginal(rs.getFloat("original"));
				good.setParameterid(rs.getInt("parameterid"));
				good.setPrice(rs.getFloat("price"));
				good.setSale_count(rs.getInt("sale_count"));
				good.setTitle(rs.getString("title"));
				good.setTypeid(rs.getString("typeid"));
				good.setPaycount(rs.getString("paycount"));
				list.add(good);
			}
			sql = "select * from " + Constant.GoodsTable + params2;
			st = DBUtil.getPreparedStatement(sql);
			rs = st.executeQuery();
			rs.last();
			resultUtil.count = rs.getRow();
			resultUtil.obj = list;
		} catch (SQLException e) {
			System.out.println("浏览所有商品失败");
			e.printStackTrace();
		}finally{
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultUtil;
	}
	
	public List<Goods> getDetails(int goodsid) {
		List<Goods> list = new ArrayList<Goods>();
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql = "select * from goods where goodsid = ?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, goodsid);
			rs = st.executeQuery();
			if(rs.next()) {
				Goods good = new Goods();
				good.setCollectcount(rs.getInt("collectcount"));
				good.setCount(rs.getInt("count"));
				good.setCre_time(rs.getString("cre_time"));
				good.setDiscount(rs.getInt("discount"));
				good.setGoodsid(rs.getInt("goodsid"));
				good.setImg(rs.getString("img"));
				good.setDetailsimg(rs.getString("detailsimg"));
				good.setMod_time(rs.getString("mod_time"));
				good.setOriginal(rs.getFloat("original"));
				good.setParameterid(rs.getInt("parameterid"));
				good.setPrice(rs.getFloat("price"));
				good.setSale_count(rs.getInt("sale_count"));
				good.setTitle(rs.getString("title"));
				good.setTypeid(rs.getString("typeid"));
				good.setPaycount(rs.getString("paycount"));
				list.add(good);
			}
		} catch (SQLException e) {
			System.out.println("浏览所有商品失败");
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
	
	public List<Goods> findAllGoods(){
		goodsList = new ArrayList<Goods>();
		sql = "select * from " + Constant.GoodsTable;
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("商品模块：查询所有商品数据的结果集为空");
			}else {
				do {
					goods = new Goods();
					goods.setGoodsid(rsSet.getInt(1));
					goods.setTitle(rsSet.getString(2));
					goods.setCount(rsSet.getInt(3));
					goods.setParameterid(rsSet.getInt(4));
					goods.setImg(rsSet.getString(5));
					goods.setPrice(rsSet.getFloat(6));
					goods.setOriginal(rsSet.getFloat(7));
					goods.setDiscount(rsSet.getFloat(8));
					goods.setPaycount(rsSet.getString(9));
					goods.setCollectcount(rsSet.getInt(10));
					goods.setSale_count(rsSet.getInt(11));
					goods.setCre_time(rsSet.getString(12));
					goods.setMod_time(rsSet.getString(13));
					goodsList.add(goods);
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodsList;
	}
	
	public List<Goods> selectGoods(String params) {
		goodsList = new ArrayList<Goods>();
		st = DBUtil.getPreparedStatement(params);
		try {
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("商品模块：查询所有商品数据的结果集为空");
			}else {
				do {
					goods = new Goods();
					goods.setGoodsid(rsSet.getInt("Goodsid"));
					goods.setTitle(rsSet.getString(2));
					goods.setCount(rsSet.getInt(3));
					goods.setParameterid(rsSet.getInt(4));
					goods.setImg(rsSet.getString(5));
					goods.setPrice(rsSet.getFloat(6));
					goods.setOriginal(rsSet.getFloat(7));
					goods.setDiscount(rsSet.getFloat(8));
					goods.setPaycount(rsSet.getString(9));
					goods.setCollectcount(rsSet.getInt(10));
					goods.setSale_count(rsSet.getInt(11));
					goods.setCre_time(rsSet.getString(12));
					goods.setMod_time(rsSet.getString(13));
					goodsList.add(goods);
				}while(rsSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodsList;
	}
	public int delGoods(int goodsid) {
		rs = -1;
		sql = "delete from "+Constant.GoodsTable+" where goodsid=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, goodsid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	public int editGoods(int goodsid, String goodsname, String goodstype, String goodsprice,
			String goodssize, String goodscount) {
		rs = -1;
		sql = "update "+Constant.GoodsTable+" set title=?,typeid=?,price=?"
				+ ",count=? where goodsid ";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, goodsname);
			st.setString(2, goodstype);
			st.setString(3, goodsprice);
			st.setInt(4, Integer.valueOf(goodscount));
			st.setInt(1, goodsid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	public int addGoods(String goodsname, String goodstype, String goodsprice,
			String goodssize, String goodscolor, List<String> countList) {
		rs = -1;
		ParameterDao parameterDao = new ParameterDao();
		String time = df.format(new Date());
		String goodsid = IDUtil.getGoodsCode(null);
		String parameterid = IDUtil.getParameterCode(null);
		parameterDao.addParameter(parameterid,goodssize,goodscolor,countList);
		int count = 0;
		for(Iterator<String> it = countList.iterator();it.hasNext();) {
			count += Integer.valueOf(it.next());
		}
		sql = "insert into "+Constant.GoodsTable+" value('"+goodsid+"','"+goodsname+"','"+goodstype+"','"+
				count+"','"+parameterid+"',null,'"+goodsprice+"',null,null,null,null,null,'"+time+"',null)";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public List<Goods> getGoodsByTypeName(String params) {
		String typeid = null;
		sql = "select * from " + Constant.TypesTable + params;
		st = DBUtil.getPreparedStatement(sql);
		Goods good = null;
		List<Goods> list = new ArrayList<Goods>();
		try {
			rsSet = st.executeQuery();
			if(!rsSet.next()) {
				System.out.println("商品模块：查询所有商品数据的结果集为空");
			}else {
				do {
					typeid = rsSet.getString("typeid");
					sql = "SELECT * FROM "+ Constant.GoodsTable +" WHERE typeid = '"+typeid+"'";
					st = DBUtil.getPreparedStatement(sql);
					rsSet = st.executeQuery();
					while(rsSet.next()) {
						good = new Goods();
						good.setCollectcount(rsSet.getInt("collectcount"));
						good.setCount(rsSet.getInt("count"));
						good.setCre_time(rsSet.getString("cre_time"));
						good.setDiscount(rsSet.getInt("discount"));
						good.setGoodsid(rsSet.getInt("goodsid"));
						good.setImg(rsSet.getString("img"));
						good.setDetailsimg(rsSet.getString("detailsimg"));
						good.setMod_time(rsSet.getString("mod_time"));
						good.setOriginal(rsSet.getFloat("original"));
						good.setParameterid(rsSet.getInt("parameterid"));
						good.setPrice(rsSet.getFloat("price"));
						good.setSale_count(rsSet.getInt("sale_count"));
						good.setTitle(rsSet.getString("title"));
						good.setTypeid(rsSet.getString("typeid"));
						good.setPaycount(rsSet.getString("paycount"));
						list.add(good);
					}
				}while(rsSet.next());
			}
		} catch (SQLException e) {
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
}
