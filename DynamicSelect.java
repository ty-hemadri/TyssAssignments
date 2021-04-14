package com.tyss.jdbc_1;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DynamicSelect {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream("D:\\db.properties");
			p.load(fis);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ems",p);
			
			String query= "select * from employee where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 1);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getInt(3)+" ");
				System.out.print(rs.getString(4)+" ");
				System.out.print(rs.getInt(5)+" ");
				
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
				if(rs!=null)
					rs.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
