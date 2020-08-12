/**
 * 
 */
alert("aaa");
//read.jsp가 준비가 되면 실행하라
$(document).ready(function(){
	//form의 role이 form인것을 선택
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	//클릭한것의 action과 method를  변겅
	$(".btn-warning").on("click",function(){
		formObj.attr("action","/board/modify");
		formObj.attr("method","get");
		formObj.submit();
	});
	$(".btn-danger").on("click",function(){
		formObj.attr("action","/board/remove");
		formObj.submit();
	});
	$(".btn-primary").on("click",function(){
		self.location = "board/listAll";
	});
})