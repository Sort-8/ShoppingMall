package com.steam.service.serviceimp;

import java.util.List;

import com.steam.bean.Types;
import com.steam.dao.TypesDao;

public class TypesServiceImp {
	private TypesDao typesDao = new TypesDao();
	public List<Types> getAllTypes(){
		List<Types> list = typesDao.getAllTypes();
		return list;
	}
}
