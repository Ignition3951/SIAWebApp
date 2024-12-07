package com.utk;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.utk.model.Account;
import com.utk.repository.AccountRepository;
import com.utk.service.AccountService;

@SpringBootTest
public class TransferServiceSpringIntegrationTest {

	@MockitoBean
	private AccountRepository accountRepository;

	@Autowired
	private AccountService accountService;

	@Test
	public void happyTransferAmountIntegrationTest() {
		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(new BigDecimal(700));

		Account receiver = new Account();
		receiver.setId(2);
		receiver.setAmount(new BigDecimal(500));

		when(accountRepository.findById(sender.getId())).thenReturn(Optional.of(sender));
		when(accountRepository.findById(receiver.getId())).thenReturn(Optional.of(receiver));

		accountService.changeAmount(1l, 2l, new BigDecimal(240));

		verify(accountRepository).changeAmount(1, new BigDecimal(460));
		verify(accountRepository).changeAmount(2, new BigDecimal(740));

	}
}
