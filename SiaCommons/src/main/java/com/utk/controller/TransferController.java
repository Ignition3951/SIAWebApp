package com.utk.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utk.model.Account;
import com.utk.request.TransferRequest;
import com.utk.service.TransferService;

@RestController
public class TransferController {

	private static final java.util.logging.Logger logger = java.util.logging.Logger
			.getLogger(TransferController.class.getName());

	private final TransferService transferService;

	public TransferController(TransferService transferService) {
		this.transferService = transferService;
	}

	@PostMapping("/transfer")
	public ResponseEntity<?> transferAmount(@RequestBody TransferRequest request) {
		logger.info("Request received with sender Id : " + request.getSenderId() + " receiver Id : "
				+ request.getRecieverId() + " and amount : " + request.getAmount());
		transferService.transferAmount(request.getSenderId(), request.getRecieverId(), request.getAmount());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return transferService.getAllAccounts();
	}

}
