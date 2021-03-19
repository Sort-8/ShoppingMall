package com.steam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.bean.User;
import com.steam.service.serviceimp.UserServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;
import com.steam.util.TokenUtil;

public class UserController extends HttpServlet{
	UserServiceImp userServiceImp = new UserServiceImp();
	JsonChange print = new JsonChange();
	List list = null;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String method = request.getParameter("method");
			String token = request.getHeader("token");
			String url = request.getParameter("url");
			token = token == null ? "" : token;	//若token 为null则转换为空字符串
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String sex = request.getParameter("sex");
			String password = request.getParameter("password");
			if("login".equals(method)) {
				list = userServiceImp.UserLogin(userid, password , token , url);
				if(!"".equals(list.get(0))) {
					print.change(token , response, list , true);
				}else {
					print.change(token , response , "" , false);
				}
			}else if(!"".equals(TokenUtil.CheckUser(token))) {
				if("getOwner".equals(method)) {
					userid = TokenUtil.CheckUser(token);
					print.change(token , response, userServiceImp.getUser(userid), true);
				}else if("getAllUser".equals(method)) {
					print.change(token , response, userServiceImp.getAllUser(), true);
				}else if("searchUsers".equals(method)) {
					if(username=="" && sex=="" && phone=="") {
						print.change(token , response, userServiceImp.getAllUser(), true);
					}else {
						print.change(token , response, userServiceImp.searchUser(username,sex,phone), true);
					}
				}else if("editUserStatus".equals(method)) {
					String status = request.getParameter("status");
					print.change(token , response, "", userServiceImp.editUserStatus(userid, status));
				}else if("getAdminBaseInfo".equals(method)) {
					print.change(token , response, userServiceImp.getAdminBaseInfo(userid), true);
				}else if("editAdminBaseInfo".equals(method)) {
					print.change(token , response, "", userServiceImp.editAdminBaseInfo(userid,
							username, phone, email));
				}else if("verifyAdminPassword".equals(method)) {
					print.change(token , response, "", userServiceImp.verifyPassword(userid,password));
				}else if("editAdminPassword".equals(method)) {
					print.change(token , response, "", userServiceImp.editAdminPassword(userid, password));
				}else if("getAllAdmin".equals(method)) {
					print.change(token , response, userServiceImp.getAllAdmin(), true);
				}else if("searchAdmins".equals(method)) {
					if(userid=="" && username=="" && phone=="") {
						print.change(token , response, userServiceImp.getAllAdmin(), true);
					}else {
						print.change(token , response, userServiceImp.searchAdmin(userid, username, phone), true);
					}
				}else if("addAdmin".equals(method)) {
					print.change(token , response, "", userServiceImp.addAdmin(userid,password));
				}else if("verfiyAdminUserid".equals(method)) {
					print.change(token , response, "", userServiceImp.VerifyUserid(userid));
				}else if("delAdmin".equals(method)) {
					print.change(token , response, "", userServiceImp.delAdmin(userid));
				}else if("updateUser".equals(method)) {
					print.change(token , response, "", userServiceImp.updateUser(token , username , sex , phone , email));
				}else if("updateAddress".equals(method)) {
					String addressid = request.getParameter("addressid");
					print.change(token, response, userServiceImp.updateAddress(token, addressid), true);
				}
			}else {
				print.change("" , response, "", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
