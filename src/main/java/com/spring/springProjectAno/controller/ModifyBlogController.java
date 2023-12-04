package com.spring.springProjectAno.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.impl.BlogDao;
import com.spring.blog.impl.BlogDo;

public class ModifyBlogController {
	
	//<prop key="/modifyBlog.do"> modifyBlog </prop>
	@RequestMapping(value="/modifyBlog.do")
	public ModelAndView modifyBlog(BlogDo bdo,
									BlogDao bdao,
									ModelAndView mav) {
		System.out.println("ModifyController(Ano) --> ");
		System.out.println("seq : " + bdo.getSeq());
		
		BlogDo blog = bdao.getBlog(bdo);
		mav.addObject("blog", blog);
		mav.setViewName("modifyBlogView");
		
		return mav;
	}

}
