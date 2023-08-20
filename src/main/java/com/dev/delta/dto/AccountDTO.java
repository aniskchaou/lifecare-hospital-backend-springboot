package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.AccountRepository;

@Service
public class AccountDTO implements DTO {

	@Autowired
	AccountRepository accountRepository;
	@Override
	public void populate() {
		account.setDescription("ipsum");
		account.setName(";n");
		account.setStatus("lkn");
		account.setType("klmlk");
		
		accountRepository.save(account);
	}
}
