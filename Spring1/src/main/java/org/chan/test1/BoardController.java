package org.chan.test1;

import org.chan.domain.BoardVO;
import org.chan.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	//실제로 글쓰기가 이루어 지는 곳 
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, Model model) throws Exception{
		logger.info("register POST.......");
		service.create(board); //insert sql
		model.addAttribute("result","success");
		return "redirect://board/list";
		
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void listGet(Model model) throws Exception{
		logger.info("list Get.........");
		model.addAttribute("list",service.listAll());
		
	}
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void readGet(BoardVO board, Model model) throws Exception{
		logger.info("read Get........."+board);
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
	

}
