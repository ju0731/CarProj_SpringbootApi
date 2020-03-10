package com.crbs.repository.mybooking;

import java.util.List;

import com.crbs.model.MyBooking;

public interface MyBookingRepository {
	//나의 예약현황 리스트
	List<MyBooking> getMyReservation(String customer_id);
	//나의 예약 취소
	int deleteMyBooking(String customer_id,String car_code);
	//예약 시작날짜 불러오기
	String getStartDate(String customer_id,String car_code);
	//예약 취소시 cnt+1해주기
	int updateCnt(String car_code);
}
