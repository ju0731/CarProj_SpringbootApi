package com.crbs.web;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crbs.model.Car;
import com.crbs.model.Reservation;
import com.crbs.service.car.CarService;
import com.crbs.service.reservation.ReservationService;

@RestController
@RequestMapping("/v0.0.3/crbs")
public class CrbsController {
	private static final Logger logger = LoggerFactory.getLogger(CrbsController.class);

	@Autowired
	ReservationService reservationService;
	@Autowired
	CarService carService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<HashMap<String, Object>> getAvailabeCarList() {
		logger.info("getAvailabeCarList() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		List<Car> car = carService.showAvailableCarList();
		int cntListItem = carService.getNumOfAvailableCar();

		HashMap<String, Object> hashmap = new HashMap<>();
		hashmap.put("car", car);
		hashmap.put("cntListItem", cntListItem);
		return new ResponseEntity<HashMap<String, Object>>(hashmap, headers, HttpStatus.OK);
	}
	
	
	/* Demo 변경 사항
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<HashMap<String, Object>> getEntireCarList() {
		logger.info("getEntireCarList() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		List<Car> car = carService.showEntireCarList();
		int cntListItem = carService.getNumOfEntireCar();

		HashMap<String, Object> hashmap = new HashMap<>();
		hashmap.put("car", car);
		hashmap.put("cntListItem", cntListItem);
		return new ResponseEntity<HashMap<String, Object>>(hashmap, headers, HttpStatus.OK);
	}
	*/

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/admins", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Car> createCarInfo(@RequestBody Car car) {
		logger.info("createCarInfo() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");

		if (car == null) {
			return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
		}
		int i = carService.registerCarInfo(car);

		if (i == 0)
			return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<Car>(car, headers, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/admins/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteCarInfo(@PathVariable("code") String code) {
		logger.info("deleteCarInfo() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		int i = carService.removeCarInfoByCode(code);
		logger.info("deleteCarInfo() : {}", i);
		if (i == 0)
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<Integer>(i, headers, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/admins/{code}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Car> updateCarInfo(@PathVariable("code") String code, @RequestBody Car car) {
		logger.info("udpateBoard() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		carService.renewCarInfoByCode(car, code);
		return new ResponseEntity<Car>(car, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/reservations", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
		logger.info("createReservation() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		if (reservation == null) {
			return new ResponseEntity<Reservation>(HttpStatus.BAD_REQUEST);
		}
		int i = reservationService.registerReservation(reservation);

		if (i == 0)
			return new ResponseEntity<Reservation>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<Reservation>(reservation, headers, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/users/myreservs", method = RequestMethod.GET)
	public ResponseEntity<HashMap<String, Object>> getReservationList() {
		logger.info("getReservationList() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		List<Reservation> reservation = reservationService.showReservationList();
		int cntListItem = reservationService.getNumOfReservation();
		logger.info("cntListItem : {}", cntListItem);

		HashMap<String, Object> hashmap = new HashMap<>();
		hashmap.put("reservation", reservation);
		hashmap.put("cntListItem", cntListItem);
		return new ResponseEntity<HashMap<String, Object>>(hashmap, headers, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.OPTIONS)
	public ResponseEntity<Integer> optionBoard() {
		logger.info("optionBoard() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		return new ResponseEntity<Integer>(headers, HttpStatus.OK);
	}

}
