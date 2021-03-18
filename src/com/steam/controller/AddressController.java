package com.steam.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.steam.service.serviceimp.AddressServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;

public class AddressController extends HttpServlet{
	JsonChange print = new JsonChange();
	AddressServiceImp addressServiceImp = new AddressServiceImp();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
			doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String token = request.getHeader("token");
			String method = request.getParameter("method");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			token = token == null ? "" : token;	//若token 为null则转换为空字符串
			if("showAllAddress".equals(method)) {
				print.change(token, response, addressServiceImp.showAllAddress(token), true);
			}else if("editAddress".equals(method)) {
				String addressid = request.getParameter("addressid");
				print.change(token, response, addressServiceImp.editAddress(addressid , name , phone , address), true);
			}else if("delAddress".equals(method)) {
				String addressid = request.getParameter("addressid");
				print.change(token, response, addressServiceImp.delAddress(addressid), true);
			}else if("addAddress".equals(method)) {
				print.change(token, response, addressServiceImp.addAddress(name , phone , address), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}
