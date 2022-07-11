package com.app.Springbootjpademo.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.app.Springbootjpademo.entity.MerchantDetails;
import com.app.Springbootjpademo.repository.MerchantDetailsRepo;
import com.app.Springbootjpademo.service.MerchantService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MerchantTestCtrl.class)

public class TestCtrl {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private MerchantDetailsRepo detailsRepo;
	@InjectMocks
	private MerchantDetails details;
	
	@MockBean
	private MerchantService service;
	
	@Test
	void isMerchantExistById() {
		/*
		 * MeAddress add=new MeAddress("123","add1", "add2", "add3", "Mumbai", "MH",
		 * "400060", null) MerchantDetails details=new MerchantDetails(15,
		 * "Test Merchant", "9898989898", "testEmail@gmail.com", "ASDFG1234D", add)
		 */	
		}
	
	@Test
	public void isMerchantExistByName() {

		/*
		 * mockMvc.perform(get("/employee")) .andExpect(status().isOk())
		 * .andExpect(jsonPath("$", Matchers.hasSize(1)))
		 * .andExpect(jsonPath("$[0].firstName", Matchers.is("Lokesh")));
		 */
		
	}
	
	
}
