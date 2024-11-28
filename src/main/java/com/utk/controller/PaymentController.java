package com.utk.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.utk.model.Payment;
import com.utk.model.PaymentDetails;
import com.utk.service.PaymentService;

@RestController
public class PaymentController {

	private static Logger logger = Logger.getLogger(PaymentController.class.getName());

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/payment")
	public ResponseEntity<?> makePayment() {
		PaymentDetails paymentDetails = paymentService.processMoney();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);

	}

	@PostMapping("/paymentAmount")
	public ResponseEntity<?> printPaymentAmount(@RequestBody PaymentDetails paymentDetails) {
		logger.info("Payment amount is : " + paymentDetails.getAmount());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);

	}

	@PostMapping("/createPayment")
	public ResponseEntity<?> createPayment(@RequestHeader String id, @RequestBody Payment payment) {
		logger.info("Payment received with id : " + id + ". Payment amount is : " + payment.getAmount());
		Payment paymentReceived = new Payment();
		paymentReceived.setAmount(payment.getAmount());
		paymentReceived.setId(UUID.randomUUID().toString());
		return ResponseEntity.status(HttpStatus.OK).header("requestId", id).body(paymentReceived);
	}
}
