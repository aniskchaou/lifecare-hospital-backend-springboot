package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Income;
import com.dev.delta.exceptions.IncomeNotFoundException;
import com.dev.delta.repositories.IncomeRepository;

@Service
public class IncomeService {
	@Autowired
	IncomeRepository incomeRepository;
	
	
	public Income addIncome(Income income)
	{
		return incomeRepository.save(income);
	}
	
	public List<Income> findAll()
	{
		return incomeRepository.findAll();
	}
	
	
	public Income updateIncome(Income income)
	{
		return incomeRepository.save(income);
	}
	
	public Income findIncomeById(Long id) 
	{
		
		return incomeRepository
				.findById(id)
				.orElseThrow(()->new IncomeNotFoundException("Income is not found"));
	}
	
	public void deleteIncome(Long id)
	{
		incomeRepository.deleteById(id);
	}
	
}
