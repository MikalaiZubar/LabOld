package com.epam.zubar.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.epam.zubar.web.HomeController;

public class HomeControllerTest {

	@Test
	public void testHomeController() throws Exception{
		HomeController hc = new HomeController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(hc).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
		Assert.assertEquals("home", hc.home());
	}
}
