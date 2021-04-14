package com.tyss.jdbc_1;

import java.sql.*;

public class StaticUpdate {

	public static void main(String[] args)  {
		Connection con = null;
		Statement stmt = null;
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ems?user=root&password=root@123");
			stmt=con.createStatement();
			stmt.executeUpdate("update employee set name = 'bharath' where id =2");
			System.out.println("update Succesfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();
				if(stmt!=null)
					stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
