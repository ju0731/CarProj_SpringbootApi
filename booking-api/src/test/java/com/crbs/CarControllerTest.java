package com.crbs;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crbs.model.Car;
import com.crbs.service.car.CarService;
import com.crbs.web.CrbsController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CarControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(CarControllerTest.class);

	@Mock
	private CarService carService;
	
	@InjectMocks
	private CrbsController carController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
	}
	
	@Test
	public void createCarInfoTest() throws Exception {
when(carService.registerCarInfo(any(Car.class))).thenReturn(1);
		
		mockMvc.perform(post("/v0.0.3/crbs/admins").contentType(MediaType.APPLICATION_JSON)
				.content(" {\r\n" + 
						"            \"code\": \"12가3456\",\r\n" + 
						"            \"name\": \"new audi\",\r\n" + 
						"            \"price\": 15000,\r\n" + 
						"            \"color\": \"red\",\r\n" + 
						"            \"fuel\": \"gasolin\",\r\n" + 
						"            \"displacement\": 3500,\r\n" + 
						"            \"size\": \"중형\",\r\n" + 
						"            \"imageUrl\": null,\r\n" + 
						"            \"cnt\": 9\r\n" + 
						"        }").accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andDo(print());
		
	}
	
	@Test
	public void deleteCarInfoTest() throws Exception {
		when(carService.removeCarInfoByCode("CRBS0001")).thenReturn(1);
		logger.info("delete - i : {}", carService.removeCarInfoByCode("CRBS0001"));

	}
	
	@Test
	public void updateCarInfoTest() throws Exception {
		Car c = new Car("CRBS0001", "new audi", 15000, "red", "gasolin", 3500, "중형", null, 9);
		when(carService.renewCarInfoByCode(c, "CRBS0001")).thenReturn(1);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/v0.0.3/crbs/admin/{code}", "CRBS0001").contentType(MediaType.APPLICATION_JSON)
			.content("  {\r\n" + 
					"            \"name\": \"new audi2\",\r\n" + 
					"            \"price\": 16000\r\n" + 
					"        }")
			.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
	}
	
}
