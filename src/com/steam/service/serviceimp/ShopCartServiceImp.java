package com.steam.service.serviceimp;

import java.util.ArrayList;
import java.util.List;

import com.steam.bean.ShopCart;
import com.steam.bean.User;
import com.steam.dao.ParameterDao;
import com.steam.dao.ShopCartDao;
import com.steam.util.TokenUtil;

public class ShopCartServiceImp {
	private static final boolean String = false;
	private ShopCartDao shopCartDao;
	private UserServiceImp userServiceImp;
	private java.lang.String[] id;
	
	public boolean updateOrAddShopcart(String goodsid , String type , int count , String token , String flag) {
		shopCartDao = new ShopCartDao();
		//该商品已经存在,修改数量即可
		String result = checkShopCart(goodsid , type , token);
		String userid = TokenUtil.CheckUser(token);
		if(!"".equals(result)) {
			return shopCartDao.updateShopcart(userid , goodsid , Integer.parseInt(result) , count , flag);
		}else {			//该商品不存在，需要增加
			return shopCartDao.AddShopcart(Integer.parseInt(userid) , goodsid , type , count);
		}
	}

	public String checkShopCart(String goodsid , String type , String token) {
		String shopcartid;
		String ids[] = new String[10000];
		String userid = TokenUtil.CheckUser(token);
		userServiceImp = new UserServiceImp();
		shopCartDao = new ShopCartDao();
		User user = userServiceImp.getUser(userid);
		ids = (user.getShopcatid()).split(";");
		for(int i = 0 ; i < ids.length ; i++) {
			shopcartid = shopCartDao.checkShopCart(Integer.parseInt(ids[i]) , type , goodsid);
			if(!"".equals(shopcartid)) {
				return shopcartid;
			}
		}
		return "";
	}
	
	public ShopCart getUserShopCart(String token) {
		String userid = TokenUtil.CheckUser(token);
		userServiceImp = new UserServiceImp();
		shopCartDao = new ShopCartDao();
		User user = userServiceImp.getUser(userid);
		return shopCartDao.getShopCart(Integer.parseInt(user.getShopcatid()));
	}
	
	public List showShopCart(String token) {
		String userid = TokenUtil.CheckUser(token);
		shopCartDao = new ShopCartDao();
		return shopCartDao.showShopCart(userid);
	}
	
	public boolean deleteShopCart(String shopcartid , String token) {
		shopCartDao = new ShopCartDao();
		String userid = TokenUtil.CheckUser(token);
		String params = " WHERE userid='"+userid+"' AND (";
		String ids[] = new String[10000];
		int i;
		ids = shopcartid.split(";");
		for(i = 0 ; i < ids.length - 1 ; i++) {
			params += " shopcartid = "+ids[i]+" or ";
		}
		params += " shopcartid = "+ids[i]+" )";
		return shopCartDao.deleteShopCart(params , shopcartid);
	}
	
	public List getPartShopCart(String shopcartid) {
		shopCartDao = new ShopCartDao();
		String params = " WHERE ";
		String ids[] = new String[10000];
		int i;
		ids = shopcartid.split(";");
		for(i = 0 ; i < ids.length - 1 ; i++) {
			params += " shopcartid = "+ids[i]+" or ";
		}
		params += " shopcartid = "+ids[i]+" ";
		return shopCartDao.getPartShopCart(params);
	}
}
