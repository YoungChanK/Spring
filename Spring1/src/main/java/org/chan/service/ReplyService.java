package org.chan.service;

import java.util.List;

import org.chan.domain.Criteria;
import org.chan.domain.ReplyVO;

public interface ReplyService {
//	댓글리스트
	public List<ReplyVO> list(int bno,Criteria cri)throws Exception;
//	댓글쓰기
	public void create(ReplyVO vo)throws Exception;
//	//댓글 수정
	public void update(ReplyVO vo)throws Exception;
//	//댓글 삭제
	public void delete(int rno)throws Exception;

}
