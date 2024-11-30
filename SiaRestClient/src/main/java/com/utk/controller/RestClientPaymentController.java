package com.utk.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utk.model.PaymentClient;
import com.utk.proxy.RestClientPaymentProxy;

@RestController
public class RestClientPaymentController {

	private final RestClientPaymentProxy restClientPaymentProxy;

	public RestClientPaymentController(RestClientPaymentProxy restClientPaymentProxy) {
		this.restClientPaymentProxy = restClientPaymentProxy;
	}

	@PostMapping("/restClientPayment")
	public PaymentClient restClientPayment(@RequestBody PaymentClient paymentClient) {
		return restClientPaymentProxy.createPayment(paymentClient);
	}

}
