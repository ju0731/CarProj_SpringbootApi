package com.crbs.web;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crbs.model.MyBooking;
import com.crbs.service.mybooking.MyBookingService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MyBookingControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
	@Mock
	private MyBookingService mybookingService;	
	@InjectMocks
	private MyBookingController mybookingController;
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mybookingController).build();
	}
	//
	@Test
	public void getMyBookingListTest() throws Exception {
		List<MyBooking> list = Arrays.asList(new MyBooking("12가3456", "new audi", 15000, new Date(), new Date()),
				new MyBooking("12가3457", "audi-ex", 18000, new Date(), new Date()));
		when(mybookingService.getMyBookingList(anyString())).thenReturn(list);
		logger.info("getMyBookingListTest() controller called");
		mockMvc.perform(get("/v0.0.3/crbs/mybooking/{customer_id}","123bb"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	//나의 예약 취소 Test
	@Test
	public void deleteMyBookingTest() throws Exception {
		when(mybookingService.deleteMyBooking(anyString(), anyString())).thenReturn(anyString());
		logger.info("deleteMyBookingTest() controller called");
		mockMvc.perform(delete("/v0.0.3/crbs/mybooking/{customer_id}/{car_code}","sd","A001"))
		.andDo(print())
		.andExpect(status().isOk());
	}
}
