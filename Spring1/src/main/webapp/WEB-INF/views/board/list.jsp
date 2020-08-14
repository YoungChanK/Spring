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
<c:choose>
	<c:when test="${msg eq 'SUCCESS'}">
		<script>
			alert("수정되었습니다.")
		</script>
	</c:when>
	<c:when test="${msg eq 'DSUCCESS'}">
		<script>
			alert("삭제되었습니다.")
		</script>
	</c:when>
</c:choose>
<table border ="1">
	<tr>
		<td colspan="2">제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회</td>
	</tr>
	<c:forEach items="${list}" var="board">
	<tr>
		<td>${board.bno}</td>
		<td><a href = "/chan/board/read?bno=${board.bno}">${board.title}</a></td>
		<td>${board.writer}</td>
		<td>${board.regdate}</td>
		<td>${board.viewcnt}</td>
	</tr>
	</c:forEach>
	
	<tr>	
		<td colspan="5"><button type="button" onclick="location.href='register'">글쓰기</button></td>
		
	</tr>
	

</table>
<%--  <c:forEach var ="num" begin="${PageMaker.startPage}"
						 end="${PageMaker.endPage}">
	<a href="/chan/board/list?pageNum=${num}">${num}</a>
</c:forEach>  --%>
    <c:if test="${PageMaker.prev}">
      <a href="/chan/board/list?PageNum=${PageMaker.startPage-1}&type=${PageMaker.cri.type}&keyword=${PageMaker.cri.keyword}">이전</a>
   </c:if> 
   <c:forEach var="num" begin="${PageMaker.startPage}" end="${PageMaker.endPage}">
      <a href="/chan/board/list?PageNum=${num}&type=${PageMaker.cri.type}&keyword=${PageMaker.cri.keyword}">${num}</a>
   </c:forEach>
   <c:if test="${PageMaker.next}">
      <a href="/chan/board/list?PageNum=${PageMaker.endPage+1}&type=${PageMaker.cri.type}&keyword=${PageMaker.cri.keyword}">다음</a>
   </c:if>



	<form action="/chan/board/list?keyword=${pageMaker.vo.keyword} "
		method="get">
		<select name="type">
			<option value="T" <c:out value="${PageMaker.cri.type eq 'T'?'selected':''}"/>>제목
			<option value="C" <c:out value="${PageMaker.cri.type eq 'C'?'selected':''}"/>>내용
			<option value="W"<c:out value="${PageMaker.cri.type eq 'W'?'selected':''}"/>>작성자
			<option value="TC"<c:out value="${PageMaker.cri.type eq 'TC'?'selected':''}"/>>제목+내용
			<option value="TCW" <c:out value="${PageMaker.cri.type eq 'TCW'?'selected':''}"/>>제목+내용+작성자
		</select> <input type="text" name="keyword"> <input type="submit"
			value="검색">
	</form>
</body>
</html>