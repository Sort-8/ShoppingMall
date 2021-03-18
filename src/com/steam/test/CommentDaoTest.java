package com.steam.test;

import org.junit.Test;

import com.steam.dao.CommentDao;

public class CommentDaoTest {
	CommentDao commentDao = null;
	@Test
	public void getAllCommentTest() {
		commentDao = new CommentDao();
		System.out.println(commentDao.findAllComment());
	}
}
