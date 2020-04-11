//package com.pp.controller.mockito;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;
//import static org.mockito.BDDMockito.given;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pp.controller.WebServiceController;
//import com.pp.repositary.WebServiceModel;
//import com.pp.repositary.WebServiceRepository;
//import com.pp.service.WebSrvService;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class WebServiceControllerMockitoTest {
//
//	@Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private WebSrvService webSrvService;
//    
////    private ObjectMapper objectMapper = new ObjectMapper();
//    
//    private WebServiceModel model;
//    
//    
////    @Before
////    public void setup()
////    {
////    	model = new WebServiceModel(1, "aman", "aman@gmail.com", "kjsfgvh");
////    }
////    
////    @Test
////    public void saveWebService() throws Exception
////    {
////    	given(webSrvService.saveRecord(any(WebServiceModel.class))).willReturn(model);
////    	
////    	String jsonString= objectMapper.writeValueAsString(model);
////    	
////    	mvc.perform(post("model/save")
////    			.contentType(MediaType.APPLICATION_JSON)
////    			.content(jsonString));
////    }
//    
////    @Test
////    public void findAll() throws Exception
////    {
////    	//given
////    	
////    	WebServiceModel model = new WebServiceModel(1,"khhg","jgk","kghg");
////    	
////    	List<WebServiceModel> list = Arrays.asList(model);
////    	given(webSrvService.getAllRecords()).willReturn(list);
////    	
////    	//when+then
////    	this.mockMvc.perform(get("/api/v1/stocks"))
////        .andExpect(status().isOk())
////        .andExpect(content().json("[{'uid': 1,'uname': 'khhg','umail': 'jgk' ,'upassword': 'kghg'}]"));
////    }
////    
////    @InjectMocks
////	WebServiceController controller;
////	
////	@Mock
////	WebServiceRepository employeeRepository;
////	
////	@org.junit.jupiter.api.Test
////	public void testAddEmployee() 
////	{
////		MockHttpServletRequest request = new MockHttpServletRequest();
////		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
////		
////		WebServiceModel model = new WebServiceModel();
////		when(employeeRepository.save(any(WebServiceModel.class))).thenReturn(model);
//		
////		//WebServiceModel employeeToAdd = new WebServiceModel(1,"Lokesh", "Gupta", "howtodoinjava@gmail.com");
////		ResponseEntity responseEntity = controller.saveRecord(employeeToAdd);
////
////		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
////		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
//	}
//    
//    
//}