/**
 * 
 */

//read.jsp가 준비가 되면 실행하라
$(document).ready(function(){
	//form의 role이 form인것을 선택
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	//클릭한것의 action과 method를  변겅
	$(".btn-warning").on("click",function(){
	  //formObj.attr("action")일떈 action의 값을 가져오는 getter
	  //formObj.attr("action","/board/modify")처럼 두가지가 채워져있을경우 setter
		formObj.attr("action","/chan/board/modify");
		formObj.attr("method","get");
		formObj.submit();
		
	});
	$(".btn-danger").on("click",function(){
		formObj.attr("action","/chan/board/remove");
		formObj.attr("method","post");
		formObj.submit();
	});
	$(".btn-primary").on("click",function(){
		href.location = "/chan/board/list";
	});
})