package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.request.InventoryRequest;
import com.inventory.response.OrderItemResponse;
import com.inventory.service.InventoryService;



@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@PutMapping("/updateOrderItems/{id}")
	public ResponseEntity<Void> updateInventoryItems(@RequestBody InventoryRequest orderItems, @PathVariable int id) {
		if (orderItems != null){			
			inventoryService.updateInventory(orderItems,id);
			 return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
	}
	
	@GetMapping("/inventory")
	public ResponseEntity<OrderItemResponse> getAllInventoryItems(){
		OrderItemResponse result = inventoryService.getAllInventoryItems();
		return new ResponseEntity<OrderItemResponse>(result,HttpStatus.OK);
	}

}
