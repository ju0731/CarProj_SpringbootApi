package com.crbs.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.crbs.model.User;

public class UserLoginSelectionMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();

		u.setId(rs.getString("id"));
		u.setName(rs.getString("name"));
		u.setPassword(rs.getString("password"));
		u.setPhonenumber(rs.getString("phonenumber"));
		u.setIsadmin(rs.getInt("isadmin"));

		return u;
	}
}
