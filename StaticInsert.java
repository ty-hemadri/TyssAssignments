package com.tyss.jdbc_1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class StaticInsert {

	public static void main(String[] args) throws SQLException  {
		Connection con=null;
		Statement stmt=null;
		//1. load the driver class
		
		try {
//		Class.forName("com.mysql.jdbc.Driver");
			
			Driver driver = new com.mysql.cj.jdbc.Driver();
			
			DriverManager.registerDriver(driver);
			//2.get connection via driver
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ems?user=root&password=root@123");
			//3.issue sql queries via connection
			String Query="insert into employee values(4,'Mahesh',6000,'DAnalyst',48552585);";
			
			 stmt=con.createStatement();
			
			int count =stmt.executeUpdate(Query);
			
			//4.process the result
			
			System.out.println("no of rows affected is :"+count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5.close the objects
		
		finally {
			if(con!=null)
				con.close();
			if(stmt!=null)
				stmt.close();
			
				
		}
      
	}

}
