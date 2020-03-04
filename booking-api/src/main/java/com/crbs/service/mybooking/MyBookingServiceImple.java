package com.crbs.service.mybooking;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crbs.model.MyBooking;
import com.crbs.repository.mybooking.MyBookingRepositoryImple;

@Service
public class MyBookingServiceImple implements MyBookingService {
	private static final Logger logger = LoggerFactory.getLogger(MyBookingServiceImple.class);
	
	@Autowired
	private MyBookingRepositoryImple mbDAO;

	@Override
	public List<MyBooking> getMyBookingList(String customer_id) {
		List<MyBooking> myReservations = null;
		try {
			myReservations = mbDAO.getMyReservation(customer_id);
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return myReservations;
	}

	@Override
	public int deleteMyBooking(String customer_id, String car_code) {
		return mbDAO.deleteMyBooking(customer_id, car_code);
	}
	
}
