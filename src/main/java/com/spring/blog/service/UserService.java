package com.spring.blog.service;

import com.spring.blog.impl.UserVO;

public interface UserService {

	// CRUD 기능의 메소드 구현
	// 회원 등록
	UserVO getUser(UserVO vo);
}
