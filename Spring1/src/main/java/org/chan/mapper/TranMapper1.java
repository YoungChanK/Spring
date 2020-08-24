package org.chan.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TranMapper1 {
	@Insert("insert into tbl_transaction1 values (#{data})")
	public int inserCol1(String data);
}
