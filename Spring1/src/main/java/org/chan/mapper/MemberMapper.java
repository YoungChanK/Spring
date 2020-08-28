package org.chan.mapper;

import java.util.List;

import org.chan.domain.MemberVO;

public interface MemberMapper {
//	public String readTime()throws Exception;
	//회원가입(insert)
	public void createMember(MemberVO vo);
	//회원가입(내정보) 수정하기 전 데이터조회  2가지 방식
	//MemberMapperTest 44번쨰 줄처럼
//	public MemberVO memberRead(String userid);
	//MemberMapperTest 35번쨰 줄처럼
	public MemberVO memberRead(MemberVO vo);

	public List<MemberVO> memberList();
	
	public void updateMember(MemberVO vo);
	
	public void deleteMember(MemberVO vo);
//	public MemberVO readWithPW(String userid, String userpw)throws Exception;
	
	public MemberVO login(MemberVO member);
}
