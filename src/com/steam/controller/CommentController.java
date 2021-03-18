package com.steam.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.bean.Types;
import com.steam.service.serviceimp.CommentServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;
import com.steam.util.TokenUtil;

public class CommentController extends HttpServlet {
	CommentServiceImp commentServiceImp = new CommentServiceImp();
	JsonChange print = new JsonChange();
	List<Types> typesList = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String method = request.getParameter("method");
			String token = request.getHeader("token");
			String url = request.getParameter("url");
			token = token == null ? "" : token;	//若token 为null则转换为空字符串
			String commentid = request.getParameter("commentid");
				if("getAllComment".equals(method)) {
					print.change(token , response, commentServiceImp.getAllComment(), true);
				}else if("searchComment".equals(method)) {
					String username = request.getParameter("username");
					String comment = request.getParameter("comment");
					print.change(token , response, commentServiceImp.searchComment(commentid,username,comment), true);
				}else if("delComment".equals(method)) {
					print.change(token , response, "", commentServiceImp.delComment(commentid));
				}else if("editCommentStatus".equals(method)) {
					String status = request.getParameter("status");
					print.change(token , response, "", commentServiceImp.editCommentStatus(commentid,status));
				}else if("showGoodsComment".equals(method)) {
					String goodsid = request.getParameter("goodsid");
					print.change(token , response, commentServiceImp.showGoodsComment(goodsid) , true);
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
