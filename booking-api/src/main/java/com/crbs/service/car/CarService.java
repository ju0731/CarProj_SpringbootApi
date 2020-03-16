package com.crbs.service.car;

import java.util.List;

import com.crbs.model.Car;

public interface CarService {
	List<Car> showAvailableCarList();
	
	List<Car> showEntireCarList(); // Demo 변경 사항
	
	int getNumOfAvailableCar();
	
	int getNumOfEntireCar(); // Demo 변경 사항
	
	int registerCarInfo(Car car);

	int removeCarInfoByCode(String code);
	
	int renewCarInfoByCode(Car car, String code);
}
