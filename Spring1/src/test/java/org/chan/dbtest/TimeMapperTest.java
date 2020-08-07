package org.chan.dbtest;

import javax.sql.DataSource;

import org.chan.mapper.TimeMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")


public class TimeMapperTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TimeMapper timeMapper;
	@Test
	public void testGetTime() {
		logger.info(timeMapper.getClass().getName());
		logger.info(timeMapper.getTime());
	}
	@Test
	public void testGetTime2() {
		logger.info(timeMapper.getClass().getName());
		logger.info(timeMapper.getTime2());
	}
}

