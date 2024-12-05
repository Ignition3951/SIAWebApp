package com.utk.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utk.model.Account;
import com.utk.repository.AccountRepository;

@Service
public class TransferService {

	private final AccountRepository accountRepository;

	public TransferService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional
	public void transferAmount(long senderId, Long recieverId, BigDecimal amount) {
		Account sender = accountRepository.findAccountById(senderId);
		Account receiver = accountRepository.findAccountById(recieverId);

		BigDecimal newSenderAmount = sender.getAmount().subtract(amount);
		BigDecimal newReceiverAmount = receiver.getAmount().add(amount);

		accountRepository.updateAmount(senderId, newSenderAmount);
		accountRepository.updateAmount(recieverId, newReceiverAmount);

		// throw new RuntimeException("OOPS! Something bad happened!!!!!!!!!!!!!!");
	}

	public List<Account> getAllAccounts() {
		return accountRepository.getAllAccounts();
	}

}
