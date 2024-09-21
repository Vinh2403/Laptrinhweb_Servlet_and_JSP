<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/WebProg_chieut2/login" method="post">
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>

		<div class="container">
			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="uname" > <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" >

			<button type="submit">Login</button>
			<label> <input type="checkbox" 
				name="remember"> Remember me
			</label>
		</div>

		<div class="container" style="background-color: #7F7F7F">
			<span class="psw"> <a href="/WebProg_chieut2/ForgotPassword">Forgot password?</a></span>
			<button type="button" onclick="window.location.href='/WebProg_chieut2/register';">Sign Up</button>

		</div>
	</form>
</body>
</html>