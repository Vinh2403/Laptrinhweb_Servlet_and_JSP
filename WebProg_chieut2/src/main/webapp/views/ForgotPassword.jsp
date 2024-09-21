<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 300px;
	margin: 0 auto;
	padding-top: 50px;
}

h1 {
	text-align: center;
}

form {
	display: flex;
	flex-direction: column;
}

input[type="text"], input[type="email"], input[type="password"] {
	margin-bottom: 15px;
	padding: 10px;
	font-size: 16px;
	width: 100%;
}

button {
	padding: 10px;
	font-size: 16px;
	background-color: #007BFF;
	color: white;
	border: none;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}

.error {
	color: red;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Đổi mật khẩu</h1>

		<!-- Hiển thị thông báo lỗi nếu có -->
		<c:if test="${not empty error}">
			<p class="error">${error}</p>
		</c:if>

		<form action="ForgotPassword" method="post">
			<label for="username">Tên đăng nhập:</label> <input type="text"
				id="username" name="username" placeholder="Nhập tên đăng nhập"
				required> 
			<label for="NewPass">New Password:</label> <input
				type="password" id="passwd" name="Newpassword" placeholder="Nhập password mới"
				required>
			<label for="ConfirmNewPass">Confirm New Password:</label> <input
				type="password" id="passwd" name="Confirmpassword" placeholder="Xác nhận lại password mới"
				required>
			<button type="submit">Đổi mật khẩu</button>
		</form>
	</div>
</body>
</html>
