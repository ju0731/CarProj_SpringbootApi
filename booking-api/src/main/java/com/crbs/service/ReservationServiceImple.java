package com.crbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crbs.model.Reservation;
import com.crbs.repository.ReservationRepositoryImple;

@Service
public class ReservationServiceImple implements ReservationService {
	@Autowired
	private ReservationRepositoryImple reservationDao;

	@Override
	public int registerReservation(Reservation reservation) {
		int result = reservationDao.insertReservation(reservation);
		if(result == 1)
			return 1;
		else
			return 0;
	}
}
