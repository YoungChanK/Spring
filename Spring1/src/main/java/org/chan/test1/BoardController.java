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
}
