package com.crbs.repository.reservation;

import java.util.List;

import com.crbs.model.Reservation;

public interface ReservationRepository {
	
	List<Reservation> getReservationList();
	
	int getNumOfReservation();

	int insertReservation(Reservation reservation); 
}
