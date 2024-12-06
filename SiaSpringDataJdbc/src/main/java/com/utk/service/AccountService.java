package com.utk.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utk.exception.AccountNotFoundException;
import com.utk.model.Account;
import com.utk.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public List<Account> findAccountByName(String name) {
		return accountRepository.findAccountByName(name);
	}

	public List<Account> getAllAccountDetails() {
		return accountRepository.getAllAccountDetails();
	}

	@Transactional
	public void changeAmount(Long senderId, Long receiverId, BigDecimal amount) {
		Account newSenderId = accountRepository.findById(senderId)
				.orElseThrow(() -> new AccountNotFoundException());
		Account newReceiverId = accountRepository.findById(receiverId)
				.orElseThrow(() -> new AccountNotFoundException());
		BigDecimal newSenderAmount = newSenderId.getAmount().subtract(amount);
		BigDecimal newReceiverAmount = newReceiverId.getAmount().add(amount);

		accountRepository.changeAmount(senderId, newSenderAmount);
		accountRepository.changeAmount(receiverId, newReceiverAmount);
	}

}
