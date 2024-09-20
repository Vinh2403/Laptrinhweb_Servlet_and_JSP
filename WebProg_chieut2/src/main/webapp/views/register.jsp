<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
	<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0 auto;
        max-width: 400px;
    }

    form {
        padding: 20px;
        background-color: #f9f9f9;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
    }

    .input-group {
        margin-bottom: 15px;
        display: flex;
        align-items: center;
    }

    .input-group-addon {
        padding: 10px;
        background-color: #eee;
        border: 1px solid #ddd;
        border-right: none;
        border-radius: 5px 0 0 5px;
    }

    .input-group input {
        flex: 1;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 0 5px 5px 0;
        outline: none;
    }

    .input-icon {
        margin-right: 10px;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #28a745;
        border: none;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }

    button:hover {
        background-color: #218838;
    }

    .bottom-text {
        margin-top: 20px;
        text-align: center;
    }

    .bottom-text a {
        color: #007bff;
        text-decoration: none;
    }

    .bottom-text a:hover {
        text-decoration: underline;
    }
    </style>
</head>
<body>
	<form action="/WebProg_chieut2/register" method="post">
		<h2>Tạo tài khoản mới</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="user name" name="username"
						class="form-control">
				</div>

				<div class="input-group">
					<span class="input-group-addon"> <i class="fas fa-id-card input-icon"></i></span>  <input type="text"
						placeholder="Họ và tên" name="fullname" required>
				</div>
				<div class="input-group">
					<span class="input-group-addon"> <i class="fas fa-envelope input-icon"></i> </span> <input type="email"
						placeholder="Nhập Email" name="email" required>
				</div>
				<div class="input-group">
				<span class="input-group-addon">	<i class="fas fa-phone input-icon"></i> </span> <input type="tel"
						placeholder="Số điện thoại" name="phone" required>
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i class="fas fa-lock input-icon"></i></span> <input type="password"
						placeholder="Mật khẩu" name="password" required>
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i class="fas fa-lock input-icon"></i> </span><input type="password"
						placeholder="Nhập lại mật khẩu" name="confirm_password" required>
				</div>
				
				
				<button type="submit">Tạo tài khoản</button>
				<div class="bottom-text">
					Nếu bạn đã có tài khoản? <a href="/WebProg_chieut2/login">Đăng nhập</a>
				</div>
			</label>
		</section>
</body>
</html>