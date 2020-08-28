package org.chan.test1;

import org.chan.domain.MemberVO;
import org.chan.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("member")
public class MemberController {
	private static final Logger logger=LoggerFactory.getLogger(SampleController.class);
	@Autowired
	private MemberService meservice;
	//회원가입 ㅍ폼
	@RequestMapping(value="member", method=RequestMethod.GET)
		public void MemberGet()throws Exception{
			
		}
	//로그인화면폼
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void LoginGet()throws Exception{
		logger.info("로그인 화면 이동");
	}
	//로그인처리
	@RequestMapping(value="login", method=RequestMethod.POST)
	public void LoginPost(MemberVO member)throws Exception{
		logger.info("로그인 처리");
		meservice.login(member);
	}

}
