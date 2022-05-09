package com.inventory.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inventory.request.InventoryRequest;
import com.inventory.response.OrderItemResponse;

@Service
public class InventoryService {

	public void updateInventory(InventoryRequest orderItems, int id) {
		String url = "http://localhost:8085/api/v1/order/updateOrderItems/{id}";
		HttpEntity<InventoryRequest> httpEntity = new HttpEntity<InventoryRequest>(orderItems);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Void.class, id);
	}

	public OrderItemResponse getAllInventoryItems() {
		String uri = "http://localhost:8085/api/v1/order/inventory";
		RestTemplate restTemplate = new RestTemplate();
		OrderItemResponse response = restTemplate.getForObject(uri, OrderItemResponse.class);
		return response;
	}

}
