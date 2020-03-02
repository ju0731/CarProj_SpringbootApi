package com.crbs.repository;

public class ReservationSQLquery {
	public static final String INSERT_RESERVATION = "insert into RESERVATION (CUSTOMER_ID, CAR_CODE, STARTDATE, ENDDATE) values (?,?,?,?)"; // 고객이 입력한 예약내역을 Database에 저장

}

