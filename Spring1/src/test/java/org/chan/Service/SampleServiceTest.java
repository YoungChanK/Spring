package org.chan.Service;

import org.chan.mapper.BoardMapper;
import org.chan.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleServiceTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SampleService service;
	
	@Test
	public void testService() throws Exception {
		logger.info(""+service.doAdd("123", "456"));
	}
	
}
