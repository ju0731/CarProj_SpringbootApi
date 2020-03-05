package com.crbs.service.reservation;

import java.util.List;

import com.crbs.model.Reservation;

public interface ReservationService {
	
	List<Reservation> showReservationList();

	int getNumOfReservation();

	int registerReservation(Reservation reservation);
}
