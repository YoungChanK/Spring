package org.chan.test1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;



import org.chan.domain.AttachFileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
   
//   @Resource(name="uploadPath")
//   private String uploadPath;
   private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
   
   @RequestMapping(value = "uploadForm", method = RequestMethod.GET)
   public void uploadForm() {
      logger.info("파일 업로드 화면");
   }
   @RequestMapping(value = "uploadForm", method = RequestMethod.POST)
   public String uploadForm(MultipartFile[] file)throws Exception{
      for(MultipartFile miltipartFile : file) {
    	   String uploadPath="C:\\upload";
    	  
         logger.info("파일명 : "+miltipartFile.getOriginalFilename());
         logger.info("파일명 : "+miltipartFile.getSize());
         logger.info("파일명 : "+miltipartFile.getContentType());
         logger.info("파일 저장 위치 : "+uploadPath);
         

         
         File saveFile = new File(uploadPath,miltipartFile.getOriginalFilename());
         
         try {
            miltipartFile.transferTo(saveFile);
         }catch(Exception e) {
            logger.info(e.getMessage());
         }
      }
      
      return "redirect:/board/list";
   }
   //년/월/일 폴더 생성하는 getFolder()메소드
   //년월일 (날짜),오늘날짜를 어떻게 구할것인지 ?
   private String getFolder() {
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   Date date = new Date(); //오늘날짜를 date변수에 저장
   	String str=sdf.format(date);
   	System.out.println("오늘 날짜 := "+str); //str :2020-08-25 => 2020\\08\\25
   	
   	return str.replace("-",File.separator);
   }
   
   //이미지 파일을 판단할수 있게 하는 메소드
   	private boolean checkImageType(File file) {
   		try {
   			String contentType= Files.probeContentType(file.toPath()); //type을 받아오기
			return contentType.startsWith("image");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
   		return false;
   	}
   
   
   
   @RequestMapping(value = "uploadajax", method = RequestMethod.GET)
   public void uploadAjax() {
	   logger.info("파일 업로드  ajax 화면");
   }
   @ResponseBody
   @RequestMapping(value = "uploadajax", method = RequestMethod.POST,produces =MediaType.APPLICATION_JSON_UTF8_VALUE) //list타입사용시 media타입으로 변경
   public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] file) throws Exception {
	   logger.info("파일 업로드  ajax 화면");
	   String uploadPath="C:\\upload";
	   
	   //AttachFileDTO 클래스에 list배열로 생성
	   List<AttachFileDTO> list = new ArrayList<>();
	   
	   File uploadFolder=new File(uploadPath,getFolder());
	   logger.info("파일업로드 폴더"+uploadFolder);
	   //년월일 폴더 만들기
	   //exists() 메소드를 활용하여 생성하고자 하는 폴더가 존재하지 않으면 폴더를 만들어라.
	   if(uploadFolder.exists()==false) {
		   uploadFolder.mkdirs(); //mkdir메소드는 폴더를 만들어 주는 메소드
	   }	//make yyyy\\MM\\dd folder 
	   
	   
	   
	   for(MultipartFile multipartFile : file) {
	         
	         logger.info("파일명 : "+multipartFile.getOriginalFilename());
	         logger.info("파일크기 : "+multipartFile.getSize());
	         logger.info("파일종료 : "+multipartFile.getContentType());
	         logger.info("파일 저장 위치 : "+uploadPath);
	         
	         AttachFileDTO attach = new AttachFileDTO();
	    	  String fileName =multipartFile.getOriginalFilename(); //fileName
	    	  //AttachFileDTO 클래스에 fileName 변수에 파일이름 저장
	    	attach.setFileName(fileName);
	         
	         
	         String uploadFileName=multipartFile.getOriginalFilename();
	         UUID uuid=UUID.randomUUID();
	         uploadFileName = uuid+"_"+uploadFileName;
	         
//	         File saveFile = new File(uploadPath,multipartFile.getOriginalFilename()); //파일업로드 경로
	         
	         try {
	        	 File saveFile = new File(uploadFolder,uploadFileName); //파일업로드 경로
	        	 //그냥 파일 저장
	        	 multipartFile.transferTo(saveFile); //transferTo 폴더에 저장
	        	//AttachFileDTO 클래스에 setUploadPath변수에 날짜랑 이름 저장
	        	 attach.setUploadPath(getFolder());
	        	 System.out.println("getFolder"+getFolder());
	          	 //AttachFileDTO 클래스에 UUID변수에 저장
	        	 attach.setUuid(uuid.toString());
	        	 //파일 저장할때 이미지파일이면 썸내일 만들어서 저장
	        	 if(checkImageType(saveFile)) {
	        		 //업로드된 파일이 이미지라는 뜻
	        		 attach.setImage(true);
	        		 
	        		 FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder,"s_"+uploadFileName));
	        		 Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100, 100);
	        		 thumbnail.close();

	        	 }
	        	 
	        	 list.add(attach);
	        	 logger.info("list : "+list);
	         }catch(Exception e) {
	            logger.info(e.getMessage());
	         }
	      }
	   return new ResponseEntity<>(list,HttpStatus.OK);
   }
   
   
   
   	//display(업로드 파일이 이미지 인거)
   @RequestMapping(value = "display", method = RequestMethod.GET)
   public ResponseEntity<byte[]> getFile(String fileName) {
	   logger.info("fileName="+fileName);
	   File file= new File("C:\\upload\\"+fileName);
	   logger.info("file="+file);
	   ResponseEntity<byte[]> result=null;
	   
	   try {
		   HttpHeaders header = new HttpHeaders();
		   header.add("Content-Type",Files.probeContentType(file.toPath()));
		   result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
	} catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   return result;
   }
   //download(업로드 파일이 이미지가 아닌거)
   @RequestMapping(value = "download", method = RequestMethod.GET,produces =MediaType.APPLICATION_OCTET_STREAM_VALUE)
   public ResponseEntity<Resource> downloadFile(String fileName) throws Exception {
	   logger.info("download file : "+fileName);
	   Resource resource = new FileSystemResource("C:\\upload\\"+fileName);
	   logger.info("resource  : "+resource);
	   String resourceName=resource.getFilename();
	   HttpHeaders header = new HttpHeaders();
	   int uuidindex = resourceName.indexOf("_");
	   String OfileName= resourceName.substring(uuidindex+1);
	   logger.info("인덱스 위치 :"+ uuidindex);
	   logger.info("파일명 : "+ OfileName);
	   
	   
	   try {

		   header.add("Content-Disposition", "attachment; filename=" + new String(OfileName.getBytes("UTF-8"),"ISO-8859-1"));
		   
	} catch (UnsupportedOperationException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   return new ResponseEntity<Resource>(resource,header,HttpStatus.OK);
	   
   
   } //download end
   
   //파일 삭제 start
   //파일 삭제 end
   @RequestMapping(value = "deleteFile", method = RequestMethod.POST)
   public ResponseEntity<String> deleteFile(String fileName,String type) throws Exception{
	   logger.info("fileName :"+fileName);
	   logger.info("type : "+type);
	   
	   File file;

	   try {	
		   //경로에 있는 % 를 \ 로 변경
		   file = new File("C:\\upload\\"+URLDecoder.decode(fileName,"UTF-8"));
		   //썸내일 이미지 파일 삭제
		   file.delete();
		   if(type.equals("image")) {
			   //절대경로에 있는 파일의 s_를 제거
			   String originalFile=file.getAbsolutePath().replace("s_","");
			   file = new File(originalFile);
			   //원본 이미지 삭제
			   file.delete();

		   }
	} catch (UnsupportedOperationException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   
	   
	   
	   return new ResponseEntity<String>("deleted"/*ajax의 success:funcion(data)에 들어가서 출력*/,HttpStatus.OK/*통신이 성공했으면*/) ;
	   
   }
   @RequestMapping(value = "uploadAjaxAction", method = RequestMethod.POST)
   public void uploadAjaxPost1(MultipartFile[] file) throws Exception {
	   logger.info("파일 업로드  ajax Post 화면");
	   String uploadPath="C:\\upload";
	   
	   //AttachFileDTO 클래스에 list배열로 생성
	   List<AttachFileDTO> list = new ArrayList<>();
	   
	   File uploadFolder=new File(uploadPath,getFolder());
	   logger.info("파일업로드 폴더"+uploadFolder);
	   //년월일 폴더 만들기
	   //exists() 메소드를 활용하여 생성하고자 하는 폴더가 존재하지 않으면 폴더를 만들어라.
	   if(uploadFolder.exists()==false) {
		   uploadFolder.mkdirs(); //mkdir메소드는 폴더를 만들어 주는 메소드
	   }	//make yyyy\\MM\\dd folder 
	   
	   
	   
	   for(MultipartFile multipartFile : file) {
	         
	         logger.info("파일명 : "+multipartFile.getOriginalFilename());
	         logger.info("파일크기 : "+multipartFile.getSize());
	         logger.info("파일종료 : "+multipartFile.getContentType());
	         logger.info("파일 저장 위치 : "+uploadPath);
	         
	         AttachFileDTO attach = new AttachFileDTO();
	    	  String fileName =multipartFile.getOriginalFilename(); //fileName
	    	  //AttachFileDTO 클래스에 fileName 변수에 파일이름 저장
	    	attach.setFileName(fileName);
	         
	         
	         String uploadFileName=multipartFile.getOriginalFilename();
	         UUID uuid=UUID.randomUUID();
	         uploadFileName = uuid+"_"+uploadFileName;
	         
//	         File saveFile = new File(uploadPath,multipartFile.getOriginalFilename()); //파일업로드 경로
	         
	         try {
	        	 File saveFile = new File(uploadFolder,uploadFileName); //파일업로드 경로
	        	 //그냥 파일 저장
	        	 multipartFile.transferTo(saveFile); //transferTo 폴더에 저장
	        	//AttachFileDTO 클래스에 setUploadPath변수에 날짜랑 이름 저장
	        	 attach.setUploadPath(getFolder());
	        	 System.out.println("getFolder"+getFolder());
	          	 //AttachFileDTO 클래스에 UUID변수에 저장
	        	 attach.setUuid(uuid.toString());
	        	 //파일 저장할때 이미지파일이면 썸내일 만들어서 저장
	        	 if(checkImageType(saveFile)) {
	        		 //업로드된 파일이 이미지라는 뜻
	        		 attach.setImage(true);
	        		 
	        		 FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder,"s_"+uploadFileName));
	        		 Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100, 100);
	        		 thumbnail.close();

	        	 }
	        	 
	        	 list.add(attach);
	        	 logger.info("list : "+list);
	         }catch(Exception e) {
	            logger.info(e.getMessage());
	         }
   
	   }
   }
}