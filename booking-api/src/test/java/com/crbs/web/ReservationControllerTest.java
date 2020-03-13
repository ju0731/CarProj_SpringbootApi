package com.crbs.web;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crbs.model.Reservation;
import com.crbs.service.reservation.ReservationService;
import com.crbs.web.CrbsController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ReservationControllerTest {
	
	@Mock
	private ReservationService reservationService;
	
	@InjectMocks
	private CrbsController reservationController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
	}
	
	@Test
	public void createReservationTest() throws Exception {
		when(reservationService.registerReservation(any(Reservation.class))).thenReturn(1);
		
		mockMvc.perform(post("/v0.0.3/crbs/reservations").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + 
						"	\"customerId\": \"123bb\",\r\n" + 
						"    \"carCode\": \"crbs0008\",\r\n" + 
						"    \"startDate\": \"2020-03-13\",\r\n" + 
						"    \"endDate\": \"2020-03-20\"\r\n" + 
						"}").accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andDo(print());
		
	}
	
	@Test
	public void getReservationListTest() throws Exception {
		List<Reservation> list = Arrays.asList(new Reservation("sh1010", "CRBS0001", new Date(), new Date()));
		when(reservationService.showReservationList()).thenReturn(list);

		mockMvc.perform(get("/v0.0.3/crbs/users/myreservs").characterEncoding("utf-8")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].customer_id", is("sh1010"))).andExpect(jsonPath("$[0].car_code", is("CRBS0001"))).andDo(print());
	}
}
