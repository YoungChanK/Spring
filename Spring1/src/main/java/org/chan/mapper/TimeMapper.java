package org.chan.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

public interface TimeMapper {
	//����ð��� ��¥�� ��ȸ�ϴ� sql
	
	@Select("select sysdate()")
	public String getTime(); //�߻�޼ҵ�

	
	public String getTime2(); //�߻�޼ҵ�
}
