package com.steam.service.serviceimp;

import java.util.List;

import com.steam.dao.ParameterDao;

public class ParameterServiceImp {
	private ParameterDao parameterDao;
	public List getParameter(int parameterid) {
		parameterDao = new ParameterDao();
		return parameterDao.getParameter(parameterid);
	}
}
