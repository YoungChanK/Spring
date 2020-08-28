package org.chan.service;

import org.chan.domain.MemberVO;

public interface MemberService {
	//로그인 정보 조회(select)
	public MemberVO login(MemberVO member);
}
