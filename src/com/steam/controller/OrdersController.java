package com.steam.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.bean.Orders;
import com.steam.service.serviceimp.OrdersServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;
import com.steam.util.TokenUtil;

public class OrdersController extends HttpServlet {
	OrdersServiceImp ordersServiceImp = new OrdersServiceImp();
	JsonChange print = new JsonChange();
	List<Orders> ordersList = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String method = request.getParameter("method");
			String token = request.getHeader("token");
			String url = request.getParameter("url");
			token = token == null ? "" : token;	//若token 为null则转换为空字符串
			String ordersid = request.getParameter("ordersid");
			if(!"".equals(TokenUtil.CheckUser(token))) {
				TokenUtil.resetExpire(token);
				if("getAllOrders".equals(method)) {
					print.change(token , response, ordersServiceImp.getAllOrders(), true);
				}else if("searchOrders".equals(method)) {
					String userid = request.getParameter("username");
					String status = request.getParameter("status");
					print.change(token , response, ordersServiceImp.searchOrders(ordersid,userid,status), true);
				}else if("editOrders".equals(method)) {
					String status = request.getParameter("status");
					print.change(token , response, "", ordersServiceImp.editOrders(ordersid,status));
				}else if("searchOrderByUserid".equals(method)) {
					print.change(token , response, ordersServiceImp.searchOrders(token), true);
				}
			}else {
				print.change("" , response, "", false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
