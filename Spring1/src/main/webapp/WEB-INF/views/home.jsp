<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="UTF-8">
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h1>
	Hello world!  
	home Test
	
</h1>

<P> ${str} 으로 이동</P>
<P> ${login.username}님 오신걸 환영합니다  </P>
<div>
<%@ include file="uploadForm.jsp" %>
</div>
</body>
</html>
