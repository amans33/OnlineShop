package com.order.request;

import java.util.List;

public class OrderItemResponse {
	private List<String> itemName;
	private List<Integer> itemQuantity;
	public List<String> getItemName() {
		return itemName;
	}
	public void setItemName(List<String> itemName) {
		this.itemName = itemName;
	}
	public List<Integer> getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(List<Integer> itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public OrderItemResponse(List<String> itemName, List<Integer> itemQuantity) {
		super();
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}
	public OrderItemResponse() {
		super();
	}
	
}
