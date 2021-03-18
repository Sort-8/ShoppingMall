package com.steam.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.util.Constant;

public class ParameterController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
			doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String goodsid = request.getParameter("goodsid");
			String token = request.getHeader("token");
			String method = request.getParameter("method");
			
			if("getDetails".equals(method)) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}
