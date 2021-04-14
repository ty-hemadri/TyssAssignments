package com.tyss.jdbc_1;

import java.sql.*;;

public class StaticDelete {

	public static void main(String[] args) {
		Connection con= null;
		Statement stmt = null;
		
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ems?user=root&password=root@123");
		String query="delete from employee where id =4";
		stmt=con.createStatement();
		stmt.executeUpdate(query);
		System.out.println("Delete Successfull !");
		
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
