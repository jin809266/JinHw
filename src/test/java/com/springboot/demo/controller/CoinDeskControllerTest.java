package com.springboot.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoinDeskControllerTest{

	@Autowired
	CoinDeskController coinDeskController;

	@Autowired
	private MockMvc mockMvc;

	// 1. test get coinDesk data by coinCode
	@Test
	public void getCoinDeskAPI() throws Exception 
	{
	      mockMvc.perform( MockMvcRequestBuilders
	      .get("/coinDesks/{coinCode}", "USD")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.coinCode").value("USD"))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.coinRate").exists());
	}
	
	
	// 2. test add coinDesk data
	@Test
	public void testAddCoinDesk() throws Exception {

		JSONObject request = new JSONObject().put("coinCode", "JPY").put("coinRate", 0.25);
		mockMvc.perform(MockMvcRequestBuilders
		.post("/coinDesk")
		.content(request.toString())
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
        .andExpect(status().isCreated());
	}
	
	// 3. test update coinDesk data 
	@Test
	public void updateCoinDeskAPI() throws Exception 
	{
		   JSONObject request = new JSONObject().put("coinCode", "USD").put("coinRate", 0.26);
		   mockMvc.perform( MockMvcRequestBuilders
	      .put("/coinDesk/USD", 0.26)
	      .content(request.toString())
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.coinCode").value(request.getString("coinCode")))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.coinRate").value(request.getInt("coinRate")))
		  .andDo(print());
	}
	
	// 4. test delete coinDesk data by coinCode
	@Test
	public void deleteCoinDeskAPI() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/coinDesk/{coinCode}", "USD"))
		       .andExpect(status().isOk());
	}
	
	// 5. test call coinDesk API
	@Test
	public void callCoinDeskAPI() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/coinDesk"))
		       .andExpect(status().isOk())
		       .andDo(print());
	}
	
	// 6. test call coinDesk exchange API
	@Test
	public void callCoinDeskExchangeAPI() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/coinDesk/exchange"))
			   .andExpect(status().isOk())
			   .andDo(print());
	}
	
}
