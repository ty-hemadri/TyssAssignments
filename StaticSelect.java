package com.tyss.jdbc_1;

import java.sql.*;

public class StaticSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con=null;
		Statement stmt = null;
		ResultSet st=null;
		
		try {
		
	  //1.load the connection
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.get the connection via driver
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ems?user=root&password=root@123");
		//3. sql queries
		
		stmt=con.createStatement();
		st = stmt.executeQuery("select * from employee");
		
		//4.process the result
		
		while(st.next())
		{
			System.out.print(st.getInt("id")+" ");
			System.out.print(st.getString("name")+" ");
			System.out.print(st.getInt("sal")+" ");
			System.out.print(st.getString("dept")+" ");
			System.out.print(st.getInt("phoneno")+" ");
			
			System.out.println();
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(con!=null)
				con.close();
			if(stmt!=null)
				stmt.close();
			if(st!=null)
				st.close();
		}

	}

}
