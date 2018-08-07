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
			<div class="panel panel-primary text-center">
				<div class="panel-heading">
					<h3>회원 로그인</h3>
				</div>
				<br />
				<div class="panel-body">
					<form action="login.do?url=${url }" method="post" id="loginForm">
						<div class="form-group-row">
							<label for="id" class="col-sm-2 col-form-label">사용자 ID: </label>
							<div class="col-sm-10">
								<input type="text" name="id" id="id" class="form-control" />
							</div>
						</div>
						<div class="form-group-row">
							<label>&nbsp;</label>
						</div>
						<div class="form-group-row">
							<label for="pwd" class="col-sm-2 col-form-label">비밀번호: </label>
							<div class="col-sm-10">
								<input type="password" name="pwd" id="pwd" class="form-control" />
							</div>
						</div>
						<div class="form-group-row">
							<label>&nbsp;</label>
						</div>
						<div class="form-group-row">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-default">로그인</button>
							</div>
						</div>
					</form>
				</div>
				<br />
			</div>
			<p id="info"></p>
		</div>
  </body>
</html>