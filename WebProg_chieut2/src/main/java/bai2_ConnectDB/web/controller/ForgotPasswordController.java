package bai2_ConnectDB.web.controller;

import java.io.IOException;

import bai2_ConnectDB.web.models.UserModel;
import bai2_ConnectDB.web.services.IUserService;
import bai2_ConnectDB.web.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/ForgotPassword"})
public class ForgotPasswordController extends  HttpServlet {

	IUserService service = new UserServiceImpl();	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set response type and encoding
	    resp.setContentType("text/html");
	    resp.setCharacterEncoding("UTF-8");
	    
	    // Forward the request to the forgot password JSP page
	    req.getRequestDispatcher("views/ForgotPassword.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String New_pass = req.getParameter("Newpassword");
		String ConfirmNew_pass = req.getParameter("Confirmpassword");
		boolean check = service.checkExistUsername(username) && New_pass.equals(ConfirmNew_pass);		//neu co ton tai username & password nhap xac nhan giong voi password tren.
		if(check)
		{
			service.UpdatePsw(username, New_pass);
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else
		{
			req.setAttribute("error", "Username không tồn tại trong hệ thống hoặc mật khẩu không khớp!");
			req.getRequestDispatcher("views/ForgotPassword.jsp").forward(req, resp);
		}

	}

}
