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
		
				if(!obj.image){
					//이미지 파일이면(image:false)
					str+="<li><img src='resources/image/attach.jpg'>"+obj.fileName+"</li>";
				}else{
					//이미지 파일이 아니면
					var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					str+="<li><img src='/chan/display?fileName="+fileCallPath+"'></li>";
				}

			})
			$(".uploadResult ul").append(str);
		
	}
	
	
	$(".fileDrop").on("dragenter dragover",function(e){
		e.preventDefault();
//		alert("drag");
	});
	
	$(".fileDrop").on("drop",function(e){
		e.preventDefault();
//		alert("drag");
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
			}
		})
	
		
	});
	
	
})
