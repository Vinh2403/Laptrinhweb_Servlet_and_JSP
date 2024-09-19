package bai2_ConnectDB.web.services;

import bai2_ConnectDB.web.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel findByUserName(String username);
	
}
