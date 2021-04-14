package com.tyss.jdbc_1;

import java.sql.*;

public class PreparedStmtCLA {

	public static void main(String[] args) {
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Ems","root","root@123");
			String query = "select * from employee where id = ?";
			pstmt=con.prepareStatement(query);
			String eid = args[0];
			int id = Integer.parseInt(eid);
			pstmt.setInt(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
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
