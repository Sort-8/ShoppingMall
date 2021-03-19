package com.steam.service.serviceimp;

import java.util.List;

import com.steam.bean.Comment;
import com.steam.dao.CommentDao;

public class CommentServiceImp {
	List<Comment> list = null;
	CommentDao commentDao = null;
	public List<Comment> getAllComment(){
		commentDao = new CommentDao();
		return commentDao.findAllComment();
	}
	public List<Comment> searchComment(String commentid, String username, String comment) {
		commentDao = new CommentDao();
		commentid = commentid == null ? "" : commentid;
		username = username == null ? "" : username;
		comment = comment == null ? "" : comment;
		return commentDao.selectComment(commentid, username, comment);
	}
	public boolean delComment(String commentid) {
		commentDao = new CommentDao();
		if(commentDao.delCommentByCommentid(Integer.parseInt(commentid))!=-1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean editCommentStatus(String commentid, String status) {
		commentDao = new CommentDao();
		if(commentDao.editCommentSatus(Integer.parseInt(commentid), status)!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Comment> showGoodsComment(String goodsid) {
		commentDao = new CommentDao();
		return commentDao.showGoodsComment(goodsid);
	}
}
