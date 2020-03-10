package com.crbs.repository.mybooking;

public class MyBookingSQLquery {
	//예약 현황
	public static final String SELECT_MyBooking = "select C.CODE code, C.NAME name, C.PRICE price, B.STARTDATE startDate, B.ENDDATE from RESERVATION B,CAR C WHERE B.CAR_CODE=C.CODE AND B.CUSTOMER_ID=?;"; 

	//예약 취소
	public static final String DELETE_MyBooking = "DELETE from RESERVATION WHERE CAR_CODE=? AND CUSTOMER_ID=?;";
	
	//startDate 가져오기
	public static final String SELECT_STARTDATE = "select STARTDATE from RESERVATION WHERE CUSTOMER_ID=? AND CAR_CODE=?;";
}
