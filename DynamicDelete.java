package com.tyss.jdbc_1;
import java.sql.*;

public class DynamicDelete {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ems?user=root&password=root@123");
			String query = "delete from employee where id = ?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 5);
			pstmt.executeUpdate();
			
			System.out.println("Delete Successfull !");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
