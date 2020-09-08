/**
 * 
 */
$(document).ready(function(){
	//form의 role이 form인것을 선택
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	//클릭한것의 action과 method를  변겅
	$(".login").on("click",function(){
		formObj.attr("action","/chan/member/login");
		formObj.attr("method","get");
		formObj.submit();
		
	});
	$(".logout").on("click",function(){
		formObj.attr("action","/chan/member/logout");
		formObj.attr("method","post");
		formObj.submit();
	});
})
