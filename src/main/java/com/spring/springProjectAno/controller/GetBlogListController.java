package com.spring.springProjectAno.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.impl.BlogDao;
import com.spring.blog.impl.BlogDo;

public class GetBlogListController{

//	<prop key="/getBlogList.do"> getBlogList </prop>
	@RequestMapping(value="/getBlogList.do")
	public ModelAndView getBlogList(BlogDo bdo, 
									 BlogDao bdao,
									 ModelAndView mav ){
		System.out.println("GetBlogListController(Ano) --> ");		
		ArrayList<BlogDo> bList = bdao.getblogList();		
		for(BlogDo blog: bList) {
			System.out.println(" --> " + blog.toString());
		}		

		mav.addObject("bList", bList);
		mav.setViewName("getBlogListView");	
		
		return mav;
	}

}
