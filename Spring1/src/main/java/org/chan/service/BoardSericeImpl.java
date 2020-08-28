package org.chan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.chan.domain.BoardAttachVO;
import org.chan.domain.BoardVO;
import org.chan.domain.Criteria;
import org.chan.mapper.BoardAttachMapper;
import org.chan.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// @Service 무조건 넣어야함!!!!!!
@Service
public class BoardSericeImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BoardAttachMapper attachmapper;
	//글쓰기
	
	@Transactional
	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		//tbl_board에 insert
		System.out.println(vo.getBno());
		mapper.create(vo);
		System.out.println(vo.getBno());
		//tbl_attach에 insert
		vo.getAttachList().forEach(attach->{ 
			System.out.println(attach.getBno());
			attach.setBno(vo.getBno()); 
			System.out.println(attach.getBno());
		attachmapper.insert(attach);
		});
	}
	@Transactional
	@Override
	public BoardVO read(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.cnt(vo);
		return mapper.read(vo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(vo);
	}
//	@Transactional
	@Override
	public void delete(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(vo);
//		attachmapper.delete(vo);
	}



	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return mapper.listAll();
	}
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return mapper.listPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}
	@Override
	public List<BoardAttachVO> getAttachList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return attachmapper.select(bno);
	}
	
	
/*	@Override
	public void updateReplyCnt(Integer bno, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("bno", bno);
		paramMap.put("amount", amount);
		
		session.update(namespace + ".updateReplyCnt", paramMap);
		
	}*/
	

}
