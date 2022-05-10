package com.order.service;

import java.util.List;

import com.order.entity.Order;
import com.order.exceptions.RepositoryException;
import com.order.request.InventoryRequest;
import com.order.request.OrderItemResponse;
import com.order.request.OrderRequest;
import com.order.request.OrderResponse;

public interface OrderService {
	
	OrderResponse findById(int id);
	
	Order orderInsert(OrderRequest o);
	
	void insertAll(List<OrderRequest> o);
	
	void delete(int id);
	
	void update(OrderRequest orderRequest, int id) throws RepositoryException;
	
	void updateAll(List<OrderRequest> o, int id) throws RepositoryException;

	void UpdateInventory(InventoryRequest orderItems,int id) throws RepositoryException;

	OrderItemResponse findOrderItem();
}
