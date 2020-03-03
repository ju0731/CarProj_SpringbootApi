package com.crbs.repository;

import java.util.List;

import com.crbs.model.Car;

public interface CarRepository {
	List<Car> getAvailableCarList();
	
	int getNumOfAvailableCar();
	
	int insertCarInfo(Car car); 
	
	int deleteCarInfoByCode(String code);
	
	int updateCarInfoByCode(Car car, String code);
}
