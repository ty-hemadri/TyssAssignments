package com.tyss.jdbc_1;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CallableStatementDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet st = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
					//2.get the connection via driver
					
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ems?user=root&password=root@123");
					//3. sql queries
					
					cstmt=con.prepareCall("{call selct(?)}");
					cstmt.setInt(1, 1);
					st=cstmt.executeQuery();
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
						if(cstmt!=null)
							cstmt.close();
						if(st!=null)
							st.close();
					}
					
	}

}
