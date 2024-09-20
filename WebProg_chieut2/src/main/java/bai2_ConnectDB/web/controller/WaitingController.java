package bai2_ConnectDB.web.controller;

import java.io.IOException;

import bai2_ConnectDB.web.models.UserModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/waiting" })
public class WaitingController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			UserModel u = (UserModel) session.getAttribute("account");
			req.setAttribute("username", u.getUsername()); //lưu tên người dùng vào request để truyền thông tin này tới một trang JSP hoặc servlet khác, nơi nó có thể được sử dụng (thường là để hiển thị).
			if (u.getRole_id() == 2) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else if (u.getRole_id() == 3) {
				RequestDispatcher rd = req.getRequestDispatcher("/manager/home");
				rd.forward(req, resp);
				resp.sendRedirect(req.getContextPath() + "/manager/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
	//waiting khoi can doPost

}
