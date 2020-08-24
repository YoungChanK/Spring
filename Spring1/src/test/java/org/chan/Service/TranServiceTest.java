package org.chan.Service;

import org.chan.service.TranService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TranServiceTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TranService service;

	@Test
	public void testTran() {
		String str="안녕하세요11 그린컴퓨터 아카데미에 오신 것을 환영합니다 빅데이터반 등록 이과정은 3개월 800시간 과정입니다 매우 지칩니다 아침에 일어나기 힘듭니다 ";
		service.addData(str);
	}
}
