
$(document).ready(function(){
	//blre이벤트 : 포커스를 잃었을떄 발생하는 이벤트
	//keyup 이벤트 : 사용자가 키보드를 눌렀을떄
	$("#userid").on("blur",function(){
//		alert("aaaaaa");
		//아이디 유효성 검사    /^[]$/  -> []안에 식을 넣기
		//영문+숫자 조합 , 총 길이는 4~12자
		var idreg=/^[a-zA-Z0-9]{4,12}$/; //ID 유효성검사를 위한 정규식
		var idVal=$("#userid").val();	//사용자가 jsp에서 input에 입력한 값
		//비밀번호 유효성검사(대문자+소문자+숫자+특수문자 모두 포함하여 8자이상
		//?=.*? 최소하나 . 최대 * 전부까지 사용해라
		if(idreg.test(idVal)){	//입력한  ID값이 정규식과 맞으면
		
			$("#idmsg").html("앙 기모리한 아이디네요?")
		}else{
			alert("ID 다시 입력")
		}
	
	})
	//비밀번호 blur이벤트 시작
	$("#userpw").on("blur",function(){
		var pwreg=/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$^&*-]).{8,}$/;
		var pwVal=$("#userpw").val();
		
		if(pwreg.test(pwVal)){	//입력한  ID값이 정규식과 맞으면
			
			$("#pwmsg").html("앙 기모리한 비밀번호네요?")
		}else{
			$("#pwmsg").html("대 ,소문자 숫자 특수문자 포함 8자이상 입력하시요")
		}
	})
	$("#re_userpw").on("blur",function(){
		var pwVal=$("#userpw").val();
		var re_pwVal=$("#re_userpw").val();

		if(pwVal==re_pwVal){
			$("#re_pwmsg").html("같네?")
		}else{
			$("#re_pwmsg").html("앙 기모리한 비밀번호가 다르네요네요?")
		}
	})
	$("#idcheck").on("click",function(){
		var idVal=$("#userid").val();
		
		 $.ajax({
		        type:"POST",
		        url:"/chan/member/idCheck",
		        data:{
		               "userid":$('#userid').val()
		        },
		        success:function(data){   //data : idCheck에서 넘겨준 결과값
		         var userId = $('#userid').val()
		         var idcmsg = $('#idcmsg')
		         console.log(userId)
		               if(data=="YES"){ // 사용가능할때
		                  if(userId != ''){ 
		               idcmsg.html('사용가능')
		                  }
		                 }else{ // 계정 존재할떄
		                  if(userId !=''){
		               idcmsg.html('사용불가')
		                  }
		               }
		            }
		 
		       }) // ajax
	})

})