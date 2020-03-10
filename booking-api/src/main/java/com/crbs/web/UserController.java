package com.crbs.web;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crbs.model.User;
import com.crbs.service.user.UserService;

@RestController
@RequestMapping("/v0.0.3/crbs/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

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
	@RequestMapping(value = "", method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		logger.info("insertUser() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		if(userService.insertUser(user)==0)
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<User>(user, headers, HttpStatus.CREATED); 
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE,produces = "application/json")
	public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
		logger.info("deleteUser() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		if(userService.deleteUser(id)==0) 
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<String>(id, headers,HttpStatus.OK);
	}	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT,produces = "application/json")
	public ResponseEntity<String> updateUser(@PathVariable("id") String id,@RequestBody User user) {
		logger.info("updateUser() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		if(userService.updateUser(id, user)==0) 
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<String>(id, headers,HttpStatus.CREATED);
	}	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<Integer> login(@RequestBody User user){
		logger.info("login() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		int login = userService.login(user.getId(), user.getPassword());
		if(login==0)
			return new ResponseEntity<Integer>(HttpStatus.UNAUTHORIZED);
		else
			return new ResponseEntity<Integer>(login, headers, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<HashMap<String, Object>> getUserData(@PathVariable("id") String id) {
		logger.info("getUserData() controller called");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		User u = userService.findUser(id);
		
		HashMap<String, Object> hashmap = new HashMap<>();
		hashmap.put("id", u.getId());
		hashmap.put("name", u.getName());
		hashmap.put("password", u.getPassword());
		hashmap.put("phonenumber", u.getPhonenumber());
	
		return new ResponseEntity<HashMap<String,Object>>(hashmap, headers, HttpStatus.OK);
	}
	
	
}
