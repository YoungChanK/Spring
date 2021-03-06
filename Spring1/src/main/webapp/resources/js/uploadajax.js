/**
 * 
 */
$(document).ready(function(){
	// .뒤에 exe,sh,zip,alz 를 제한하겠다 ->파일형식 제한
	//정규식
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$")
	var maxSize=5242880;			//파일 사이즈(5MB)
	
	function checkExtension(fileName, fileSize){
		if(fileSize>=maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(regex.test(fileName)){
			alert("파일 업로드할수 없습니다");
			return false;
		}
		return true;
	}
	
	function shwoUploadFile(uploadResultArr){
		var str = "";

			//data는 배열 , for문과 같은 반복문을 이용해서 0~끝까지를 화면에 출력(each)
			$(uploadResultArr).each(function(i,obj){
				var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
				if(!obj.image){
					//이미지 파일이 아니면(image:false) - download 할수있도록..
//					var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					str+="<li><a href ='/chan/download?fileName="+fileCallPath+"'><img src='resources/image/attach.jpg'>"+obj.fileName+"</a></li>";
	
				}else{
					//이미지 파일이 아니면(image:ture) - display 웹에 이미지 출력..
					var sfileCallPath=encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName); //썸네일 파일명 보내기
//					str+="<li><img src='/chan/display?fileName="+fileCallPath+"'></li>";
					str += "<li><img src='/chan/display?fileName="+fileCallPath+"'>"+"<span data-file='"+sfileCallPath+"' data-type='image'>X</span>" + "</li>";  
				}

			})
			$(".uploadResult ul").append(str);
	
	}
	
	//drop 상황이 아니면 정지 
	$(".fileDrop").on("dragenter dragover",function(e){
		e.preventDefault();
//		alert("drag");
	});
	
	$(".fileDrop").on("drop",function(e){
//	$("#uploadBtn").on("click",function(e){
		e.preventDefault();
//		alert("drag");
		//drop한 모든 파일들의 정보를 가진 FileList 
		var files = e.originalEvent.dataTransfer.files;
//		console.log(files[0].name);
//		console.log(files[0].size);
		var formData = new FormData(); //uploadAjax.jsp에 form태그가 없다. 대체할 무언가가 필요한데 , FormData()
		for(var i=0; i<files.length;i++){
			if(!checkExtension(files[i].name,files[i].size)){
				return false;
			}
		formData.append("file",files[i]);
		}
//		var file = files[0];
//		console.log(file);
//		var file2 = files[1];
//		console.log(file2);
//		var file3 = files[2];
//		console.log(file3);
		
		$.ajax({
			url:"/chan/uploadajax",
			data:formData,
			dataType:"json",
			//processData 와 contentType은 파일업로드시 false가 되어야함.
			processData:false,
			contentType:false,
			type:'POST',
			success:function(data){
				console.log(data);
				shwoUploadFile(data);
				str="";
				  $(data).each(function(i, obj) {
	                     str += "<li>" + data[i].fileName + "</li>";
	                  })
	                  $(".uploadResult ul").append(str);
			

			}
		})
	
		
	})// drop 이벤트 end
	
	   $(".uploadResult").on("click", "span", function(e){
		      //alert("x를 클릭")
		   
		   var fileName = $(this).data("file")//파일명을 저장
		   var type=$(this).data("type")//이미지 파일
//		   alert(fileName);
//		   alert(type);
		   
		      $.ajax({
		         url : 'deleteFile',
		         data: {fileName:fileName,type:type}, //어떤파일 삭제해야 하는지(파일명),
		         dataType: 'text',
		         type: 'POST',
		         success: function(data){
		            alert(data);
		           
		         }
		      })
		      
		   })//x에 대한 click 이벤트end
		   
	$("#uploadBtn").on("click",function(e){
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		console.log(files);
		for(var i=0;i<files.length;i++){
			formData.append("uploadFile",files[i]);
		}
		$.ajax({
			//컨트롤러에 만들어줘야함
			url:"uploadAjaxAction",
			type:"post",
			
			//URL에 ? 뒤에 표시할건지
			processData:false,
			contentType:false, 
			data:formData,
			success:function(data){
				console.log(data);
				alert("uploaded")
			}
			
		})
		
		
	})
	
})
