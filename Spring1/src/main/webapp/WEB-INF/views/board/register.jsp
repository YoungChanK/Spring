<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/register.js"></script>
<link  rel="stylesheet" type="text/css" href="../resources/css/register.css">

</head>
<body>
<h1>게시판 글쓰기화면. ${result}</h1>
<form role="form" action="/chan/board/register" method ="post">

	제목 :   <input type="text" name="title">
	내용 :   <textarea name="content"></textarea>
	작성자 : <input type="text" name="writer">
	<input type="submit" value="글쓰기">
   <button type="button" onclick="location.href='list'">목록</button>
</form>

<div class="fileDrop">파일 업로드 Drag  Drop</div>


<!-- 파일업로드 drag&drop 결과 이미지 list -->
<div class="uploadResult">




<ul>

</ul>
</div>

</body>
</html>