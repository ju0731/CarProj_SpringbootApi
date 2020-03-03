package com.crbs.repository;

public class CarSQLquery {
	public static final String SELECT_AVAILABLE_CAR = "select * from CAR where flag = 1"; // 현재 예약가능한 차량정보 리스트 출력

	public static final String INSERT_CAR_INFO = "insert into CAR (CODE, NAME, PRICE, FLAG, COLOR, FUEL, DISPLACEMENT, SIZE, IMAGEURL) values (?,?,?,?,?,?,?,?,?)";

	public static final String DELETE_CAR_INFO = "delete from CAR where code = ?";
}
