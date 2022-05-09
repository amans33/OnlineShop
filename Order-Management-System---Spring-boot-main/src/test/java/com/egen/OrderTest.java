package com.egen;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.order.entity.Billing;
import com.order.entity.OrderItem;
import com.order.request.OrderRequest;
import com.order.service.OrderService;


@DataJpaTest
public class OrderTest {
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void testCreateOrder() throws Exception {
		OrderRequest order = new OrderRequest();
		order.setOrderStatus("Accepted");
		order.setShippingCharges(12);
		order.setTotal(532);
				
		Billing billing = new Billing("Renner Road", "Praire Creek", "Dallas", "Texas", 75258);
		order.setBilling(billing);
		
		OrderItem orderItem = new OrderItem(1, "Laptop");
		List<OrderItem> listOrderItem = new ArrayList<>();
		listOrderItem.add(orderItem);
		order.setOrderItem(listOrderItem);
		
		try {
			orderService.orderInsert(order);
		}
		catch (Exception exc) {
			System.out.println("Test Failed");
		}
		
	}
}
