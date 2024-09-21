package bai2_ConnectDB.web.services;

import bai2_ConnectDB.web.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel findByUserName(String username);
	
	void insert(UserModel user);
	boolean register(String email, String password, String username, String
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	void UpdatePsw(String Username, String NewPass);
}
