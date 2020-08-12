package org.chan.service;

import java.util.List;

import org.chan.domain.BoardVO;
import org.chan.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// @Service 무조건 넣어야함!!!!!!
@Service
public class BoardSericeImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;
	//글쓰기
	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.create(vo);
	}

	@Override
	public BoardVO read(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.read(vo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(vo);
	}

	@Override
	public void delete(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(vo);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return mapper.listAll();
	}

}
