package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.InventoryRepository;

@Service
public class InventoryDTO implements DTO{

	@Autowired
	InventoryRepository  inventoryRepository;
	
	@Override
	public void populate() {
		inventory.setDescription("");
		inventory.setItemCategory("");
		inventory.setName("");
		inventory.setUnit("");
	 inventoryRepository.save(inventory);
	}

}
