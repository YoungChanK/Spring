package org.chan.service;

import org.chan.domain.MemberVO;
import org.chan.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper memapper;
	
	
	public MemberVO login(MemberVO member) {
		return	memapper.login(member);
	}



	public void createMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memapper.createMember(vo);
	}
	@Override
	   public String idCheck(String userId) {
	      return memapper.idCheck(userId);
	   }

}
