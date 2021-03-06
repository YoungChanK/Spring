package org.chan.mapper;

import java.util.List;

import org.chan.domain.BoardAttachVO;
import org.chan.domain.BoardVO;

public interface BoardAttachMapper {
	//파일업로드 tbl_attach테이블에 insert
	public void insert(BoardAttachVO vo);
	//파일업로드 tbl_attach테이블에 delete
	public void delete(BoardVO vo);
	//파일업로드 tbl_attach테이블에 select
	public List<BoardAttachVO> select(int bno);
}
