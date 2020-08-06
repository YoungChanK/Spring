package org.chan.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class dbtest {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/example?serverTimezone=Asia/Seoul";
	public static final String USER = "chan";
	public static final String PW = "1234";
	
	
	
	@Test
	public void testConnectiom() throws Exception{
		Class.forName(DRIVER);
		try(Connection con = DriverManager.getConnection(URL,USER,PW)){
			System.out.println(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
