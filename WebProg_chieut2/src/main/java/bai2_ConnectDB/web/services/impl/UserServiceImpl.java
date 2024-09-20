package bai2_ConnectDB.web.services.impl;

import bai2_ConnectDB.web.dao.IUserDao;
import bai2_ConnectDB.web.dao.impl.UserDaoImpl;
import bai2_ConnectDB.web.models.UserModel;
import bai2_ConnectDB.web.services.IUserService;

public class UserServiceImpl implements IUserService {
	//Lay toan bo ham trong tang DAO cua user.
	IUserDao userDao = new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {		//password nay la cai nguoi dung nhap tu form.
		
		UserModel user = this.findByUserName(username);
		if(user != null && password.equals(user.getPasswd()))		//kiem tra xem cai duoc nhap tu form va database co giong nhau khong.
			{
			System.out.println(user.getUsername());
			return user;}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		
		return userDao.findByUserName(username);
	}

}
