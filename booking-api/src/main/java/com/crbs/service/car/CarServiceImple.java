package com.crbs.service.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crbs.model.Car;
import com.crbs.repository.car.CarRepositoryImple;

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
	
	@Override
	public int getNumOfAvailableCar() {
		int result = carDao.getNumOfAvailableCar();
		return result;
	}

	@Override
	public int registerCarInfo(Car car) {
		int result = carDao.insertCarInfo(car);
		if (result == 1)
			return 1;
		else
			return 0;
	}

	@Override
	public int removeCarInfoByCode(String code) {
		int i;
		try {
			i = carDao.deleteCarInfoByCode(code);
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}
	
	@Override
	public int renewCarInfoByCode(Car car, String code) {
		int result = carDao.updateCarInfoByCode(car, code);
		return result;
	}
}
