<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>main page</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
  </head>
  <body>
  	<div class="container">
			<h3>회원 관리</h3>
			<ul>
				<c:choose>
					<c:when test="${empty id }">
						<li><a href="users/loginform.do">로그인</a></li>
						<li><a href="users/insertform.do">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<p><strong>${id }</strong> 님 로그인중<a href="users/logout.do">&nbsp;&nbsp;로그아웃</a></p>
					</c:otherwise>
				</c:choose>
				<li><a href="users/list.do">회원 목록</a></li>
			</ul>
		</div>
  </body>
</html>