/**
 * 
 */
$(document).ready(
		function() {
			// 댓글 전체 리스트(페이징 처리된것)
			var bnovalue =$("#bno").val();
			var bno = bnovalue ;// 게시판번호
			var page = 1; // 페이지번호
			
			getAllList();
			getAllList(page);
			function getAllList(){
				$("#modDiv").hide();
				
				var str = "";
			// method 방식이 get인 ajax 시작($.getJSON )
			// $.getJSON(서버URL[,데이터][,성공]
			$.getJSON("/chan/replies/all/" + bno + "/" + page, function(data) {
				console.log(data);
				//댓글 리스트
				$(data.list).each(
						function() {
						      str += "<li data-rno='" + this.rno + "' class='replyLi'>"
					            // <li data-rno= : 문자열 // this.rno : 지금 현재 위치의 rno
					            // this를 붙이지 않으면 어떤걸 선택했는지 모른다.
					            + this.rno + ":" + this.replytext + "<button>MOD</button></li>"
							/* str = <li data-rno =8 class= replyLi>8:댓글</li> */
							/* str = <li data-rno =7 class= replyLi>7:댓글</li> */
							/* str = <li data-rno =6 class= replyLi>6:댓글</li> */
							/* str = <li data-rno =5 class= replyLi>5:댓글</li> */
							/* str = <li data-rno =4 class= replyLi>4:댓글</li> */
						});
				//댓글 페이징
				console.log("전체 댓글 수 ="+data.replycnt);
				//endNum
		
				var endNum=Math.ceil(page/10.0)*10;
				var startNum=endNum-9;
				var prev=startNum>1;
				var next=false;
				if(endNum*10>=data.replycnt){
					endNum=Math.ceil(data.replycnt/10.0);
				}
				if(endNum*10<data.replycnt){
					next=true;
				}
				var pagestr="";
				//페이징 이전
				console.log(next);
				if(prev){
					pagestr+="<li><a href='"+(startNum-1)+"'>이전</a></li>"
					console.log("aaaaaaaaaa");
				}
				for(var i =startNum;i<=endNum;i++){
					var active = page==i?"active":"";
					pagestr+="<li class ='page-item"+active+"'><a href='"+i+"'>"+i+"</a></li>";
				}
				//페이징 다음
				if(next){
					pagestr+="<li><a href='"+(startNum-1)+"'>다음</a></li>"
				}
				$("#replyPage").html(pagestr);

				$("#replies").html(str);
			})
			}
			
			$("#replyPage").on("click","li a",function(e){
				e.preventDefault();//이벤트취소
				var targetPageNum=$(this).attr("href"); //<a href ="1">1</a>
				page=targetPageNum;
				getAllList(page);
			
			
			
			})
			
			
			
			
			$("#replyAddBtn").on("click", function() {
				var replyer = $("#newReplyWriter").val();
				var replytext = $("#newReplyText").val();
				console.log(replyer);
				console.log(replytext);
				/*
				 * $ajax({ (필수)type : 데이터 전송방식(post.put.delete) (필수)url :
				 * 서버주소(controller) headers : 서버에 데이터 전송 타입 dataType
				 * :Controller에서 데이터를 보내주는 타입. (필수)data : 실제 서버에 보내는 데이터 success :
				 * 서버 전송이 성공 했을때 error : 서버 전송 할 시 에러 났을때
				 */
				$.ajax({
					type : "post",
					url : "/chan/replies",
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "POST"
					},
					dataType : "text",
					data : JSON.stringify({
						bno : bno,
						replytext : replytext,
						replyer : replyer
					}),
					success : function(result) {
						if (result == 'SUCCESS') {
							alert("등록 되었습니다");
							getAllList();
						}
					}
				
				}); //댓글쓰기 ajax end
			})//버튼 클릭 이벤트 end
			//수정버튼을 클릭했을때
			$("#replies").on("click",".replyLi button",function(){
				
				var reply=$(this).parent();
				console.log(reply);
				var rno=reply.attr("data-rno");
				console.log(rno);
				var replytext=reply.text();
//				alert(rno+" : "+replytext);
				$(".modal-title").html(rno);
				$("#replytext").val(replytext);
				$("#modDiv").show("slow");
				
			})
			//삭제 버튼 클릭했을 때
			$("#replyDelBtn").on("click",function(){
				var rno = $(".modal-title").html(); //rno값을 가져오기
				//var replytext = $("#replytext").val();
				console.log(rno);
				$.ajax({
					type : "delete",
					url : "/chan/replies/"+rno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "DELETE"
					},
					dataType : "text",
					success : function(result) {
						console.log("result:" + result);
						if (result == 'SUCCESS') {
							alert("삭제 되었습니다");
							$("#modDiv").hide("slow");
							getAllList(page);
						}
					}
				})
			})
			//수정 버튼 클릭이벤트
						$("#replyModBtn").on("click",function(){
				var rno = $(".modal-title").html(); //rno값을 가져오기
				var replytext = $("#replytext").val(); //댓글내용 가져오기
				console.log(rno);
				$.ajax({
					type : "put",
					url : "/chan/replies/"+rno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "PUT"
					},
					data : JSON.stringify({
						replytext : replytext,
					}),
					dataType : "text",
					success : function(result) {
						console.log("result:" + result);
						if (result == 'SUCCESS') {
							alert("수정 되었습니다");
							$("#modDiv").hide("slow");
							getAllList(page);
						}
					}
				})
			})
		})







