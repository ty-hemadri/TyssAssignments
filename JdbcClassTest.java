package com.te.junit.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class JdbcClassTest {

	@Test
	void testInsert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root@123");
		     JdbcClass jc = new JdbcClass();
		     jc.insert(1, "Hemadri");
//		     assertEquals(1, i);
		     String query = "select * from student";
		     Statement stmt = con.createStatement();
		    ResultSet rs= stmt.executeQuery(query);
		    assertEquals(1,rs.getInt(1));
		    assertEquals("Hemadri",rs.getString(2));
		    con.close();
		    
		} catch (Exception e) {
		e.getMessage();
		}
	}
	@Test
	void testUpdate() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root@123");
		     JdbcClass jc = new JdbcClass();
		     jc.update(1, "Hkr");
//		    assertEquals(1, i);
		     String query = "select * from student";
		     Statement stmt = con.createStatement();
		    ResultSet rs= stmt.executeQuery(query);
		    assertEquals("Hkr", rs.getString(2));
		    con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Test
	void testSelect() {
		 JdbcClass jc = new JdbcClass();
		 ArrayList<Object> obj=jc.select();
		 assertEquals(obj!=null, true);
	}



	@Test
	void testDelete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root@123");
		     JdbcClass jc = new JdbcClass();
		     jc.delete(1);
//		     assertEquals(1, i);
		     String query = "select * from student";
		     Statement stmt = con.createStatement();
		    ResultSet rs= stmt.executeQuery(query);
		    assertEquals(rs.next(), false);
		    con.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
