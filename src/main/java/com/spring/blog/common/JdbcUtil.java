package com.spring.blog.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {
	
	static String id = "root";
	static String pass = "111111";
	static String url = "jdbc:mysql://localhost:3306/springdb?characterEncoding=utf-8";
	
	Connection conn = null;
	PreparedStatement  pstmt = null;
	ResultSet rs = null;
	
	public static Connection getConnection() {	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC connect success!!");
			
			return DriverManager.getConnection(url, id, pass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}

	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		if(conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
		
		if(pstmt != null) {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		
		if(rs != null) {
			try {
				if(!rs.isClosed()) {
					rs.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}		
	}
	
}
