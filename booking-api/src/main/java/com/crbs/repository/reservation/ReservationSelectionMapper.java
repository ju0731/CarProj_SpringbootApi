package com.crbs.repository.reservation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.crbs.model.Reservation;

public class ReservationSelectionMapper implements RowMapper<Reservation> {
	// 쿼리문의 결과 데이터를 ResultSet 객체에 넣기 위해 정의한 클래스 (RowMapper 인터페이스를 끌어옴)

	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reservation r = new Reservation();

		r.setCustomerId(rs.getString("customer_id"));
		r.setCarCode(rs.getString("car_code"));
		r.setStartDate(rs.getDate("startdate"));
		r.setEndDate(rs.getDate("enddate"));

		return r;
	}
}
