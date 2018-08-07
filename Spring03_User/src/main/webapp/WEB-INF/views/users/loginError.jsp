<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
  <head>
	  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <title>로그인 오류</title>
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
  </head>
  <body>
  	<div class="container">
  		<div class="panel panel-primary text-center">
  			<div class="panel-heading">
					<h2>로그인 오류</h2>
				</div>
				<div class="panel-body">
					<div class="form-group-row">&nbsp;</div>
					<div class="form-group-row">
						<p><strong>사용자 ID 또는 비밀번호가 잘못되었습니다.</strong></p>
					</div>
					<div class="form-group-row">&nbsp;</div>
					<div class="form-group-row">&nbsp;</div>
					<div class="form-group-row">
						<a href="loginform.do?url=${url }" class="col-sm-6">로그인</a>
						<a href="${pageContext.request.contextPath}/home.do" class="col-sm-6">홈</a>
					</div>
				</div>
			</div>
		</div>
  </body>
</html>