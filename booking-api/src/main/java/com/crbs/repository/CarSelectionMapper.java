package com.crbs.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.crbs.model.Car;

public class CarSelectionMapper implements RowMapper<Car> {
	// 쿼리문의 결과 데이터를 ResultSet 객체에 넣기 위해 정의한 클래스 (RowMapper 인터페이스를 끌어옴)

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car c = new Car();

		c.setCode(rs.getString("code"));
		c.setName(rs.getString("name"));
		c.setPrice(rs.getInt("price"));
		c.setFlag(rs.getInt("flag"));
		c.setColor(rs.getString("color"));
		c.setFuel(rs.getString("fuel"));
		c.setDisplacement(rs.getInt("displacement"));
		c.setSize(rs.getString("size"));
		
		return c;
	}
	
}
