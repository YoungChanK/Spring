<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/member.js"></script>

</head>
<body>
<h1>회원가입 폼</h1>
<form action ="/chan/member/member" method="post">
<table>
	<tr>
		<td>
			<label>아이디</label><br>
			<input type = "text" name="userid" id="userid">
			<label id="idmsg"></label>
			<button id="idcheck">ID중복체크</button>
			<label id="idcmsg"></label>
		</td>
	</tr>
	<tr>
		<td>
			<label>비밀번호</label><br>
			<input type = "password" name="userpw"id="userpw">
			<label id="pwmsg"></label>
		</td>
	</tr>
	<tr>
		<td>
			<label>비밀번호 재확인</label><br>
			<input type = "password" name="re_userpw" id="re_userpw">
			<label id="re_pwmsg"></label>
		</td>
	</tr>
	<tr>
		<td>
			<label>이름</label><br>
			<input type = "text" name="username">
		</td>
	</tr>
	<tr>
		<td>
			<label>Email</label><br>
			<input type = "text" name="email">
		</td>
	</tr>
	<tr>
		<td>
		
			<input type = "submit" value="전송">
		</td>
	</tr>

</table>
</form>
</body>
</html>