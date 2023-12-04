package com.spring.blog.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.blog.common.JdbcUtil;

@Repository("blogDaoSpring")
public class BlogDaoSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public void insertBlog(BlogDo bdo) {
		System.out.println("[Spring JDBC] insertBlog() ==> ");
		
		String sql = "insert into blog values (null, ?, ?, ? )";
		jdbcTemplate.update(sql, bdo.getTitle(), bdo.getContent(), bdo.getColor());
	}	

	public ArrayList<BlogDo> getBlogList(){
		System.out.println("getBlogList() ==> ");
		ArrayList<BlogDo> bList = new ArrayList<BlogDo>();

		conn = JdbcUtil.getConnection();

		String sql = "select * from blog";
		
		try {			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BlogDo bdo = new BlogDo();
				bdo.setSeq(rs.getInt(1));
				bdo.setTitle(rs.getString(2));
				bdo.setContent(rs.getString(3));
				bdo.setColor(rs.getString(4));				
				bList.add(bdo);
			}
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("getBlogList() blogdaospring1 !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bList;
	}

	public BlogDo getBlog(BlogDo bdo) {
		System.out.println("getBlog() ==> ");
		BlogDo temp = new BlogDo();
	
		conn = JdbcUtil.getConnection();
		String sql = "select * from blog where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());

			rs= pstmt.executeQuery();
			while(rs.next()) {
				temp.setSeq(rs.getInt(1));
				temp.setTitle(rs.getString(2));
				temp.setContent(rs.getString(3));
				temp.setColor(rs.getString(4));			
			}
			JdbcUtil.close(conn, pstmt, rs); 
			System.out.println("getBoard() blogdaospring2 !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return temp;
	}
		
	public void updateBlog(BlogDo bdo) {
		System.out.println("updateBlog() ==> ");
		
		conn = JdbcUtil.getConnection();
		String sql = "update blog set title=?, content=?, color=? where seq=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getContent());
			pstmt.setString(3, bdo.getColor());
			pstmt.setInt(4, bdo.getSeq());
			
			pstmt.executeUpdate();
			
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("updateBoard() blogdaospring3 ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void deleteBlog(BlogDo bdo) {
		System.out.println("deleteBlog() ==> ");
		conn = JdbcUtil.getConnection();
		String sql = "delete from blog where seq=?";		
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, bdo.getSeq());
			
			pstmt.executeUpdate();
			
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("deleteBoard() blogdaospring4 !! ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<BlogDo> searchBlogList(String searchCon, String searchKey){
		System.out.println("searchBlogList() ==> ");
		
		ArrayList<BlogDo> bList = new ArrayList<BlogDo>();

		conn = JdbcUtil.getConnection();
		
		String sql = "";
		if(searchCon.equals("title"))
			sql = "select * from blog where title=?";
		else if(searchCon.equals("content"))	
			sql = "select * from blog where content=?";
		else if(searchCon.equals("color"))	
			sql = "select * from blog where color=?";
		else
			System.out.println("searchCon Error !! ");		
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchKey);
	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BlogDo bdo = new BlogDo();
				bdo.setSeq(rs.getInt(1));
				bdo.setTitle(rs.getString(2));
				bdo.setContent(rs.getString(3));
				bdo.setColor(rs.getString(4));				
				bList.add(bdo);
			}

			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("searchBoardList() blogdaospring5 !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return bList;
	}
}
