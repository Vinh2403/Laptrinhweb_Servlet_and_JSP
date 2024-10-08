package bai2_ConnectDB.web.controller;

import java.io.IOException;

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

//@SuppressWarnings("serial") de no ko bao warning khi minh ko cho cai serialversionUID vao. Nhung thoi hien tai minh ko dung de giong may cai controller kia
@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

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
		req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");

		IUserService service = new UserServiceImpl();
		String alertMsg = "";
		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}
		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}
		
		boolean isSuccess = service.register(email, password, username, fullname, phone);
		if (isSuccess) {
			// SendMail sm = new SendMail();
			// sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login
			// to use service. Thanks !");
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
		}
	}

}
