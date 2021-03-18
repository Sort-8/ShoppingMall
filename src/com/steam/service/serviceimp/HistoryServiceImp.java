package com.steam.service.serviceimp;

import java.util.List;

import com.steam.bean.History;
import com.steam.dao.HistoryDao;
import com.steam.util.IDUtil;
import com.steam.util.TokenUtil;

public class HistoryServiceImp{
	HistoryDao historyDao = null;
	public boolean addHistory(String goodsid , String token) {
		historyDao = new HistoryDao();
		String time = IDUtil.getDateTime();
		String userid = TokenUtil.CheckUser(token);
		return historyDao.addHistory(time , goodsid , userid);
	}
	
	public List<History> showAllHistory(String token){
		String userid = TokenUtil.CheckUser(token);
		historyDao = new HistoryDao();
		return historyDao.showAllHistory(userid);
	}
}
