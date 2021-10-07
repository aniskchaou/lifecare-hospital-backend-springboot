package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Inventory;
import com.dev.delta.exceptions.InventoryNotFoundException;
import com.dev.delta.repositories.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	InventoryRepository inventoryRepository;
	
	
	public Inventory addInventory(Inventory inventory)
	{
		return inventoryRepository.save(inventory);
	}
	
	public List<Inventory> findAll()
	{
		return inventoryRepository.findAll();
	}
	
	
	public Inventory updateInventory(Inventory inventory)
	{
		return inventoryRepository.save(inventory);
	}
	
	public Inventory findInventoryById(Long id) 
	{
		
		return inventoryRepository
				.findById(id)
				.orElseThrow(()->new InventoryNotFoundException("Inventory is not found"));
	}
	
	public void deleteInventory(Long id)
	{
		inventoryRepository.deleteById(id);
	}
	
	
}
