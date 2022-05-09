package com.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.order.exceptions.RepositoryException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Billing;
import com.order.entity.Order;
import com.order.entity.OrderItem;
import com.order.repository.OrderItemRepository;
import com.order.repository.OrderRepository;
import com.order.request.InventoryRequest;
import com.order.request.OrderItemResponse;
import com.order.request.OrderRequest;
import com.order.request.OrderResponse;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private OrderItemRepository orderItemRepo;

	@Override
	public OrderResponse findById(int id) {
		log.info("Finding order by Id: {}", id);
		Optional<Order> orderResult = orderRepo.findById(id);
		OrderResponse response = new OrderResponse();
		if (orderResult.isPresent()) {
			Order ordResult = orderResult.get();
			response.setCustomerId(ordResult.getCustomerId());
			response.setOrderId(ordResult.getId());
			response.setOrderStatus(ordResult.getStatus());
			response.setTotal(ordResult.getTotal());
			List<OrderItem> orderItemResult = orderItemRepo.findAllById(id);
			if (!orderItemResult.isEmpty()) {
				List<String> itemName = new ArrayList<>();
				List<Integer> quantity = new ArrayList<>();
				for (OrderItem item : orderItemResult) {
					itemName.add(item.getItemName());
					quantity.add(item.getItemQuantity());
				}
				response.setItemName(itemName);
				response.setItemQuantity(quantity);
			}
		} else {
			log.error("Order is empty.");
			return null;
		}
		return response;
	}

	@Override
	public Order orderInsert(OrderRequest req) {
		log.info("Inserting Order : {}", req.toString());
		String status = req.getOrderStatus();
		int total = req.getTotal();
		int shipCharge = req.getShippingCharges();
		int customerId = req.getCustomerId();

		List<OrderItem> orderItem = req.getOrderItem();
		Billing billing = req.getBilling();

		Order orderObj = new Order(status, total, shipCharge, customerId, orderItem, billing);

		orderRepo.save(orderObj);

		return orderObj;
	}

	@Override
	public void insertAll(List<OrderRequest> o) {
		if (o != null) {
			log.info("Inserting Bulk Order");
			for (OrderRequest ord : o) {
				this.orderInsert(ord);
			}
		}
	}

	@Override
	public void delete(int id) {
		if (id != 0) {
			log.info("Deleting order by Id: {}", id);
			orderRepo.deleteById(id);
		}
	}

	@Override
	public void updateAll(List<OrderRequest> o, int id) throws RepositoryException {
		log.info("Updating list of order of size : {}", o.size());
		for (OrderRequest ord : o) {
			this.update(ord, id);
		}
	}

	@Override
	public void update(OrderRequest request, int id) throws RepositoryException {

		log.info("Updating order of id : {}", id);
		Optional<Order> order = orderRepo.findById(id);
		if (order.isPresent()) {

			// orderRepo.deleteById(id);
			order.get().setOrderItem(request.getOrderItem());
			order.get().setBilling(request.getBilling());
			order.get().setStatus(request.getOrderStatus());
			order.get().setCustomerId(request.getCustomerId());
			order.get().setTotal(request.getTotal());
			order.get().setShippingCharge(request.getShippingCharges());

			/*
			 * String status = o.getOrderStatus(); int total = o.getTotal(); int shipCharge
			 * = o.getShippingCharges(); int customerId = o.getCustomerId();
			 * 
			 * List<OrderItem> orderItem = o.getOrderItem(); Billing billing =
			 * o.getBilling();
			 * 
			 * Order orderObj = new Order(status, total, shipCharge, customerId, orderItem,
			 * billing);
			 */

			orderRepo.save(order.get());

		} else {
			throw new RepositoryException("order not present id : " + id);
		}

	}

	@Override
	public void UpdateInventory(InventoryRequest order, int id) throws RepositoryException {
		Optional<OrderItem> orderItem = orderItemRepo.findById(id);
		if(orderItem.isPresent()) {
			orderItem.get().setItemName(order.getItemName());
			orderItem.get().setItemQuantity(order.getItemQuantity());
			orderItemRepo.save(orderItem.get());
		}else {
			log.error("OrderItems is empty with Id - " +id);
			throw new RepositoryException("order not present id : " + id);
		}

	}

	@Override
	public OrderItemResponse findOrderItem() {
		List<OrderItem> orderItemResult = orderItemRepo.findAll();//orderItemRepo.findAllById(id);
		OrderItemResponse response = new OrderItemResponse();
		if (!orderItemResult.isEmpty()) {
			List<String> itemName = new ArrayList<>();
			List<Integer> quantity = new ArrayList<>();
			for (OrderItem item : orderItemResult) {
				itemName.add(item.getItemName());
				quantity.add(item.getItemQuantity());
			}
			response.setItemName(itemName);
			response.setItemQuantity(quantity);
		}else {
			log.error("Order Items is empty.");
			return null;
		}
		return response;
	}
}