package com.junbetterway.springmongo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junbetterway.springmongo.dto.AccountDto;
import com.junbetterway.springmongo.entity.Account;
import com.junbetterway.springmongo.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequestMapping("api/account")
@RestController
@RequiredArgsConstructor
public class AccountController {

	private final AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Long> create(@RequestBody AccountDto request) {
		Account newAccount = accountService.save(request);
		return new ResponseEntity<>(newAccount.getId(), HttpStatus.CREATED);
	}

	@GetMapping("{accountId}")
	public ResponseEntity<Account> read(@PathVariable Long accountId) {
		return accountService.findById(accountId)
	            .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
	            .orElse(ResponseEntity.notFound().build());
	}
	
}
