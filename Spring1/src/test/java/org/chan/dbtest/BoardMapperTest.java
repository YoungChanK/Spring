package org.chan.dbtest;

import java.util.List;

import org.apache.ibatis.type.Alias;
import org.chan.domain.BoardVO;
import org.chan.domain.MemberVO;
import org.chan.mapper.BoardMapper;
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
public class BoardMapperTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardMapper bomapper;
	
	@Test
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("새로운 제목을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("user00");
		
		bomapper.create(board);
	}	
	@Test
   
	public void testRead()throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(1);
	
		logger.info("제목을 클릭한 후 select"+bomapper.read(board));
	}
	@Test
	public void testupdate()throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("제목수정");
		board.setContent("내용수정");
		board.setBno(1);
		bomapper.update(board);
	}
	@Test
	public void delete()throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(2);
		bomapper.delete(board);
	}
	@Test
	public void testListBoard()throws Exception {
//		List<BoardVO>listAll= bomapper.listAll();
//		listAll.forEach(board ->logger.info(""+board));
		bomapper.listAll().forEach(board ->logger.info(" "+board));
	}
	

}
