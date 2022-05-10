package com.order.test.controller;

import com.order.request.OrderRequest;
import com.order.request.OrderResponse;

public class DataBuilder {

	public static OrderRequest createData() {
		OrderRequest req = new OrderRequest();
		req.setCustomerId(1);
		req.setTotal(30);
		req.setOrderStatus("CREATED");
		return req;
	}

	/*
	 * public static Order orderInsertData() { //Order order = new Order();
	 * order.setTotal(80); //order.setCreated(new LocalDateTime());
	 * order.setStatus("PENDING"); return order; }
	 */
	public static OrderResponse getOrderResponse() {
		OrderResponse resp = new OrderResponse();
		resp.setCustomerId(12);
		resp.setOrderStatus("CREATED");
		resp.setOrderId(10);
		resp.setTotal(900);
		return resp;
	}

}
