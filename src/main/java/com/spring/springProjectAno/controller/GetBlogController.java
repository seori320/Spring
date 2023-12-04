package com.spring.springProjectAno.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.impl.BlogDao;
import com.spring.blog.impl.BlogDo;

public class GetBlogController {
	//<prop key="/getBlog.do"> getBlog </prop>
	@RequestMapping(value="/getBlog.do")
	public ModelAndView getBlog(BlogDo bdo,
								 BlogDao bdao,
								 ModelAndView mav) {
		System.out.println("GetBlogController(Ano) --> ");
		System.out.println("seq : " + bdo.getSeq());
		
		BlogDo blog = bdao.getBlog(bdo);
		mav.addObject("blog", blog);
		mav.setViewName("getBlogView");
		
		return mav;
	}

}
