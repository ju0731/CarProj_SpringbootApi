package com.crbs.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.crbs.model.User;

@Repository
public class UserRepositoryImple implements UserRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertUser(User user) {
		return this.jdbcTemplate.update(UserSQLquery.INSERT_USER,user.getId(),user.getName(),user.getPassword(), user.getIsadmin(),user.getPhonenumber());	
			
	}

	@Override
	public int deleteUser(String id) {
		return this.jdbcTemplate.update(UserSQLquery.DELETE_USER, id);
	}

	@Override
	public int updateUser(String id, User user) {
		return this.jdbcTemplate.update(UserSQLquery.UPDATE_USER, user.getPhonenumber(), id);
	}


}
