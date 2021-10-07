package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Expense;
import com.dev.delta.exceptions.ExpenseNotFoundException;
import com.dev.delta.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	ExpenseRepository expenseRepository;
	
	
	public Expense addExpense(Expense expense)
	{
		return expenseRepository.save(expense);
	}
	
	public List<Expense> findAll()
	{
		return expenseRepository.findAll();
	}
	
	
	public Expense updateExpense(Expense expense)
	{
		return expenseRepository.save(expense);
	}
	
	public Expense findExpenseById(Long id) 
	{
		
		return expenseRepository
				.findById(id)
				.orElseThrow(()->new ExpenseNotFoundException("Expense is not found"));
	}
	
	public void deleteExpense(Long id)
	{
		expenseRepository.deleteById(id);
	}
	
}
