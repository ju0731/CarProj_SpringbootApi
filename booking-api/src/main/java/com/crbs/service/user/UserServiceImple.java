package com.crbs.service.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.crbs.model.User;
import com.crbs.repository.user.UserRepository;
import com.crbs.web.CrbsController;


@Service
public class UserServiceImple implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImple.class);

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
