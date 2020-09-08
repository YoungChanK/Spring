package org.chan.service;

import javax.servlet.http.HttpSession;

import org.chan.domain.MemberVO;
import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
	//로그인 정보 조회(select)
	public MemberVO login(MemberVO member);
	//회원가입 (insert)
	public void createMember(MemberVO vo);
	//아이디 체크 
	public String idCheck(String userid);
	public void LoginOut(HttpSession session);
}
