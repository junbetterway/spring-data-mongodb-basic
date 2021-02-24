package com.junbetterway.springmongo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junbetterway.springmongo.dto.AccountDto;
import com.junbetterway.springmongo.entity.Account;
import com.junbetterway.springmongo.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository repository;
	
	public Account save(final AccountDto request) {
		Account account = Account.builder()
				.name(request.getName())
				.balance(request.getBalance())
				.build();
		return repository.save(account);
	}
	
	public Optional<Account> findById(final Long id) {
		return repository.findById(id);
	}
	
}
