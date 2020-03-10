package com.crbs.service.mybooking;

import java.text.SimpleDateFormat;
import java.util.Date;
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

	@SuppressWarnings("deprecation")
	@Override
	public String deleteMyBooking(String customer_id, String car_code) {
		try {
			String startdate = mbDAO.getStartDate(customer_id, car_code);
			SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();
			Date start = formatter.parse(startdate);
			logger.info("예약 시작 날짜 : "+start.toString()+start.getDay());
			logger.info("오늘 날짜 : "+now.toString()+now.getDay());
			if(now.getDay()>=start.getDay()) {
				return"expiration : 예약 취소 가능 기간이 만료되었습니다.";
			}
			try {
				mbDAO.deleteMyBooking(customer_id, car_code);
			} catch (Exception e) {
				return e.toString();
			}
			return"SUCCESS";
		} catch (Exception e) {
			return e.toString();
		}
	}
	
}
