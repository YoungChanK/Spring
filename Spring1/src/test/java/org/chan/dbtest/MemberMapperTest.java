package org.chan.dbtest;

import java.util.List;

import org.chan.domain.MemberVO;
import org.chan.mapper.MemberMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")


public class MemberMapperTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MemberMapper memmapper;
	/*
	@Test
	public void testInsertMember() {
		MemberVO member = new MemberVO();
		member.setUserid("test1");
		member.setUserpw("12341");
		member.setUsername("chan1");
		member.setEmail("java11@na.com");
		
		memmapper.createMember(member);
	}
*/
	@Test
	public void testReadMember() {
		MemberVO member = new MemberVO();
		
		member.setUserid("test");
		MemberVO memvo=memmapper.memberRead(member);
		logger.info("회원정보조회 : "+memmapper.memberRead(memvo));
	}
	
//	@Test
//	public void testReadMember() {
//		MemberVO member = new MemberVO();
//		member.setUserid("def");
//		memmapper.memberRead(member);
//		logger.info("회원정보조회 : "+memmapper.memberRead(member));
//	}
	
	@Test
	public void testListMember() {
		List<MemberVO> memberlist =memmapper.memberList();
		//forEach문
		memberlist.forEach(member->logger.info(""+member));
	}
	
	@Test
	public void testupdateMember() {
		MemberVO member = new MemberVO();
		member.setUserpw("9876");
		member.setUsername("김씨플");
		member.setUserid("test");
		
		memmapper.updateMember(member);
	}
	@Test
	public void testdeletMember() {
		MemberVO member = new MemberVO();
		
		member.setUserid("test1");
		
		memmapper.updateMember(member);
	}
}
