package com.utk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utk.exception.NotEnoughMoneyException;
import com.utk.model.ErrorDetails;
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
		try {
			PaymentDetails paymentDetails = paymentService.processMoney();
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
		} catch (NotEnoughMoneyException e) {
			ErrorDetails errorDetails = new ErrorDetails();
			errorDetails.setMessage("Not Enough money to pay the amount!!!!!!!!!!!!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(errorDetails);
		}

	}
}
