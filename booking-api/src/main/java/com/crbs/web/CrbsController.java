package com.crbs.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crbs.model.Car;
import com.crbs.model.Reservation;
import com.crbs.service.CarService;
import com.crbs.service.ReservationService;

@RestController
@RequestMapping("/v0.0.3/crbs")
public class CrbsController {
	private static final Logger logger = LoggerFactory.getLogger(CrbsController.class);

	@Autowired
	ReservationService reservationService;
	@Autowired
	CarService carService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Car>> getAvailabeCarList() {
		logger.info("getAvailabeCarList() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
				List<Car> car = carService.showAvailableCarList();
		if (car == null) {
			return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Car>>(car,headers ,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/reservations", method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
		logger.info("createReservation() controller called");
		HttpHeaders headers = new HttpHeaders();
		if (reservation == null) {
			return new ResponseEntity<Reservation>(HttpStatus.BAD_REQUEST);
		}
		int i = reservationService.registerReservation(reservation);
		headers.add("A post Created - " , String.valueOf(reservation.getCustomerId()));
		headers.add("A post Created - " , String.valueOf(reservation.getCarCode()));
		headers.add("A post Created - " , String.valueOf(reservation.getStartDate()));
		headers.add("A post Created - " , String.valueOf(reservation.getEndDate()));
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		if (i == 0) {
			return new ResponseEntity<Reservation>(HttpStatus.BAD_REQUEST); 
		}  
		return new ResponseEntity<Reservation>(reservation, headers, HttpStatus.CREATED); 
	}

}
