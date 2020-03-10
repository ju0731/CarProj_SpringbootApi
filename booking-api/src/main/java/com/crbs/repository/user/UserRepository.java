package com.crbs.repository.user;

import com.crbs.model.User;

public interface UserRepository {
	
	//회원가입
	int insertUser(User user);
	
	//탈퇴
	int deleteUser(String id);
	
	//수정
	int updateUser(String id, User user);
	
	//로그인
	String findById(String id);
	
	User findUserData(String id); 	// 회원정보 출력
}
