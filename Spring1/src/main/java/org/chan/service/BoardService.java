package org.chan.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.chan.domain.BoardAttachVO;
import org.chan.domain.BoardVO;
import org.chan.domain.Criteria;

public interface BoardService {
	//글쓰기 
	public void create(BoardVO vo) throws Exception;
	//제목 클릭 후 한건에 대한 Select
	public BoardVO read(BoardVO vo) throws Exception;
	//글수정
	public void update(BoardVO vo) throws Exception;
	//글삭제
	public void delete(BoardVO vo)throws Exception;

//	public void cnt(BoardVO vo)throws Exception;
	//게시글 리스트
	public List<BoardVO> listAll()throws Exception;
	
	//페이지 처리 한거 목록리스트 
	public List<BoardVO> listPage(Criteria cri)throws Exception;
	
	public int getTotalCount(Criteria cri)throws Exception;
	
	public List<BoardAttachVO> getAttachList(int bno) throws Exception;
	
//	public void  updateReplyCnt(Integer bno, int amount)throws Exception;
}
