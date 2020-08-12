<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 글쓰기화면. ${result}</h1>
<form action="/chan/board/register" method ="post">
	제목 :   <input type=text" name="title">
	내용 :   <textarea name="content"></textarea>
	작성자 : <input type=text" name="writer">

	<input type="submit" value="글쓰기">

</form>
</body>
</html>