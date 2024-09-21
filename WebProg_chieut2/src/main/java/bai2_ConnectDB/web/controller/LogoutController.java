package bai2_ConnectDB.web.controller;

import java.io.IOException;

import bai2_ConnectDB.web.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet{

	private static final long serialVersionUID = 1L;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// Hủy session
    HttpSession session = req.getSession();
    session.removeAttribute("account");
    Cookie[] cookies = req.getCookies();
    if(cookies != null)
    {
    	for (Cookie cookie : cookies)
    	{
    		if(Constant.COOKIE_REMEMBER.equals(cookie.getName()))
    		{
    			cookie.setMaxAge(0);	//<=> remove cookie
    			resp.addCookie(cookie);	// add again
    			break;
    		}
    	}
    }
    // Chuyển hướng về trang login sau khi logout
    resp.sendRedirect(req.getContextPath() + "/login");
}
}
