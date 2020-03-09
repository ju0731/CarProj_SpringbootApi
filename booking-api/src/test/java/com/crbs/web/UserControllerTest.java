package com.crbs.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.crbs.model.User;
import com.crbs.service.user.UserService;
import com.crbs.web.UserController;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

	@Mock
	private UserService userService; // test 목적으로 생성한 일종의 가짜 service 객체
	@InjectMocks
	private UserController userController;
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	//회원가입 Test
	@Test
	public void signupTest() throws Exception {
		when(userService.insertUser(any(User.class))).thenReturn(1);
		logger.info("signupTest() controller called");
		mockMvc.perform(post("/v0.0.3/crbs/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":\"bo123\",\r\n\"name\":\"bobo\",\r\n\"password\":\"123\",\r\n\"phonenumber\":\"010-2345-9292\",\r\n\"isadmin\":\"0\"\r\n}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated());
	}
	//회원삭제 Test
	@Test
	public void deleteUserTest() throws Exception {
		when(userService.deleteUser(anyString())).thenReturn(1);
		logger.info("deleteUserTest() controller called");
		mockMvc.perform(delete("/v0.0.3/crbs/users/{id}","sd"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	//회원정보 수정 Test
	@Test
	public void updateUserTest() throws Exception {
		when(userService.updateUser(anyString(), any(User.class))).thenReturn(1);
		logger.info("updateUserTest() controller called");
		mockMvc.perform(put("/v0.0.3/crbs/users/{id}","sd")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"phonenumber\":\"010-2345-9292\"\r\n}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated());
	}
	//회원정보 수정 Test
	@Test
	public void signinTest() throws Exception {
		when(userService.login(anyString(), anyString())).thenReturn(1);
		logger.info("signinTest() controller called");
		mockMvc.perform(get("/v0.0.3/crbs/users/signin")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":\"bo123\",\r\n\"password\":\"123\"\r\n}")
				.accept(MediaType.APPLICATION_JSON))	
				.andDo(print())
				.andExpect(status().isOk());
	}
	
}
