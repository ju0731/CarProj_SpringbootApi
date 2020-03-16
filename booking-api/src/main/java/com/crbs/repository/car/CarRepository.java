package com.crbs.repository.car;

import java.util.List;

import com.crbs.model.Car;

public interface CarRepository {
	List<Car> getAvailableCarList();
	
//	List<Car> getEntireCarList(); // Demo 변경 사항
	
	int getNumOfAvailableCar();
	
//	int getNumOfEntireCar(); // Demo 변경 사항
	
	int insertCarInfo(Car car); 
	
	int deleteCarInfoByCode(String code);
	
	int updateCarInfoByCode(Car car, String code);
}
