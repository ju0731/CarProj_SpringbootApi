package com.crbs.repository;

public class MyBookingSQLquery {
	//예약 현황
	public static final String SELECT_MyBooking = "select C.CODE code, C.NAME name, C.PRICE price, B.STARTDATE startDate, B.ENDDATE from RESERVATION B,CAR C WHERE B.CAR_CODE=C.CODE AND B.CUSTOMER_ID=?;"; // 현재 예약가능한 차량정보 리스트 출력

	//예약 취소
	public static final String DELETE_MyBooking = "DELETE from RESERVATION WHERE CAR_CODE=? AND CUSTOMER_ID=?;"; // 현재 예약가능한 차량정보 리스트 출력

}
