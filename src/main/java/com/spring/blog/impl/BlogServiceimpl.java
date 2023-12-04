package com.spring.blog.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blog.service.BlogService;

@Service("blogService")
public class BlogServiceimpl implements BlogService{
	
	@Autowired
	private BlogDao bdao;
	
	@Override
	public void insertBlog(BlogDo bdo) {
		bdao.insertBlog(bdo);
	}
	
	@Override
	public ArrayList<BlogDo> getBlogList() {		
		return bdao.getblogList();
	}

	@Override
	public BlogDo getBlog(BlogDo bdo) {
		// TODO Auto-generated method stub
		return bdao.getBlog(bdo);
	}

	@Override
	public void updateBlog(BlogDo bdo) {
		bdao.updateBlog(bdo);
	}

	@Override
	public void deleteBlog(BlogDo bdo) {		
		bdao.deleteBlog(bdo);
	}

}
