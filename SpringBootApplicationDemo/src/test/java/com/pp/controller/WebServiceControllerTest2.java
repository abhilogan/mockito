package com.pp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pp.repositary.WebServiceRepository;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pp.repositary.WebServiceModel;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebServiceControllerTest2 {


	@InjectMocks
	WebServiceController webServiceController;

	@Mock
	WebServiceRepository webServiceRepository;

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void test() throws Exception{
		WebServiceModel model = new WebServiceModel();
		model.setUname("abhishek");
		model.setUmail("ajh@gmail.com");
		model.setUpassword("986598");

		String jsonRequest = om.writeValueAsString(model);

		MvcResult result = mockMvc.perform(post("/model/save").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

		String resultContent = result.getResponse().getContentAsString();
		Assert.assertThat(result.getResponse().getStatus(),is(200));
	}

	@Test
	public void getAllWebServiceTest() throws Exception {
		MvcResult result = mockMvc
				.perform(get("/model/getAll").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();

		Assert.assertThat(result.getResponse().getStatus(),is(200));
	}

	@Test
	public void getWebServiceByIdTest() throws Exception {
		MvcResult result = mockMvc
				.perform(get("/model/get/21").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();

		System.out.println(resultContent);
		Assert.assertThat(result.getResponse().getStatus(),is(200));
	}


//	@Test
//	public void testFindAll()
//	{
//		// given
//		WebServiceModel model = new WebServiceModel();
//		model.setUname("abhishek");
//		model.setUmail("ajh@gmail.com");
//		model.setUpassword("986598");
//
//		WebServiceModel model1 = new WebServiceModel();
//		model1.setUname("abhi");
//		model1.setUmail("kkkkk@gmail.com");
//		model1.setUpassword("kjhkj");
//
//
//		List<WebServiceModel> list = new ArrayList<WebServiceModel>();
//		list.addAll(Arrays.asList(model, model1));
//
//		when(webServiceRepository.findAll()).thenReturn(list);
//
//		// when
//		Response response = (Response) webServiceController.getAllRecords();
//
//		// then
//		System.out.println(response);
//	}

//	@Test
//	public void testFindAll()
//	{
//		// given
//		WebServiceModel model = new WebServiceModel();
//		model.setUname("abhishek");
//		model.setUmail("ajh@gmail.com");
//		model.setUpassword("986598");
//
//		WebServiceModel model1 = new WebServiceModel();
//		model1.setUname("abhi");
//		model1.setUmail("kkkkk@gmail.com");
//		model1.setUpassword("kjhkj");
//
//
//		List<WebServiceModel> list = new ArrayList<WebServiceModel>();
//		list.addAll(Arrays.asList(model, model1));
//
//		when(webServiceRepository.findAll()).thenReturn(list);
//
//		// when
//		ResponseEntity<List<WebServiceModel>> response =webServiceController.getAllRecords();
//
//		// then
//		System.out.println(response);
//	}

}
