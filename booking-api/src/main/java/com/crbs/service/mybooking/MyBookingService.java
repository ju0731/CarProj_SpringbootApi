package com.crbs.service.mybooking;

import java.util.List;

import com.crbs.model.MyBooking;


public interface MyBookingService {
	//나의 예약현황 리스트
	List<MyBooking> getMyBookingList(String customer_id);
	//예약 취소
	int deleteMyBooking(String customer_id,String car_code);
}
