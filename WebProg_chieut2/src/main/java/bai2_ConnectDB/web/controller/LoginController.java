package bai2_ConnectDB.web.controller;

import java.io.IOException;

import bai2_ConnectDB.web.models.UserModel;
import bai2_ConnectDB.web.services.IUserService;
import bai2_ConnectDB.web.services.impl.UserServiceImpl;
import bai2_ConnectDB.web.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	IUserService service = new UserServiceImpl();		//de global de dung trong tat ca cac method.

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
		resp.sendRedirect(req.getContextPath()+ "/waiting");
		return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
		for (Cookie cookie : cookies) {
		if (cookie.getName().equals("username")) {
		session = req.getSession(true);
		session.setAttribute("username", cookie.getValue());
		resp.sendRedirect(req.getContextPath()+ "/waiting");
		return;
			}
		}
		}
		req.getRequestDispatcher("views/login.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. encoding cho trang web hien thi tieng viet:
		resp.setContentType("text/html");
		 resp.setCharacterEncoding("UTF-8");
		 req.setCharacterEncoding("UTF-8");

		//2. Lay tham so tu view:
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");
		//3. Kiem tra tham so
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		//4. Xu ly bai toan Login:
		UserModel user = service.login(username, password);
						//session luu thong tin khi login
		if(user!=null){
			 HttpSession session = req.getSession(true);
			 session.setAttribute("account", user);	//luu doi tuong user vao phien lam viec voi thuoc tinh la account. Dieu nay cho phep truy cap thong tin nguoi dung trong cac request tiep theo ma ko can login lai
			 if(isRememberMe){
			 saveRemeberMe(resp, username);
			 }

			 resp.sendRedirect(req.getContextPath()+"/waiting");
			 }
		else{
			 alertMsg =
					 "Tài khoản hoặc mật khẩu không đúng";
			 req.setAttribute("alert", alertMsg);
			 req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			 }
		
			 }
	private void saveRemeberMe(HttpServletResponse resp, String username) {
			Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
			cookie.setMaxAge(30*60);		//Thoi gian song cua cookie
			resp.addCookie(cookie);
		 
			}
		
	}

