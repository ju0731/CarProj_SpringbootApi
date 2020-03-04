package com.crbs.repository.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crbs.model.Reservation;
import com.crbs.repository.car.CarSQLquery;
import com.crbs.repository.car.CarSelectionMapper;
import com.crbs.security.JasyptEncDec;

@Repository
public class ReservationRepositoryImple implements ReservationRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int getNumOfReservation() {
		return this.jdbcTemplate.queryForObject(ReservationSQLquery.SELECT_CNT_RESERVATION, int.class);
	}
	
	@Override
	public int insertReservation(Reservation reservation) {
		JasyptEncDec enc = new JasyptEncDec();
		String encryptedCustomerId = enc.encryptText(reservation.getCustomerId());
		String encryptedCarCode = enc.encryptText(reservation.getCarCode());
		return this.jdbcTemplate.update(ReservationSQLquery.INSERT_RESERVATION, encryptedCustomerId, encryptedCarCode, reservation.getStartDate(), reservation.getEndDate());
	}
	
	@Override
	public List<Reservation> getReservationList() {
		return this.jdbcTemplate.query(ReservationSQLquery.SELECT_RESERVATION_LIST, new ReservationSelectionMapper());

	}
}
