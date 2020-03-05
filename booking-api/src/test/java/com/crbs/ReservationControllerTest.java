package com.crbs;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
		
		
	}
}
