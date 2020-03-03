package com.crbs.repository;

import java.util.List;

import com.crbs.model.MyBooking;

public interface MyBookingRepository {
	//나의 예약현황 리스트
	List<MyBooking> getMyReservation(String customer_id);
	
	//나의 예약 취소
	int deleteMyBooking(String customer_id,String car_code);
}
