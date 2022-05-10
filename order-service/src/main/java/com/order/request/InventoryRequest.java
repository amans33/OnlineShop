package com.order.request;

public class InventoryRequest {

	private int itemQuantity;
	private String itemName;

	public InventoryRequest() {
		super();
	}

	public InventoryRequest(int itemQuantity, String itemName) {
		super();
		this.itemQuantity = itemQuantity;
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
