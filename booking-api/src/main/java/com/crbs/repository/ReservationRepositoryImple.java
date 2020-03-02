package com.crbs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crbs.model.Reservation;

@Repository
public class ReservationRepositoryImple implements ReservationRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int insertReservation(Reservation reservation) {
		return this.jdbcTemplate.update(ReservationSQLquery.INSERT_RESERVATION, reservation.getCustomerId(), reservation.getCarCode(), reservation.getStartDate(), reservation.getEndDate());
	}
}
