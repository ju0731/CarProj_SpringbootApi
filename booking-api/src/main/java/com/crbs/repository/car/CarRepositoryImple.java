package com.crbs.repository.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crbs.model.Car;
import com.crbs.security.JasyptEncDec;

@Repository
public class CarRepositoryImple implements CarRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Car> getAvailableCarList() {
		return this.jdbcTemplate.query(CarSQLquery.SELECT_AVAILABLE_CAR, new CarSelectionMapper());
	}
	
	@Override
	public int getNumOfAvailableCar() {
		return this.jdbcTemplate.queryForObject(CarSQLquery.SELECT_CNT_AVAILABLE_CAR, int.class);
	}
	
	@Override
	public int insertCarInfo(Car car) {
//		JasyptEncDec enc = new JasyptEncDec();
//		String encryptedCode = enc.encryptText(car.getCode());
		return this.jdbcTemplate.update(CarSQLquery.INSERT_CAR_INFO, car.getCode(), car.getName(), car.getPrice(), car.getColor(), car.getFuel(), car.getDisplacement(), car.getSize(), car.getImageUrl(), car.getCnt());
	}
	
	@Override
	public int deleteCarInfoByCode(String code) {
		JasyptEncDec enc = new JasyptEncDec();
		String encryptedCode = enc.encryptText(code);
		return this.jdbcTemplate.update(CarSQLquery.DELETE_CAR_INFO_BY_CODE, encryptedCode);
	}
	
	@Override
	public int updateCarInfoByCode(Car car, String code) {
//		JasyptEncDec enc = new JasyptEncDec();
//		String encryptedCode = enc.encryptText(code);
		return this.jdbcTemplate.update(CarSQLquery.UPDATE_CAR_INFO_BY_CODE, car.getName(), car.getPrice(), car.getColor(), car.getFuel(), car.getDisplacement(), car.getSize(), car.getImageUrl(), car.getCnt(), code);
	}
}
