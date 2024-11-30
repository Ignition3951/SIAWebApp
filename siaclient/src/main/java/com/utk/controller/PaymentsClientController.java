package com.utk.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utk.model.PaymentClient;
import com.utk.proxy.PaymentsProxy;

@RestController
public class PaymentsClientController {

	private final PaymentsProxy paymentsProxy;

	public PaymentsClientController(PaymentsProxy paymentsProxy) {
		this.paymentsProxy = paymentsProxy;
	}

	@PostMapping("/payment")
	public PaymentClient createPayment(@RequestBody PaymentClient paymentClient) {
		String requestId = UUID.randomUUID().toString();
		return paymentsProxy.createPayment(requestId, paymentClient);
	}
}
