<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/read.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form role="form" >
	<input type="hidden" name="bno" value="${read.bno}">
<table border ="1">
	<tr>
		<td colspan="2">${read.title}</td>
	</tr>
	<tr>
		<td>${read.writer}</td>
		<td>${read.viewcnt}</td>
	</tr>
	<tr>
		<td colspan="2">${read.content}</td>
	</tr>
	<tr>
		<td>제목</td>
	</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn-warning">수정</button> 
				<button type="submit" class="btn-danger">삭제</button> 
				<button type="submit" class="btn-primary">목록</button>
			</td>
		</tr>
	</table>
	댓글 설정
</form>
</body>
</html>