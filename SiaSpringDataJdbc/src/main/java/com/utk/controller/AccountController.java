package com.utk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utk.model.Account;
import com.utk.request.AccountRequestDTO;
import com.utk.service.AccountService;

@RestController
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/accounts")
	public List<Account> getAccountByName(@RequestParam(required = false) String name) {
		Optional<String> paramName = Optional.ofNullable(name);
		if(paramName.isPresent()) {
			return accountService.findAccountByName(name);
		}else {
			return accountService.getAllAccountDetails();
		}
		
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<?> changeAmount(@RequestBody AccountRequestDTO accountRequestDTO) {
		accountService.changeAmount(accountRequestDTO.getSenderId(), accountRequestDTO.getReceiverId(),
				accountRequestDTO.getAmount());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
}
