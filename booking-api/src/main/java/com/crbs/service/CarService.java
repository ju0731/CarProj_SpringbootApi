package com.crbs.service;

import java.util.List;

import com.crbs.model.Car;

public interface CarService {
	List<Car> showAvailableCarList();
	
	int registerCarInfo(Car car);

}
