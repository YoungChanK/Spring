/**
 * 
 */
$(document).ready(function(){
	$(".fileDrop").on("dragenter dragover",function(e){
		e.preventDefault();
//		alert("drag");
	});
	
	$(".fileDrop").on("drop",function(e){
		e.preventDefault();
//		alert("drag");
		var files = e.originalEvent.dataTransfer.files;
		var formData = new FormData(); //uploadAjax.jsp에 form태그가 없다. 대체할 무언가가 필요한데 , FormData()
		
		for(var i=0; i<files.length;i++){
			
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
			dataType:"text",
			//processData 와 contentType은 파일업로드시 false가 되어야함.
			processData:false,
			contentType:false,
			type:'POST',
			success:function(data){
				console.log(data);
				alert(data);
			}
		})
		
	});
	
	
})
