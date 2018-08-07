<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>회원목록</title>
  </head>
  <body>
		<h3>회원 목록</h3>
		<table>
			<thead>
				<tr>
					<th>사용자ID: </th>
					<th>성명: </th>
					<th>전화번호: </th>
					<th>이메일: </th>
					<th>주소: </th>
					<th>등록일: </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }">
					<tr>
						<td>${dto.id }</td>
						<td>${dto.name }</td>
						<td>${dto.phone }</td>
						<td>${dto.email }</td>
						<td>${dto.addr }</td>
						<td>${dto.regdate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
  </body>
</html>