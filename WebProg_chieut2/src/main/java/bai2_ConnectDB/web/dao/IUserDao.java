package bai2_ConnectDB.web.dao;

import java.util.List;

import bai2_ConnectDB.web.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();		//lay toan bo user. Sau nay hoc JPA thi ngta viet san r
	UserModel findById(int id);	//Lay 1 user
	void insert(UserModel user);
	UserModel findByUserName(String username);	//dang nhap bang username
	
}
