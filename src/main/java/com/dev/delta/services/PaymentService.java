package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Payment;
import com.dev.delta.exceptions.PaymentNotFound;
import com.dev.delta.repositories.PaymentRepository;


@Service
public class PaymentService {
	@Autowired
	PaymentRepository  paymentRepository;
	
	public Payment saveOrUpdate(Payment payment)
	{
		
		return paymentRepository.save(payment);
	}
	
	public Iterable<Payment> findAll()
	{
		return paymentRepository.findAll();
	}
	
	public Payment findById(Long id)
	{
		return paymentRepository.findById(id).orElseThrow(()->new PaymentNotFound("Payment Not found."));
	}
	
	public void delete(Long id)
	{
		Payment payment=findById(id);
		paymentRepository.delete(payment);
	}
}
