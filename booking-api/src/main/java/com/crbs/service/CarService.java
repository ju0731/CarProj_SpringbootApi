package com.crbs.service;

import java.util.List;

import com.crbs.model.Car;

public interface CarService {
	List<Car> showAvailableCarList();
	
	int getNumOfAvailableCar();
	
	int registerCarInfo(Car car);

	int removeCarInfoByCode(String code);
	
	void renewCarInfoByCode(Car car, String code);
}
