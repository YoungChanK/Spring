package org.chan.test1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.chan.domain.BoardAttachVO;
import org.chan.domain.BoardVO;
import org.chan.domain.Criteria;
import org.chan.domain.MemberVO;
import org.chan.domain.PageDTO;
import org.chan.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService service;
	
	//글쓰기를 하기위한 화면 폼
	private static final Logger logger=LoggerFactory.getLogger(BoardController.class);
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("register get.......");
		
	
	}
/*	//실제로 글쓰기가 이루어 지는 곳 
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, Model model) throws Exception{
		logger.info("register POST.......");
		logger.info("boardVO에 저장되어 있는 값 확인"+board);
		service.create(board); //insert sql

		model.addAttribute("result","success");
		return "redirect://board/list";
		
	}*/
	   //년/월/일 폴더 생성하는 getFolder()메소드
	   //년월일 (날짜),오늘날짜를 어떻게 구할것인지 ?
	 private String getFolder() {
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   Date date = new Date(); //오늘날짜를 date변수에 저장
	   	String str=sdf.format(date);
	   	System.out.println("오늘 날짜 := "+str); //str :2020-08-25 => 2020\\08\\25
	   	
	   	return str.replace("-",File.separator);
	   }
	//실제로 글쓰기가 이루어 지는 곳 
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public String registerPOST(BoardVO board, Model model,MultipartFile[] file) throws Exception{
			logger.info("register POST.......");
			logger.info("boardVO에 저장되어 있는 값 확인"+board);
			
			String uploadPath="C:\\upload";
			   File uploadFolder=new File(uploadPath,getFolder());
			   logger.info("파일업로드 폴더"+uploadFolder);
			   //년월일 폴더 만들기
			   //exists() 메소드를 활용하여 생성하고자 하는 폴더가 존재하지 않으면 폴더를 만들어라.
			   if(uploadFolder.exists()==false) {
				   uploadFolder.mkdirs(); //mkdir메소드는 폴더를 만들어 주는 메소드
			   }
			 for(MultipartFile multipartFile : file) {
		    	  
		    	  
		         logger.info("파일명 : "+multipartFile.getOriginalFilename());
		         logger.info("파일명 : "+multipartFile.getSize());
		         logger.info("파일명 : "+multipartFile.getContentType());
		         logger.info("파일 저장 위치 : "+uploadPath);
		         
		         String fileName =multipartFile.getOriginalFilename(); //fileName
		         String uploadFileName=multipartFile.getOriginalFilename();
		         UUID uuid=UUID.randomUUID();
		         uploadFileName = uuid+"_"+uploadFileName;
		         
		         
		      
		         
		         try {
		        	 File saveFile = new File(uploadFolder,uploadFileName);
		        	 multipartFile.transferTo(saveFile);
		         }catch(Exception e) {
		            logger.info(e.getMessage());
		         }
		      }
			service.create(board); //insert sql
			model.addAttribute("result","success");
			return "redirect://board/list";
			
		}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void listGet(Model model, Criteria cri) throws Exception{
		logger.info("list Get.........1");
//		model.addAttribute("list",service.listAll());
		model.addAttribute("list",service.listPage(cri));
		model.addAttribute("PageMaker",new PageDTO(cri,service.getTotalCount(cri)));
	
	}
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void readGet(BoardVO board, Model model, @ModelAttribute("cri") Criteria cri) throws Exception{
		logger.info("read Get........."+board);
		logger.info("read Get........."+board.getRegdate());
		
		model.addAttribute("read",service.read(board));
		
	

	}
	//수정화면으로 이동
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGet(BoardVO board, Model model) throws Exception{
		logger.info("modify Get........."+board);
		model.addAttribute("modify",service.read(board));
	
	}
	//실제 수정이 이루어 지는곳
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("modify post........."+board);
		service.update(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list";
	}
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String removePost(BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("remove post........."+board);
		service.delete(board);
		rttr.addFlashAttribute("msg","DSUCCESS");
		return "redirect:/board/list";
	}
	@RequestMapping(value = "getAttachList", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BoardAttachVO>> getAttachList(int bno) throws Exception{
		logger.info("getAttachList"+bno);
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
		
	}

}
