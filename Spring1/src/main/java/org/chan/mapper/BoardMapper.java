package org.chan.mapper;

import java.util.List;

import org.chan.domain.BoardVO;
import org.chan.domain.Criteria;

public interface BoardMapper {
	//글쓰기 
	public void create(BoardVO vo) throws Exception;
	//제목 클릭 후 한건에 대한 Select
	public BoardVO read(BoardVO vo) throws Exception;
	//글수정
	public void update(BoardVO vo) throws Exception;
	//글삭제
	public void delete(BoardVO vo)throws Exception;
	//게시글 리스트
	public List<BoardVO> listAll()throws Exception;
	//페이지 처리 한거 목록리스트 
	public List<BoardVO> listPage(Criteria cri)throws Exception;
	
}
