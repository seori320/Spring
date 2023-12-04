package com.spring.springProjectAno.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.impl.BlogDao;
import com.spring.blog.impl.BlogDo;

public class ModifyBlogProcController {
	
	//<prop key="/modifyBlogProc.do"> modifyBlogProc </prop>
	@RequestMapping(value="/modifyBlogProc.do")
	public ModelAndView modifyBlogProc(BlogDo bdo,
										BlogDao bdao,
										ModelAndView mav ) {
		System.out.println("ModifyBlogProcController(Ano) --> ");
		
		System.out.println("seq : " + bdo.getSeq() + 
					   ", title : " + bdo.getTitle() +
					   ", content : " + bdo.getContent() +
					   ", color : " + bdo.getColor());
		bdao.updateBlog(bdo);
		mav.setViewName("redirect:getBlogList.do");
		
		return mav;
	}

}
