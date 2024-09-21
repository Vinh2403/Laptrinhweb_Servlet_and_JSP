package bai2_ConnectDB.web.controller.admins;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/admin/home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession(false);  // Lấy session hiện tại, nếu không tồn tại thì không tạo mới
	if (session != null && session.getAttribute("account") != null) {
		// Nếu session có tồn tại và người dùng đã đăng nhập, tiếp tục cho phép truy cập trang admin
		req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
		return;
	}


	// Nếu không có session và cookie hợp lệ, chuyển hướng người dùng về trang login
	resp.sendRedirect(req.getContextPath() + "/login");
}
}
