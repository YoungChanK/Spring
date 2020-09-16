package org.chan.test1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.chan.domain.MemberVO;
import org.chan.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

@Controller
@RequestMapping("member")
public class MemberController {
	private static final Logger logger=LoggerFactory.getLogger(SampleController.class);
	@Autowired
	private MemberService meservice;
	//회원가입 ㅍ폼
	@RequestMapping(value="member", method=RequestMethod.GET)
	public void MemberGet()throws Exception{
			logger.info("회원가입 화면");
		}
	//회원가입 처리
	@RequestMapping(value="member", method=RequestMethod.POST)
	public void MemberPost(MemberVO vo)throws Exception{
		meservice.createMember(vo);
	}
	//로그아웃
	@RequestMapping(value="logout", method=RequestMethod.POST)
	public String LogOut(HttpSession session)throws Exception{
		meservice.LoginOut(session);
		logger.info("세션값" + session.getId());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		mav.addObject("msg","logout");
	
		
		return "redirect:/";
	}
	//로그인화면폼
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void LoginGet()throws Exception{
		logger.info("로그인 화면 이동");
	}
	//로그인처리
	@RequestMapping(value="loginPost", method=RequestMethod.POST)
	public String LoginPost(MemberVO member,Model model,HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();    
		meservice.login(member);
		logger.info("로그인 처리");
		MemberVO vo= meservice.login(member);
		//만약에 인터셉터를 사용하지 않고 로그인처리를 하고자 할때 컨트롤러에서 아래처럼 작성
		if(vo !=null) { //로그인되었으면
			session.setAttribute("login",vo);
			logger.info("세션값 : " + session.getAttribute("login"));
			return "redirect:/";
			}
		else { //로그인이 되어 있지않았으면 login.jsp로 이동
			logger.info("로그인실패");
			logger.info(vo.toString());
			return "redirect:/member/login";
		}
//		logger.info("vo값은" + vo);
//		logger.info("세션값 :" +session.getAttribute("login"));
//		if(vo ==null) {
//	
//			return;
//		}
//		model.addAttribute("userVO",vo);
	
	}
	//아이디체크 폼
		@ResponseBody
	    @RequestMapping(value = "idCheck", method = RequestMethod.POST)
	   public String idCheck(String userid) {
	      String str = "";
	      String idcheck = meservice.idCheck(userid);
	      logger.info("ㅡㅡㅡㅡㅡㅡㅡ"+idcheck);
	      if(idcheck != null){ //이미 존재하는 계정
	         str = "NO";   
	         logger.info("NO"+str);
	      }else{   //사용 가능한 계정
	         str = "YES";   
	         logger.info("YES"+str);
	      }
	      return str;

	   }

}
