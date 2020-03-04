package com.crbs.service.user;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.crbs.model.User;

public interface UserService {

	//회원가입
	int insertUser(User user);
	
	//탈퇴
	int deleteUser(String id);
	
	//수정
	int updateUser(String id, User user);
	

}
