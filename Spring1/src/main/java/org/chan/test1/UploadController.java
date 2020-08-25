package org.chan.test1;
import java.io.File;

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
   @RequestMapping(value = "uploadajax", method = RequestMethod.GET)
   public void uploadAjax() {
	   logger.info("파일 업로드  ajax 화면");
   }
   @ResponseBody
   @RequestMapping(value = "uploadajax", method = RequestMethod.POST,produces ="text/plain;charset=UTF-8")
   public ResponseEntity<String> uploadAjaxPost(MultipartFile[] file) throws Exception {
	   logger.info("파일 업로드  ajax 화면");
	   for(MultipartFile multipartFile : file) {
	         
	         logger.info("파일명 : "+multipartFile.getOriginalFilename());
	         logger.info("파일크기 : "+multipartFile.getSize());
	         logger.info("파일종료 : "+multipartFile.getContentType());
	         logger.info("파일 저장 위치 : "+uploadPath);
	         
	         File saveFile = new File(uploadPath,multipartFile.getOriginalFilename());
	         
	         try {
	        	 multipartFile.transferTo(saveFile);
	         }catch(Exception e) {
	            logger.info(e.getMessage());
	         }
	      }
	   return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
   }
   
}