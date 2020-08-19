<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="resources/js/ajaxtest.js"></script>
</head>
<body>
	<div id="modDiv">
		<div class ="modal-title"></div>
		<div><input type ="text" id="replytext"></div>
		<div>
			<button type ="button" id="replyModBtn">수정</button>
			<button type ="button" id="replyDelBtn">삭제</button>
			<button type ="button" id="closeBtn">닫기</button>
		
		</div>
	</div>
<h2>Ajax Test page</h2>



<div>
	<div>
		작성자 : <input type="text" name ="replyer" id="newReplyWriter">
	</div>
	<div>
		댓글내용 : <input type="text" name ="replytext" id="newReplyText">
	</div>
	<button id="replyAddBtn">댓글 등록</button>
</div>

<ul id="replies">

</ul>
</body>
</html>