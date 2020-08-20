package org.chan.service;

import java.util.List;

import org.chan.domain.Criteria;
import org.chan.domain.ReplyPageVO;
import org.chan.domain.ReplyVO;
import org.chan.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyMapper remapper;
	
	@Override
	public ReplyPageVO list(int bno,Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return new ReplyPageVO(remapper.list(bno, cri),remapper.getCountByBno(bno));
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		 remapper.create(vo);
		
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		 remapper.update(vo);
	}

	@Override
	public void delete(int rno) throws Exception {
		// TODO Auto-generated method stub
		remapper.delete(rno);
		
	}

}
