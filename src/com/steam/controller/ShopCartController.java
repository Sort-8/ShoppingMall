package com.steam.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.service.serviceimp.ShopCartServiceImp;
import com.steam.service.serviceimp.TypesServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;
import com.steam.util.TokenUtil;

public class ShopCartController extends HttpServlet{
	ShopCartServiceImp shopCartServiceImp;
	JsonChange print = new JsonChange();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request , response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String token = request.getHeader("token");
			String method = request.getParameter("method");
			String shopcartid = request.getParameter("shopcartid");
			
			token = token == null ? "" : token;
			if(!"".equals(TokenUtil.CheckUser(token))) {
				TokenUtil.resetExpire(token); 		//用户有请求，则重置令牌的过期时间
				shopCartServiceImp = new ShopCartServiceImp();
				if("addShopCart".equals(method)) {
					String type = request.getParameter("type");
					String goodsid = request.getParameter("goodsid");
					int count = Integer.parseInt(request.getParameter("count"));
					String flag = request.getParameter("flag");
					print.change(token , response, "", shopCartServiceImp.updateOrAddShopcart(goodsid, type , count , token , flag));
				}else if("showShopCart".equals(method)) {
					print.change(token , response, shopCartServiceImp.showShopCart(token), true);
				}else if("deleteShopCart".equals(method)) {
					print.change(token , response, shopCartServiceImp.deleteShopCart(shopcartid , token), true);
				}else if("getPartShopCart".equals(method)) {
					print.change(token , response, shopCartServiceImp.getPartShopCart(shopcartid), true);
				}
			}else {
				print.change("" , response, "" , false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
