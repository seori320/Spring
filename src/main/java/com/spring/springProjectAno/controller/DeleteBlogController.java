package com.spring.springProjectAno.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.impl.BlogDao;
import com.spring.blog.impl.BlogDo;

public class DeleteBlogController{
	
	//<prop key="/deleteBlog.do"> deleteBlog </prop>
	@RequestMapping(value="/deleteBlog.do")
	public ModelAndView deleteBlog(BlogDo bdo,
									BlogDao bdao,
									ModelAndView mav) {
		System.out.println("DeleteBlogController(Ano) --> ");
		
		bdao.deleteBlog(bdo);
		mav.setViewName("redirect:getBlogList.do");
		
		return mav;
	}
	
}
