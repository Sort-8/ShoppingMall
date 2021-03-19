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
	
	/**
	 * 庞海
	 * 后台添加一个商品类目
	 * @param type 商品类目
	 * @param name 商品类别
	 * @return boolean
	 */
	public boolean addTypes(String type, String name) {
		typesDao = new TypesDao();
		if(typesDao.addTypes(type, name)!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 庞海
	 * 后台删除一个商品类目
	 * @param typeid 商品类目id
	 * @return boolean
	 */
	public boolean delTypes(String typeid) {
		typesDao = new TypesDao();
		if(typesDao.delTypes(typeid)!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 庞海
	 * 后台编辑一个商品类目
	 * @param typeid 商品类目id
	 * @param type 商品类目
	 * @param name 商品类别
	 * @return boolean
	 */
	public boolean editTypes(String typeid, String type, String name) {
		typesDao = new TypesDao();
		if(typesDao.editTypes(typeid, type, name)!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 庞海
	 * 后台搜索商品类目
	 * @param typeid 商品类目id
	 * @param type 商品类目
	 * @param name 商品类别
	 * @return List<Types>
	 */
	public List<Types> searchTypes(String typeid, String type, String name){
		typesDao = new TypesDao();
		return typesDao.searchTypes(typeid, type, name);
	}
}
