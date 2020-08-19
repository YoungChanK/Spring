package org.chan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.chan.domain.Criteria;
import org.chan.domain.ReplyVO;

public interface ReplyMapper {
	//댓글 리스트 보기
//	public List<ReplyVO> list(ReplyVO vo,Criteria cri)throws Exception;
	public List<ReplyVO> list(@Param("bno") int bno,@Param("cri") Criteria cri)throws Exception;
	//댓글 보기
	public void create(ReplyVO vo)throws Exception;
	//댓글 수정
	public void update(ReplyVO vo)throws Exception;
	//댓글 삭제
	public void delete(int rno)throws Exception;
}
