package com.crbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crbs.model.Car;
import com.crbs.repository.CarRepositoryImple;

@Service
public class CarServiceImple implements CarService {

	@Autowired
	private CarRepositoryImple carDao;
	
	@Override
	public List<Car> showAvailableCarList() {
		List<Car> car;
		try {
			car = carDao.getAvailableCarList();
		} catch (Exception e) {
			car = new ArrayList<Car>();
		}
		return car;
	}
}
