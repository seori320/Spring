package com.spring.springProjectAno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.blog.impl.UserDAO;
import com.spring.blog.impl.UserVO;

@Controller
public class LoginController {
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test1234");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 인증 처리");
		if(userDAO.getUser(vo) != null) return "getBlogList.do";
		else return "login.jsp";
	}
}
