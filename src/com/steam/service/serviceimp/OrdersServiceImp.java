package com.steam.service.serviceimp;

import java.util.List;

import com.steam.bean.Orders;
import com.steam.dao.OrdersDao;
import com.steam.util.TokenUtil;

public class OrdersServiceImp {
	List<Orders> list = null;
	OrdersDao ordersDao = null;
	public List<Orders> getAllOrders() {
		ordersDao = new OrdersDao();
		return ordersDao.findAllOrders();
	}
	public List<Orders> searchOrders(String ordersid, String userid, String status) {
		ordersDao = new OrdersDao();
		ordersid = ordersid == null ? "" : ordersid;
		userid = userid == null ? "" : userid;
		status = status == null ? "" : status;
		return ordersDao.selectOrders(ordersid, userid, status);
	}
	public boolean editOrders(String ordersid, String status) {
		ordersDao = new OrdersDao();
		ordersid = ordersid == null ? "" : ordersid;
		status = status == null ? "" : status;
		if(ordersDao.editOrdersStatusByOrders(ordersid,status)!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Orders> searchOrders(String token) {
		ordersDao = new OrdersDao();
		String userid = TokenUtil.CheckUser(token);
		userid = userid == null ? "" : userid;
		return ordersDao.searchOrderByUserid(userid);
	} 
}
