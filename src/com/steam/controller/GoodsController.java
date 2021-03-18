package com.steam.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.bean.Goods;
import com.steam.service.serviceimp.GoodsServiceImp;
import com.steam.service.serviceimp.UserServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;
import com.steam.util.TokenUtil;

public class GoodsController extends HttpServlet{
	GoodsServiceImp goodsServiceImp = new GoodsServiceImp();
	JsonChange print = new JsonChange();
	GoodsServiceImp goodsimp = new GoodsServiceImp();
	List<Goods> goodsList = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String token = request.getHeader("token");
			String method = request.getParameter("method");
			String goodsid = request.getParameter("goodsid");
			String goodstitle = request.getParameter("goodstitle");
			String goodstype = request.getParameter("goodstype");
			String goodsprice = request.getParameter("goodsprice");
			String goodssize = request.getParameter("goodssize");
			String goodscolor = request.getParameter("goodscolor");
			String goodscount = request.getParameter("goodscount");
			token = token == null ? "" : token;	//若token 为null则转换为空字符串
				if("getAllGoods".equals(method)) {
					String typeid = request.getParameter("typeid");
					String c = request.getParameter("curr");
					System.out.println(c);
					int curr = 0;
					if(c != null) {
						curr = Integer.parseInt(c);
					}
					print.change(token , response, goodsServiceImp.getAllGoods(typeid , curr), true);
				}else if("getDetails".equals(method)){
					print.change(token , response, goodsServiceImp.getDetails(goodsid), true);
				}else if(method.equals("getAllShops")) {
					print.change(token , response, goodsimp.getAllShops(), true);
				}else if(method.equals("searchShops")) {		
					print.change(token , response, goodsimp.searchShops(goodsid, goodstitle, goodstype), true);
				}else if(method.equals("addGoods")) {
					print.change(token , response, "", goodsimp.addGoods(goodstitle,
							goodstype, goodsprice, goodssize, goodscolor, goodscount));
				}else if(method.equals("uploadShopsImg")) {
					//上传若干图片到腾讯云储存，返回若干图片地址
				}else if(method.equals("delDozenGoods")) {
					print.change(token , response, "", goodsimp.delDozenGoods(goodsid));
				}else if(method.equals("delGoods")) {
					System.out.println(goodsid);
					print.change(token , response, "", goodsimp.delGoods(goodsid));
				}else if(method.equals("editGoods")) {
					print.change(token , response, "", goodsimp.editGoods(goodsid,
							goodstitle, goodstype, goodsprice, goodssize, goodscount));
				}else if("searchKey".equals(method)) {
					String key = request.getParameter("key");
					print.change(token , response, goodsimp.searchKey(key) , true);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
