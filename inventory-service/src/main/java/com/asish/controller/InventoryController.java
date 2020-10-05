package com.asish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asish.entities.Inventory;
import com.asish.repository.InventoryRepository;

@RestController
public class InventoryController {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@GetMapping("/api/inventory/{productCode}")
	public ResponseEntity<Inventory> findInventoryByProductCode(@PathVariable("productCode") String productCode){
		
		Optional<Inventory> inventoryItem = inventoryRepository.findByProductCode(productCode);
		
		if(inventoryItem.isPresent()){
			return new ResponseEntity(inventoryItem, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/api/inventory")
	public List<Inventory> findAllInventory(){
		
		return inventoryRepository.findAll();
	}
	
	
	
}
