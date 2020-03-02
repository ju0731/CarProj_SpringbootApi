package com.crbs.repository;

import java.util.List;

import com.crbs.model.Car;

public interface CarRepository {
	List<Car> getAvailableCarList();
	
}
