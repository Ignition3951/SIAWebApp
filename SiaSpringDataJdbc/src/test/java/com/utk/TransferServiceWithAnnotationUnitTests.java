package com.utk;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.utk.model.Account;
import com.utk.repository.AccountRepository;
import com.utk.service.AccountService;

@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationUnitTests {

	@Mock
	private AccountRepository accountRepository;

	@InjectMocks
	private AccountService accountService;

	@Test
	public void happyTransferFlow() {
		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(new BigDecimal(500));
		
		Account receiver = new Account();
		receiver.setId(2);
		receiver.setAmount(new BigDecimal(900));
		
		given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));// If any one calls
																							// accountRepository.findById()
																							// method then the object
																							// given in this will be
																							// returned
		
		given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));// If any one calls
		// accountRepository.findById()
		// method then the object
		// given in this will be
		// returned

		accountService.changeAmount(1l, 2l, new BigDecimal(250));

		verify(accountRepository).changeAmount(2, new BigDecimal(1150));// verifying that the changeAmount is called
																		// with the correct arguments

		verify(accountRepository).changeAmount(1, new BigDecimal(250));



	}
}
