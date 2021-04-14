package com.tyss.jdbc_1;

import java.sql.*;

public class DynamicInsert {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ems?user=root&password=root@123");
			String query = "insert into employee values(?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			String s1=args[0];
			int id=Integer.parseInt(s1);
			String name = args[1];
			int sal = Integer.parseInt(args[2]);
			String job = args[3];
			int no = Integer.parseInt(args[4]);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, sal);
			pstmt.setString(4, job);
			pstmt.setInt(5,no );
			
			pstmt.executeUpdate();
			System.out.println("insertion Succesfull");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
