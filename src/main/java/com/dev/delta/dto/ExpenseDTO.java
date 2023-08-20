package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.ExpenseRepository;

@Service
public class ExpenseDTO implements DTO {

	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	public void populate() {
		expense.setAmount("");
		expense.setDate("");
		expense.setDescription("");
		expense.setInvoiceNumber("");
		expense.setName("");
		expenseRepository.save(expense);
	}

}
