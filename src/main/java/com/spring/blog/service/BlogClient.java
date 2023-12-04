package com.spring.blog.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.blog.common.JdbcUtil;
import com.spring.blog.impl.BlogDo;

public class BlogClient {

	public static void main(String[] args) {		
		
		ApplicationContext context = 
		new ClassPathXmlApplicationContext("blogSetting.xml");
		
		BlogService bService = (BlogService) context.getBean("blogService");

		ArrayList<BlogDo> bList = bService.getBlogList();
		for(BlogDo bdo: bList) {
			System.out.println(" --> " + bdo.toString());
		}

		BlogDo temp = new BlogDo();
		temp.setSeq(3);
		BlogDo temp2 = bService.getBlog(temp);
		System.out.println(" getBlog() -> " + temp2.toString());

		temp.setSeq(1);
		temp.setTitle("title");
		temp.setContent("content");
		temp.setColor("color");
		bService.updateBlog(temp);
		temp2 = bService.getBlog(temp);
		System.out.println(" getBlog() -> " + temp2.toString());
		
		temp.setSeq(3);
		bService.deleteBlog(temp);
		
		
	}

}
