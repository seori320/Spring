package com.spring.springProjectAno.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.impl.BlogDao;
import com.spring.blog.impl.BlogDaoSpring;
import com.spring.blog.impl.BlogDo;

@Controller
public class BlogControllerSpring {
	
	@Autowired
	BlogDaoSpring blogDaoSpring;
	
	//	<prop key="/getBlogList.do"> getBlogList </prop>
	@RequestMapping(value="/getBlogList.do")
	public String getBlogList(BlogDo bdo, 
							   BlogDao bdao,
							   Model model ){
		System.out.println("GetBlogListController(Ano-Blog) --> ");
		ArrayList<BlogDo> bList = bdao.getblogList();			
		model.addAttribute("bList", bList);			
		return "getBlogListView";
	}
	
	//<prop key="/insertBlog.do"> insertBlog </prop>
	@RequestMapping(value="/insertBlog.do")
	public String insertBlog(BlogDo bdo,
							  BlogDao bdao,
							  ModelAndView mav) {
		
		System.out.println("InsertBlogController(Ano) --> ");
		//mav.setViewName("insertBlogView");
		
		return "insertBlogView";
	}
	
	@RequestMapping(value="/insertBlogProc.do", method=RequestMethod.GET)
	public String insertBlogProcGet(BlogDo bdo,
									BlogDao bdao,
									ModelAndView mav) {		
		System.out.println("InsertBlogProcController(Ano-Get) --> ");
		
		//bdao.insertBlog(bdo);
		blogDaoSpring.insertBlog(bdo);
		
		//mav.setViewName("redirect:getBlogList.do");
		
		return "redirect:getBlogList.do";
	}
	
	@RequestMapping(value="/insertBlogProc.do", method=RequestMethod.POST)
	public String insertBlogProcPost(BlogDo bdo,
										BlogDao bdao,
										ModelAndView mav) {		
		System.out.println("InsertBlogProcController(Ano-Post) --> ");
		
		//bdao.insertBlog(bdo);
		blogDaoSpring.insertBlog(bdo);
		
		//mav.setViewName("redirect:getBlogList.do");
		
		return "redirect:getBlogList.do";
	}
	
	//<prop key="/getBlog.do"> getBlog </prop>
	@RequestMapping(value="/getBlog.do")
	public String getBlog(BlogDo bdo,
								 BlogDao bdao,
								 Model model) {
		System.out.println("GetBlogController(Ano) --> ");
		System.out.println("seq : " + bdo.getSeq());
		
		BlogDo blog = bdao.getBlog(bdo);
		//mav.addObject("blog", blog);
		//mav.setViewName("getBlogView");
		model.addAttribute("blog", blog);
		
		return "getBlogView";
	}
	
	//<prop key="/modifyBlog.do"> modifyBlog </prop>
	@RequestMapping(value="/modifyBlog.do")
	public String modifyBlog(BlogDo bdo,
									BlogDao bdao,
									Model model) {
		System.out.println("ModifyController(Ano) --> ");
		System.out.println("seq : " + bdo.getSeq());
		
		BlogDo blog = bdao.getBlog(bdo);
		//mav.addObject("blog", blog);
		//mav.setViewName("modifyBlogView");
		model.addAttribute("blog",blog);
		
		return "modifyBlogView";
	}
	
	//<prop key="/modifyBlogProc.do"> modifyBlogProc </prop>
	@RequestMapping(value="/modifyBlogProc.do")
	public String modifyBlogProc(BlogDo bdo,
										BlogDao bdao,
										ModelAndView mav ) {
		System.out.println("ModifyBlogProcController(Ano) --> ");
		
		System.out.println("seq : " + bdo.getSeq() + 
					   ", title : " + bdo.getTitle() +
					   ", content : " + bdo.getContent() +
					   ", color : " + bdo.getColor());
		bdao.updateBlog(bdo);
		//mav.setViewName("redirect:getBlogList.do");
		
		return "redirect:getBlogList.do";
	}
	
	//<prop key="/deleteBlog.do"> deleteBlog </prop>
	@RequestMapping(value="/deleteBlog.do")
	public String deleteBlog(BlogDo bdo,
									BlogDao bdao,
									ModelAndView mav) {
		System.out.println("DeleteBlogController(Ano) --> ");
		
		bdao.deleteBlog(bdo);
		//mav.setViewName("redirect:getBlogList.do");
		
		return "redirect:getBlogList.do";
	}
	
	
	@RequestMapping(value="/searchBlogList.do")
	public String searchBlogList(@RequestParam(value="searchCon") String searchCon,
								  @RequestParam(value="searchKey") String searchKey,
								  BlogDao bdao, Model model) {
		System.out.println("searchBlogList --> ");
		
		System.out.println("searchCon : " + searchCon +
						   ", searchKey : " + searchKey );
		
		ArrayList<BlogDo> bList = bdao.searchBlogList(searchCon, searchKey);
		model.addAttribute("bList", bList);
		
		return "getBlogListView";
	}

}
