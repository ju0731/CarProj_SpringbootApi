package com.crbs.repository.mybooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crbs.model.MyBooking;

@Repository
public class MyBookingRepositoryImple implements MyBookingRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<MyBooking> getMyReservation(String customer_id) {
		return this.jdbcTemplate.query(MyBookingSQLquery.SELECT_MyBooking, new MyBookingSelectionMapper(), customer_id);
	}
	@Override
	public int deleteMyBooking(String customer_id, String car_code) {
		return this.jdbcTemplate.update(MyBookingSQLquery.DELETE_MyBooking,car_code,customer_id);
	}

}
