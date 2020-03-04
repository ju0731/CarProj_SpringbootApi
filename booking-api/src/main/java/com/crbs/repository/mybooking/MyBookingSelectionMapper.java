package com.crbs.repository.mybooking;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.crbs.model.MyBooking;

public class MyBookingSelectionMapper implements RowMapper<MyBooking>{

	@Override
	public MyBooking mapRow(ResultSet rs, int rowNum) throws SQLException {
		MyBooking mb = new MyBooking();
		
		mb.setCode(rs.getString("code"));
		mb.setName(rs.getString("name"));
		mb.setPrice(rs.getInt("price"));
		mb.setEndDate(rs.getDate("endDate"));
		mb.setStartDate(rs.getDate("startDate"));
		
		return mb;
	}

}
