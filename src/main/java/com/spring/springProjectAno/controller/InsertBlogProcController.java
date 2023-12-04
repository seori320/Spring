package com.spring.springProjectAno.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.impl.BlogDao;
import com.spring.blog.impl.BlogDo;

//<prop key="/insertBlogProc.do"> insertBlogProc </prop>

public class InsertBlogProcController{
	
	@RequestMapping(value="/insertBlogProc.do")
	public ModelAndView insertBlogProc(BlogDo bdo,
										BlogDao bdao,
										ModelAndView mav) {
		
		System.out.println("InsertBlogProcController(Ano) --> ");
	
		bdao.insertBlog(bdo);
		mav.setViewName("redirect:getBlogList.do");

		return mav;
	}
	
}
