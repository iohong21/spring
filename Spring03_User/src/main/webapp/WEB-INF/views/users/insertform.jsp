<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
  </head>
  <body>
  	<div class="container">
			<h3>회원가입 폼</h3>
			<form action="insertform.do" method="post">
			  <div class="form-group">
			    <label for="id">사용자:</label>
			    <input type="text" class="form-control" id="id" name="id">
			  </div>
			  <div class="form-group">
			    <label for="pwd">비밀번호: </label>
			    <input type="password" class="form-control" id="pwd" name="pwd">
			  </div>
			  <div class="form-group">
			    <label for="name">성명: </label>
			    <input type="text" class="form-control" id="name" name="name">
			  </div>
			  <div class="form-group">
			    <label for="phone">전화번호: </label>
			    <input type="text" class="form-control" id="phone" name="phone">
			  </div>
			  <div class="form-group">
			    <label for="email">이메일: </label>
			    <input type="text" class="form-control" id="email" name="email">
			  </div>
			  <div class="form-group">
			    <label for="addr">주소: </label>
			    <input type="text" class="form-control" id="addr" name="addr">
			  </div>
			  <button type="submit" class="btn btn-default">회원가입</button>
			</form>			
		</div>
  </body>
</html>