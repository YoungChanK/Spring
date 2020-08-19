package org.chan.dbtest;

import java.util.List;

import org.chan.domain.Criteria;
import org.chan.domain.ReplyVO;
import org.chan.mapper.ReplyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ReplyMapper remapper;
	
//	@Test
//	public void testCreate() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		vo.setBno(3);
//		vo.setReplytext("Mapper test");
//		vo.setReplyer("찬");
//		
//		remapper.create(vo);
//	}
//	
//	@Test
//	public void testlist() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		Criteria cri = new Criteria();
//		vo.setBno(3);
//		List<ReplyVO> replies=remapper.list(3);
//		replies.forEach(reply->logger.info(""+reply));
//		
//
//	}
//	@Test
//	public void testupdate() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		vo.setRno(3);
//		vo.setReplytext("댓글내용 수정test");
//		remapper.update(vo);
//
//
//	}
	
//	@Test
//	public void testdelete() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		vo.setBno(3);
//
//		remapper.delete(rno);
//
//
//	}


}
