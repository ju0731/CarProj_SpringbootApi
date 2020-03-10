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
//		JasyptEncDec enc = new JasyptEncDec();
//		String encryptedCustomerId = enc.encryptText(reservation.getCustomerId());
//		String encryptedCarCode = enc.encryptText(reservation.getCarCode());
		
		this.subtractCarCnt(reservation.getCarCode());
		return this.jdbcTemplate.update(ReservationSQLquery.INSERT_RESERVATION, reservation.getCustomerId(),
				reservation.getCarCode(), reservation.getStartDate(), reservation.getEndDate());
	}

	@Override
	public List<Reservation> getReservationList() {
		return this.jdbcTemplate.query(ReservationSQLquery.SELECT_RESERVATION_LIST, new ReservationSelectionMapper());

	}

	@Override
	public int getNumOfCar(String code) {
		return this.jdbcTemplate.queryForObject(ReservationSQLquery.SELECT_CNT_CAR, int.class, code);
	}

	@Override
	public int addCarCnt(String code) {
		return this.jdbcTemplate.update(ReservationSQLquery.UPDATE_TO_ADD_CNT_CAR, code);
	}

	@Override
	public int subtractCarCnt(String code) {
		return this.jdbcTemplate.update(ReservationSQLquery.UPDATE_TO_SUBTRACT_CNT_CAR, code);
	}
}
