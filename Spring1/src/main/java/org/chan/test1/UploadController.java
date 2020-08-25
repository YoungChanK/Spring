package org.chan.test1;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
   
   @Resource(name="uploadPath")
   private String uploadPath;
   private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
   
   @RequestMapping(value = "uploadForm", method = RequestMethod.GET)
   public void uploadForm() {
      logger.info("파일 업로드 화면");
   }
   @RequestMapping(value = "uploadForm", method = RequestMethod.POST)
   public void uploadForm(MultipartFile[] file)throws Exception{
      for(MultipartFile miltipartFile : file) {
         
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
   @RequestMapping(value = "uploadajax", method = RequestMethod.POST,produces ="text/plain;charset=UTF-8")
   public ResponseEntity<String> uploadAjaxPost(MultipartFile[] file) throws Exception {
	   logger.info("파일 업로드  ajax 화면");

	   
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
//	         logger.info("파일 저장 위치 : "+uploadPath);
	         
	         String uploadFileName=multipartFile.getOriginalFilename();
	         UUID uuid=UUID.randomUUID();
	         uploadFileName = uuid+uploadFileName;
	         
	         File saveFile = new File(uploadFolder,uploadFileName); //파일업로드 경로
//	         File saveFile = new File(uploadPath,multipartFile.getOriginalFilename()); //파일업로드 경로
	         
	         try {
	        	 //파일 저장할때 이미지파일이면 썸내일 만들어서 저장
	        	 if(checkImageType(saveFile)) {
	        		 FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder,"s_"+uploadFileName));
	        		 Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100, 100);
	        		 thumbnail.close();

	        	 }
	        	 //그냥 파일 저장
	        	 multipartFile.transferTo(saveFile); //transferTo 폴더에 저장
	         }catch(Exception e) {
	            logger.info(e.getMessage());
	         }
	      }
	   return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
   }
   
}