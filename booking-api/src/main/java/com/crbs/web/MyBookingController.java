package com.crbs.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crbs.model.MyBooking;
import com.crbs.service.mybooking.MyBookingService;

@RestController
@RequestMapping("/v0.0.3/crbs/mybooking")
public class MyBookingController {

	private static final Logger logger = LoggerFactory.getLogger(MyBookingController.class);
	
	@Autowired
	MyBookingService myBookingService;

	@CrossOrigin(origins="*")
	@RequestMapping(value = "", method = RequestMethod.OPTIONS)
	public ResponseEntity<Integer> optionBoard() {
		logger.info("optionBoard() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		return new ResponseEntity<Integer>(headers,HttpStatus.OK);
	}	

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/{customer_id}", method = RequestMethod.GET)
	public ResponseEntity<List<MyBooking>> getMyBookingList(@PathVariable("customer_id") String customer_id){
		logger.info("getMyBookingList() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		List<MyBooking> myBooking = myBookingService.getMyBookingList(customer_id);
		if(myBooking==null)
			return new ResponseEntity<List<MyBooking>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<MyBooking>>(myBooking, headers, HttpStatus.OK);
	}
	

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/{customer_id}/{car_code}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteMyBooking(@PathVariable("customer_id") String customer_id,@PathVariable("car_code") String car_code){
		logger.info("deleteMyBooking() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		
		String result = myBookingService.deleteMyBooking(customer_id, car_code);
		logger.info(result);
		
		if(result.equals("SUCCESS"))
			return new ResponseEntity<String>("Success",headers,HttpStatus.OK);
		else
			return new ResponseEntity<String>(result,headers,HttpStatus.BAD_REQUEST);
	}

}
