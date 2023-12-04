package com.spring.springProjectAno.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.impl.BlogDao;
import com.spring.blog.impl.BlogDo;

//public class InsertBlogController implements Controller{

public class InsertBlogController {
	
	//<prop key="/insertBlog.do"> insertBlog </prop>
	@RequestMapping(value="/insertBlog.do")
	public ModelAndView insertBlog(BlogDo bdo,
									BlogDao bdao,
									ModelAndView mav) {
		
		System.out.println("InsertBlogController(Ano) --> ");
		mav.setViewName("insertBlogView");
		
		return mav;
	}

}
