package bai2_ConnectDB.web.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bai2_ConnectDB.web.config.DBConnectSQL;
import bai2_ConnectDB.web.dao.IUserDao;
import bai2_ConnectDB.web.models.UserModel;

public class UserDaoImpl extends DBConnectSQL implements IUserDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				//public UserModel(int id, String username, String email, String passwd, String fullname, String image,
				//String role_id, String phoneNo, Date create_date) 
				list.add(new UserModel( rs.getString("username"), rs.getString("email"), rs.getString("passwd"),rs.getString("fullname"),rs.getString("img")));
			}
			return list;
					
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users( username, email, passwd, fullname, img, roleid, phone, createdate) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPasswd());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImage() );
			ps.setInt	(6, user.getRole_id());
			ps.setString(7, user.getPhoneNo());
			ps.setDate	(8, user.getCreate_date());
			ps.executeUpdate();
//			
			
			
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
//	public static void main(String[] args)
//	{
//		UserDaoImpl userDao = new UserDaoImpl();
//	//	userDao.insert(new UserModel("tanthc", "tan123@gmail.com", "1224","tang huynh chi tan","https://myimg2.com"));
//		
////		List<UserModel> list = userDao.findAll();
////		if(list != null)
////			for (UserModel user : list)
////			{
////					System.out.println(user);
////			}
//		UserModel user = userDao.findByUserName("Vinh");
//		System.out.println(user);
//	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM  users WHERE username = ?";
		
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql); 			//
			
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next())
			{
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPasswd(rs.getString("passwd"));
				user.setImage(rs.getString("img"));
				user.setRole_id(rs.getInt("roleid"));
				user.setPhoneNo(rs.getString("phone"));
				user.setCreate_date(rs.getDate("createdate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn != null && !conn.isClosed()) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;		//biến cờ hiệu cho biết có bị trùng email đã tồn tại hay không.
		String query = "SELECT * FROM users WHERE email = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);			//1 la so thu tu cua cac tham so (Cai dau ? tren tinh tu trai sang phai 1->n)
			rs = ps.executeQuery();
			if (rs.next()) {
			duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;

		UserModel user = findByUserName(username);
		if(user != null ) duplicate = true;
		return duplicate;
		
	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "SELECT * FROM users WHERE phone = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
			duplicate = true;
			}
			ps.close();
			conn.close();
			} catch (Exception ex) {}
			return duplicate;

	}

	@Override
	public void UpdatePasswd(String Username, String NewPassword) {
		String sql = "UPDATE users SET passwd = ? WHERE username = ?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, NewPassword );
			ps.setString(2, Username);
			
			ps.executeUpdate();
//			
			
			
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
		
}
