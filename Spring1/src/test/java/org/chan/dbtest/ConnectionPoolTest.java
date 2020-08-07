package org.chan.dbtest;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ConnectionPoolTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	//dataSource 테스트
	@Autowired
	private DataSource dataSource;
	@Test
	public void testConnection() {
		try(Connection con=dataSource.getConnection()) {
			logger.info("커넥트풀 연결="+ con);
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
	
	//mybatis 테스트
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	public void testMyBatis(){
			try(SqlSession session=sqlSessionFactory.openSession();
					Connection con=dataSource.getConnection()
						) {
				logger.info("mybatis 연결 ="+session);
				logger.info("커넥트풀 연결="+ con);
			} catch (Exception e) {
				// TODO: handle exception
				fail(e.getMessage());
			}
		
	}
	
	
	
	
	
}
