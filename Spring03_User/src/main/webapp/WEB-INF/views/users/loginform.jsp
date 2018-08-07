<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>회원 로그인</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
  </head>
  <body>
		<div class="container">
			<h3>회원 로그인</h3>
			<form action="login.do" method="post" id="loginForm">
				<label for="id">사용자 ID: </label>
				<input type="text" name="id" id="id" />
				<br />
				<label for="pwd">비밀번호: </label>
				<input type="password" name="pwd" id="pwd" />
				<br />
				<button type="submit">로그인</button>
			</form>
		</div>
  </body>
</html>