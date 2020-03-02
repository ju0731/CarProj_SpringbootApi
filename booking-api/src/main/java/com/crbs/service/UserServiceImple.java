package com.crbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crbs.model.User;
import com.crbs.repository.UserRepository;


@Service
public class UserServiceImple implements UserService{

	@Autowired
	private UserRepository dao;
	
	@Override
	public int insertUser(User user) {
		return dao.insertUser(user);
	}

	@Override
	public int deleteUser(String id) {
		return dao.deleteUser(id);
	}

	@Override
	public int updateUser(String id, User user) {
		return dao.updateUser(id, user);
	}

}
