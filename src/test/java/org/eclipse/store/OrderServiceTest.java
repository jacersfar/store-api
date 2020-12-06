package org.eclipse.store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.eclipse.IDAO.IDAO;
import org.eclipse.models.Order;
import org.eclipse.services.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
	
	@Mock
	private IDAO<Order> mockedOrderDAO;
	
	@InjectMocks
	private OrderService orderService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnOrderList() {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order(1, Calendar.getInstance(),"PENDING", null, null));
		orderList.add(new Order(2, Calendar.getInstance(),"PENDING", null, null));
		when(this.mockedOrderDAO.find()).thenReturn(orderList);
		assertTrue(this.orderService.find().size() == orderList.size());
	}
	
	@Test
	public void shouldAddOrderSuccessfully() {
		this.orderService.add(new Order(1, Calendar.getInstance(),"PENDING", null, null));
		verify(this.mockedOrderDAO, times(1)).add(any(Order.class));
	}
	
	@Test
	public void shouldUpdateOrderSuccessfully() {
		this.orderService.update(new Order(1, Calendar.getInstance(),"PENDING", null, null));
		verify(this.mockedOrderDAO, times(1)).update(any(Order.class));
	}
	
	@Test
	public void shouldDeleteOrderSuccessfully() {
		this.orderService.delete(new Order(1, Calendar.getInstance(),"PENDING", null, null));
		verify(this.mockedOrderDAO, times(1)).delete(any(Order.class));
	}
}
