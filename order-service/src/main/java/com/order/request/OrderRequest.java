package com.order.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.order.entity.Billing;
import com.order.entity.OrderItem;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {
	private String orderStatus;
	private int shippingCharges;
	private int total;
	private int customerId;
	
	private List<OrderItem> orderItem;
	private Billing billing;
	
	public OrderRequest() {
	}
	
	public OrderRequest(String orderStatus, int shippingCharges, int total,
			int customerId, List<OrderItem> orderItem, Billing billing) {
		super();
		this.orderStatus = orderStatus;
		this.shippingCharges = shippingCharges;
		this.total = total;
		this.customerId = customerId;
		this.orderItem = orderItem;
		this.billing = billing;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public int getShippingCharges() {
		return shippingCharges;
	}

	public void setShippingCharges(int shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
