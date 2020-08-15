<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정화면 입니다. </h1>
<c:if test="${msg}.eq 'SUCCESS'}">
<script>
	alert("수정되었습니다.");
</script>
</c:if>
${msg}
<form action="/chan/board/modify" method ="post">
	<input type="hidden" name="bno" value="${modify.bno}">
	제목 :   <input type="text" name="title" value="${modify.title}">
	내용 :   <textarea name="content" >${modify.content}</textarea>
	작성자 : <input type="text" name="writer" value="${modify.writer}" readonly>

	<input type="submit" value="글수정">

</form>
</body>
</html>