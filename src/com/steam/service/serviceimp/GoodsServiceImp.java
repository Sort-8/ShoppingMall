package com.steam.service.serviceimp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import com.steam.bean.Goods;
import com.steam.dao.GoodsDao;
import com.steam.dao.ParameterDao;
import com.steam.util.Constant;
import com.steam.util.ResultUtil;

public class GoodsServiceImp {
	private ParameterServiceImp parameterServiceImp;
	List<Goods> goodsList = null;
	GoodsDao goodsDao = null;
	public ResultUtil getAllGoods( String typeid , int curr ){
		int page = (curr - 1)*9;
		String params1 = " where typeid='"+typeid+"' order by paycount desc limit "+page+",9";
		String params2 = " where typeid='"+typeid+"'";
		goodsDao = new GoodsDao();
		if("All".equals(typeid)) {
			params1 = " order by paycount desc limit "+page+",9";
			params2 = "";
		}else if("AllHot".equals(typeid)) {
			params1 = " order by paycount desc limit "+page+",8";
		}
		return goodsDao.getAllGoods(params1 , params2);
	}
	
	public List getDetails(String goodsid) {
		goodsDao = new GoodsDao();
		List<Goods> list = goodsDao.getDetails(Integer.parseInt(goodsid));
		parameterServiceImp = new ParameterServiceImp();
		List lists = parameterServiceImp.getParameter(list.get(0).getParameterid());
		lists.add(list);
		return lists;
	}
	
	/**
	 * 庞海
	 * 后台获取所有商品信息
	 * @return List<Goods>
	 */
	public List<Goods> getAllShops(){
		goodsDao = new GoodsDao();
		String params = "SELECT * from goods,types WHERE"
				+ " goods.typeid = types.typeid and goods.typeid = types.typeid;";
		return goodsDao.findAllGoods(params);
	}
	
	/**
	 * 庞海
	 * 后台搜索商品信息
	 * @param shopsid 商品编号
	 * @param shopstitle 商品名
	 * @param shopstype 商品类型
	 * @return List<Goods>
	 */
	public List<Goods> searchShops(String shopsid, String shopstitle, String shopstype){
		goodsDao = new GoodsDao();
		goodsList = new ArrayList<Goods>();
		String params= null;
		shopsid = shopsid == null ? "" : shopsid;
		shopstitle = shopstitle == null ? "" : shopstitle;
		shopstype = shopstype == null ? "" : shopstype;
		params = "select * from " + Constant.GoodsTable + " where goodsid like '"+shopsid+"%'"
				+ " and title like '"+shopstitle+"%' and typeid like '"+shopstype+"%'";
		goodsList = goodsDao.selectGoods(params);
		return goodsList;
	}
	
	/**
	 * 庞海
	 * 后台添加商品信息
	 * @param goodsname
	 * @param goodstype
	 * @param goodsprice
	 * @param goodssize
	 * @param goodscount
	 * @return boolean
	 */
	public boolean addGoods(String goodsname, String goodstype, String goodsprice,
			String goodssize, String goodscolor, String goodscount) {
		goodsDao = new GoodsDao();
//		List<String> sizeList = new ArrayList<String>(); //注释了商品参数，原因是直接加在参数表不能拆成数组，用的时候
														//再拆，id值是由创建商品的时候生成的，一种商品有一个参数id
//		List<String> colorList = new ArrayList<String>();
		List<String> countList = new ArrayList<String>();
//		String[] tempSize;
//		String[] tempColor;
		String[] tempCount;
		String temp;
//		tempSize = goodssize.split(";");
//		tempColor = goodscolor.split(";");
		tempCount = goodscount.split(";");
//		for(int i=0;i<tempSize.length;i++)
//		{
//			temp = Pattern.compile("[^0-9]").matcher(tempSize[i]).replaceAll("").trim();
//			sizeList.add(temp);
//		}
//		for(int i=0;i<tempColor.length;i++)
//		{
//			temp = Pattern.compile("[^0-9]").matcher(tempColor[i]).replaceAll("").trim();
//			colorList.add(temp);
//		}
		for(int i=0;i<tempCount.length;i++)
		{
			temp = Pattern.compile("[^0-9]").matcher(tempCount[i]).replaceAll("").trim();
			countList.add(temp);
		}
		if(goodsDao.addGoods(goodsname, goodstype, goodsprice, goodssize, goodscolor, countList)!=-1) {
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 庞海
	 * 后台批量删除商品
	 * @param list
	 * @return boolean
	 */
	public boolean delDozenGoods(String goodsid) {
		goodsDao = new GoodsDao();
		List list = new ArrayList();
		String[] temp1;
		String temp2;
		temp1 = goodsid.split(",");
		for(int i=0;i<temp1.length;i++)
		{
			temp2 = Pattern.compile("[^0-9]").matcher(temp1[i]).replaceAll("").trim();
			list.add(temp2);
		}
		for(Iterator<String> it = list.iterator();it.hasNext();) {
			if(goodsDao.delGoods(Integer.parseInt(it.next()))==-1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 庞海
	 * 后台删除商品信息
	 * @param goodsid
	 * @return boolean
	 */
	public boolean delGoods(String goodsid) {
		goodsDao = new GoodsDao();
		ParameterDao parameterDao = new ParameterDao();
		
		if(goodsDao.delGoods(Integer.parseInt(goodsid))!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 庞海
	 * 后台编辑商品信息
	 * @param goodsid
	 * @param goodsname
	 * @param goodstype
	 * @param goodsprice
	 * @param goodssize
	 * @param goodscount
	 * @return boolean
	 */
	public boolean editGoods(String goodsid, String goodsname, String goodstype, String goodsprice,
			String goodssize, String goodscount) {
		goodsDao = new GoodsDao();
		if(goodsDao.editGoods(Integer.parseInt(goodsid), goodsname, goodstype, goodsprice, goodssize, goodscount)!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Goods> searchKey(String key){
		goodsDao = new GoodsDao();
		String params= null;
		params = "select * from " + Constant.GoodsTable + " where goodsid like '%"+key+"%'";
		goodsList = goodsDao.selectGoods(params);
		goodsList.addAll(getGoodsByTypeName(key));
		return goodsList;
	}
	
	public List<Goods> getGoodsByTypeName(String name) {
		goodsDao = new GoodsDao();
		String params= null;
		params = " where name = '"+name+"'";
		return goodsDao.getGoodsByTypeName(params);
	}
}
