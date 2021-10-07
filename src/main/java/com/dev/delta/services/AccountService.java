package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Account;
import com.dev.delta.exceptions.AccountNotFound;
import com.dev.delta.repositories.AccountRepository;


@Service
public class AccountService {
	@Autowired
	AccountRepository  accountRepository;
	
	public Account saveOrUpdate(Account account)
	{
		
		return accountRepository.save(account);
	}
	
	public Iterable<Account> findAll()
	{
		return accountRepository.findAll();
	}
	
	public Account findById(Long id)
	{
		return accountRepository.findById(id).orElseThrow(()->new AccountNotFound("Account Not found."));
	}
	
	public void delete(Long id)
	{
		Account account=findById(id);
		accountRepository.delete(account);
	}
}
