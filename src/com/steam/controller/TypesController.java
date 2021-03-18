package com.steam.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.service.serviceimp.TypesServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;
import com.steam.util.TokenUtil;

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
			token = token == null ? "" : token;	//若token 为null则转换为空字符串
				if("getAllTypes".equals(method)) {
					typesServiceImp = new TypesServiceImp();
					print.change(token , response, typesServiceImp.getAllTypes(), true);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
