package bai2_ConnectDB.web.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		//Khai bao cac truong trong db.
	//tao constructor
		
		public UserModel() {
			super();
		}
		public UserModel( String username, String email, String passwd, String fullname, String image,
				int role_id, String phoneNo, Date create_date) {
			super();
			this.username = username;
			this.email = email;
			this.passwd = passwd;
			this.fullname = fullname;
			this.image = image;
			this.role_id = role_id;
			this.phoneNo = phoneNo;
			this.create_date = create_date;
		}
		
		public UserModel( String username, String email, String passwd, String fullname, String image) {
			super();
			this.username = username;
			this.email = email;
			this.passwd = passwd;
			this.fullname = fullname;
			this.image = image;
		}

		private int id;
		private String username;
		private String email;
		private String passwd;
		private String fullname;
		private String image;
		private int role_id;
		private String phoneNo;
		private Date create_date;
		//tao getter & setter
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPasswd() {
			return passwd;
		}
		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public int getRole_id() {
			return role_id;
		}
		public void setRole_id(int role_id) {
			this.role_id = role_id;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public Date getCreate_date() {
			return create_date;
		}
		public void setCreate_date(Date create_date) {
			this.create_date = create_date;
		}
		@Override
		public String toString() {
			return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", passwd=" + passwd
					+ ", fullname=" + fullname + ", image=" + image + ", role_id=" + role_id + ", phoneNo=" + phoneNo
					+ ", create_date=" + create_date + "]";
		}
		
		
	}
