<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드 화면 폼</h1>
<form action="uploadForm" method="post" enctype="multipart/form-data">
<input type="file" name="file" multiple>
<input type="submit">
</form>
</body>
</html>