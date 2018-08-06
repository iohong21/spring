<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<a href="insertform.do">회원추가 폼</a>
		<h3 class="text-center">회원 목록 입니다</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>주소</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list }"	>
					<tr>
						<td>${tmp.num }</td>
						<td>${tmp.name }</td>
						<td>${tmp.addr }</td>
						<td><a href="updateform.do?num=${tmp.num }">수정</a></td>
						<td><a href="javascript: deleteConfirm(${tmp.num })">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<script>
	function deleteConfirm(num) {
		var isDelete = confirm("삭제 하시겠습니까?");
		if(isDelete) {
			location.href = "delete.do?num="+num;
		}
	}
</script>
</body>
</html>