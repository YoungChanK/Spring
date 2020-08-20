package org.chan.domain;

import java.util.List;

//list 와 getCountBybno 를 합쳐주는 클래쓰
public class ReplyPageVO {
	private List<ReplyVO> list;
	private int replycnt;
	
	public ReplyPageVO(List<ReplyVO> list,int replycnt) {
		this.list=list;
		this.replycnt=replycnt;
	}
	@Override
	public String toString() {
		return "ReplyPageVO [list=" + list + ", replycnt=" + replycnt + "]";
	}
	public List<ReplyVO> getList() {
		return list;
	}
	public void setList(List<ReplyVO> list) {
		this.list = list;
	}
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
}
