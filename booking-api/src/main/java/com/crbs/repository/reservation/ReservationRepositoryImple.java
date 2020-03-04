package com.crbs.repository.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crbs.model.Reservation;
import com.crbs.security.JasyptEncDec;

@Repository
public class ReservationRepositoryImple implements ReservationRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int insertReservation(Reservation reservation) {
		JasyptEncDec enc = new JasyptEncDec();
		String encryptedCarCode = enc.encryptText(reservation.getCarCode());
		return this.jdbcTemplate.update(ReservationSQLquery.INSERT_RESERVATION, reservation.getCustomerId(), encryptedCarCode, reservation.getStartDate(), reservation.getEndDate());
	}
}
