package com.steam.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.service.serviceimp.TypesServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;

public class TypesController extends HttpServlet {
	private TypesServiceImp typesServiceImp;
	JsonChange print = new JsonChange();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String method = request.getParameter("method");
			String token = request.getHeader("token");
			String typeid = request.getParameter("typeid");
			String goodstype = request.getParameter("goodstype");
			String goodsname = request.getParameter("goodsname");
			token = token == null ? "" : token;	//若token 为null则转换为空字符串
				if("getAllTypes".equals(method)) {
					typesServiceImp = new TypesServiceImp();
					print.change(token , response, typesServiceImp.getAllTypes(), true);
				}else if(method.equals("addGoodsType")) {		
					print.change(token ,response, "", typesServiceImp.addTypes(goodstype, goodsname));
				}else if(method.equals("delGoodsType")) {
					print.change(token ,response, "", typesServiceImp.delTypes(typeid));
				}else if(method.equals("editGoodsType")) {
					print.change(token ,response, "", typesServiceImp.
							editTypes(typeid,goodstype,goodsname));
				}else if(method.equals("searchTypes")) {
					print.change(token ,response, 
							typesServiceImp.searchTypes(typeid,goodstype,goodsname), true);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
