package com.utk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utk.model.PaymentDetails;
import com.utk.service.PaymentService;

@RestController
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/payment")
	public ResponseEntity<?> makePayment() {
		PaymentDetails paymentDetails = paymentService.processMoney();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);

	}
}
