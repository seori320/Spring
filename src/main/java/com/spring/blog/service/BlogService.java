package com.spring.blog.service;

import java.util.ArrayList;

import com.spring.blog.impl.BlogDo;

public interface BlogService {

	void insertBlog(BlogDo bdo);

	ArrayList<BlogDo> getBlogList();
	
	BlogDo getBlog(BlogDo bdo);
	
	void updateBlog(BlogDo bdo);
	
	void deleteBlog(BlogDo bdo);

}
