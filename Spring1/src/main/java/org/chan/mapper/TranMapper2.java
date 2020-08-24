package org.chan.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TranMapper2 {
	@Insert("insert into tbl_transaction2 values (#{data})")
	public int inserCol1(String data);
}
