package com.crbs.service.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crbs.model.Reservation;
import com.crbs.repository.reservation.ReservationRepositoryImple;

@Service
public class ReservationServiceImple implements ReservationService {
	@Autowired
	private ReservationRepositoryImple reservationDao;

	@Override
	public int registerReservation(Reservation reservation) {
		int result = reservationDao.insertReservation(reservation);
		if (result == 1)
			return 1;
		else {
			reservationDao.addCarCnt(reservation.getCarCode());
			return 0;
		}
	}

	@Override
	public int getNumOfReservation() {
		int result = reservationDao.getNumOfReservation();
		return result;
	}

	@Override
	public List<Reservation> showReservationList() {
		List<Reservation> reservation;
		try {
			reservation = reservationDao.getReservationList();
		} catch (Exception e) {
			reservation = new ArrayList<Reservation>();
		}
		return reservation;
	}


}
