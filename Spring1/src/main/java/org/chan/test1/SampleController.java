package org.chan.test1;

import org.chan.domain.SampleDTO;
import org.chan.domain.SampleDTOList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//자바파일을 controller로 인식시켜주기 위해 @Controller를 사용
@Controller
//그전까진 view에 있는 파일을 메핑했다하면 view안에 다른 파일이 있을시 위에서 value값을 미리 선언해준다   (여기선 GET방식만 가능)
// view/doA   ==>>  view/board/doA
@RequestMapping(value="board")

public class SampleController {
	private static final Logger logger=LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value="doW", method = RequestMethod.GET)
	public void doW(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("name") String name,@RequestParam("phone") int phone) {
		logger.info("@RequestMapping doW가 호출되었습니다 ");
	}
	//데이터 용량이 큰경우 밑의 방식으로 받는게 좋음
	@RequestMapping(value="doM" , method = RequestMethod.GET)
	public void doM(SampleDTO sdto) {
		logger.info("@RequestMapping doM가 호출되었습니다 ");
	}
	@RequestMapping(value="doD" , method = RequestMethod.GET)
	public String doD(SampleDTOList list, Model model) {
		logger.info("SampleDTOList="+list);
		logger.info("@RequestMapping doD가 호출되었습니다 ");
		
		model.addAttribute("abc","doD에 전달하고파 하는 데이터");
		return "bbb";
	}
	
	@RequestMapping(value="doR", method = RequestMethod.GET)
	public void doR() {
		logger.info("@RequestMapping doR가 호출되었습니다 ");
	}
	//redirect 처리
	@RequestMapping(value="doE", method = RequestMethod.GET)
	public String doE(RedirectAttributes rttr) {
		logger.info("doE 실행됨");
		rttr.addFlashAttribute("msg","리다이렉트에 보낼 메세지");
		return "redirect:/board/doF";
	}
	
	@RequestMapping(value="doF", method = RequestMethod.GET)
	public void doF(String msg) {
		logger.info("doE 실행됨");
	}

}
