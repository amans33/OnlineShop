package com.order.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.order.controller.OrderController;
import com.order.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@InjectMocks
	OrderController orderController;
	
	@Mock
	private OrderService orderService;
	
	
	@Test
	public void placeOrderTest() throws Exception {
		//when(orderService.orderInsert(Mockito.any())).thenReturn(DataBuilder.orderInsertData());
		orderController.placeOrder(DataBuilder.createData());
		assertEquals(30, DataBuilder.createData().getTotal());
	}
	
	@Test
	public void cancelOrderTest() {
		orderService.delete(12);
		orderController.cancelOrder(15);
		assertEquals(10, DataBuilder.getOrderResponse().getOrderId());
	}
	
	@Test
	public void cancelOrderTestIfIdIsNull() {
		orderService.delete(12);
		orderController.cancelOrder(0);
		assertEquals(10, DataBuilder.getOrderResponse().getOrderId());
	}
	
	
	@Test
	public void getOrderTest() {
		when(orderService.findById(12)).thenReturn(DataBuilder.getOrderResponse());
		orderController.getOrder(12);
		assertEquals(10, DataBuilder.getOrderResponse().getOrderId());
	}
	
	
}
