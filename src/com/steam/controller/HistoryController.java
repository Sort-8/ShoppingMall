package com.steam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.service.serviceimp.HistoryServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;
import com.steam.util.TokenUtil;

public class HistoryController extends HttpServlet{
	HistoryServiceImp historyServiceImp = new HistoryServiceImp();
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
			token = token == null ? "" : token;	//若token 为null则转换为空字符串
			if(!"".equals(TokenUtil.CheckUser(token))) {
				TokenUtil.resetExpire(token);
				if("addHistory".equals(method)) {
					String goodsid = request.getParameter("goodsid");
					print.change(token , response, historyServiceImp.addHistory(goodsid , token), true);
				}else if("showAllHistory".equals(method)) {
					print.change(token , response, historyServiceImp.showAllHistory(token), true);
				}
			}else {
				print.change("" , response, "", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
