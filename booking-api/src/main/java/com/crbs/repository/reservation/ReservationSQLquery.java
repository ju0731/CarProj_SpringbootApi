package com.crbs.repository.reservation;

public class ReservationSQLquery {
	public static final String INSERT_RESERVATION = "insert into RESERVATION (CUSTOMER_ID, CAR_CODE, STARTDATE, ENDDATE) values (?,?,?,?)"; // 고객이 입력한 예약내역을 Database에 저장

	public static final String SELECT_RESERVATION_LIST = "select * from RESERVATION where CNT != 0";
	
	public static final String SELECT_CNT_RESERVATION = "select COUNT(*) from RESERVATION";

	public static final String SELECT_CNT_CAR = "select CNT from CAR where CODE = ?";
	
	public static final String UPDATE_TO_ADD_CNT_CAR = "update CAR set CNT = CNT + 1 where CODE = ?";

	public static final String UPDATE_TO_SUBTRACT_CNT_CAR = "update CAR set CNT = CNT - 1 where CODE = ?";
}

