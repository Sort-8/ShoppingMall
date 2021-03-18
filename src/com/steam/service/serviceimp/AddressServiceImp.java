package com.steam.service.serviceimp;

import java.util.List;

import com.steam.bean.Address;
import com.steam.dao.AddressDao;
import com.steam.util.TokenUtil;

public class AddressServiceImp {
	AddressDao addressDao = null;
	public List<Address> showAllAddress(String token){
		addressDao = new AddressDao();
		String userid = TokenUtil.CheckUser(token);
		return addressDao.showAllAddress(userid);
	}
	
	public boolean editAddress(String addressid , String name , String phone , String address) {
		addressDao = new AddressDao();
		return addressDao.editAddress(Integer.parseInt(addressid) , name , phone , address);
	}
	
	public boolean addAddress(String name , String phone , String address) {
		addressDao = new AddressDao();
		return addressDao.addAddress(name , phone , address);
	}
	
	public boolean delAddress(String addressid ) {
		addressDao = new AddressDao();
		return addressDao.delAddress(Integer.parseInt(addressid));
	}
}
