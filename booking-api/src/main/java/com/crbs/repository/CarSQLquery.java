package com.crbs.repository;

public class CarSQLquery {
	public static final String SELECT_AVAILABLE_CAR = "select * from CAR where flag = 1"; // 현재 예약가능한 차량정보 리스트 출력

	public static final String INSERT_CAR_INFO = "insert into CAR (CODE, NAME, PRICE, COLOR, FUEL, DISPLACEMENT, SIZE, IMAGEURL, CNT) values (?,?,?,?,?,?,?,?,?)";

	public static final String DELETE_CAR_INFO_BY_CODE = "delete from CAR where code = ?";
	
	public static final String UPDATE_CAR_INFO_BY_CODE = "update CAR set NAME = ?, PRICE = ?, COLOR = ?, FUEL = ?, DISPLACEMENT = ?, SIZE = ?, IMAGEURL = ?, CNT = ? where CODE = ?";
	
}
