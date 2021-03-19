package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.Comment;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class CommentDao {
	private List<Comment> list = null;
	private Comment comment = null;
	private PreparedStatement st = null;
	private ResultSet rsSet = null;
	private String sql = null;
	private int rs;
	public List<Comment> findAllComment(){
		list = new ArrayList<Comment>();
		sql = "select * from "+Constant.CommentTable+" order by createtime desc";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(rsSet.next()) {
				do {
					comment = new Comment();
					comment.setCommentid(rsSet.getInt(1));
					comment.setGoodsid(rsSet.getString(2));
					comment.setUsername(rsSet.getString(3));
					comment.setCreatetime(rsSet.getString(4));
					comment.setComment(rsSet.getString(5));
					comment.setStatus(rsSet.getString(6));
					list.add(comment);
				}while(rsSet.next());
			}else {
				System.out.println("评论模块：查找所有评论的结果集为空");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Comment> showGoodsComment(String goodsid){
		list = new ArrayList<Comment>();
		sql = "select * from "+Constant.CommentTable+" WHERE goodsid = ? AND status = '已审核' ";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, goodsid);
			rsSet = st.executeQuery();
			if(rsSet.next()) {
				do {
					comment = new Comment();
					comment.setCommentid(rsSet.getInt(1));
					comment.setGoodsid(rsSet.getString(2));
					comment.setUsername(rsSet.getString(3));
					comment.setCreatetime(rsSet.getString(4));
					comment.setComment(rsSet.getString(5));
					comment.setStatus(rsSet.getString(6));
					list.add(comment);
				}while(rsSet.next());
			}else {
				System.out.println("评论模块：查找所有评论的结果集为空");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Comment> selectComment(String commentid, String username, String content) {
		list = new ArrayList<Comment>();
		sql = "select * from "+Constant.CommentTable+" where commentid like '"+commentid+"%' and "
				+ "username like '"+username+"%' and comment like '"+content+"%'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rsSet = st.executeQuery();
			if(rsSet.next()) {
				do {
					comment = new Comment();
					comment.setCommentid(rsSet.getInt(1));
					comment.setGoodsid(rsSet.getString(2));
					comment.setUsername(rsSet.getString(3));
					comment.setCreatetime(rsSet.getString(4));
					comment.setComment(rsSet.getString(5));
					comment.setStatus(rsSet.getString(6));
					list.add(comment);
				}while(rsSet.next());
				rsSet.close();
				st.close();
			}else {
				System.out.println("评论模块：查找所有评论的结果集为空");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int delCommentByCommentid(int commentid) {
		rs = -1;
		sql = "delete from "+Constant.CommentTable+" where commentid= ?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setInt(1, commentid);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	public int editCommentSatus(int commentid, String status) {
		rs = -1;
		sql = "update "+Constant.CommentTable+" set status='"+status+"'where"
				+ " commentid='"+commentid+"'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				rsSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
}
