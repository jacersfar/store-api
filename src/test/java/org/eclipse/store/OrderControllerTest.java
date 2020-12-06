package org.eclipse.store;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.eclipse.controllers.OrderController;
import org.eclipse.helper.Mapper;
import org.eclipse.models.Order;
import org.eclipse.services.IService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private IService<Order> mockedOrderService;
	@InjectMocks
	private OrderController orderController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}
	@Test
	public void shouldReturnOrderList() throws Exception {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order(Calendar.getInstance(), "PENDING", null, null));
		orderList.add(new Order(Calendar.getInstance(), "ACCEPTED", null, null));
		when(this.mockedOrderService.find()).thenReturn(orderList);
		this.mockMvc.perform(get("/order/find")).andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2))).andDo(print());
	}
	
	@Test
	public void shouldAddOrderSuccessfully() throws Exception {
		Order order = new Order(Calendar.getInstance(), "PENDING", null, null);
		doNothing().when(this.mockedOrderService).add(any(Order.class));
		this.mockMvc.perform(post("/order/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(order))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void shouldFailAddingOrderAndReturnClientError() throws Exception {
		this.mockMvc.perform(post("/order/add")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().is4xxClientError())
				.andDo(print());
	}
	
	@Test
	public void shouldUpdateOrderSuccessfully() throws Exception {
		Order order = new Order(Calendar.getInstance(), "PENDING", null, null);
		doNothing().when(this.mockedOrderService).update(any(Order.class));
		this.mockMvc.perform(put("/order/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(order))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void shouldFailUpdatingOrderAndReturnClientError() throws Exception {
		this.mockMvc.perform(put("/order/update")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().is4xxClientError())
				.andDo(print());
	}
	
	@Test
	public void shouldDeleteProductSuccessfully() throws Exception {
		Order order = new Order(Calendar.getInstance(), "PENDING", null, null);
		doNothing().when(this.mockedOrderService).delete(any(Order.class));
		this.mockMvc.perform(delete("/order/delete")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(order))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void shouldFailDeletingAndReturnClientError() throws Exception {
		this.mockMvc.perform(delete("/order/delete")
				).andExpect(status().is4xxClientError())
				.andDo(print());
	}
}
