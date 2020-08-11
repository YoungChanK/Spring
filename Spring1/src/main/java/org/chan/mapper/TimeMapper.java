package org.chan.mapper;

import org.apache.ibatis.annotations.Select;


public interface TimeMapper {
	
	
	@Select("select sysdate()")
	public String getTime(); //추상메소드

	
	public String getTime2(); 
}
