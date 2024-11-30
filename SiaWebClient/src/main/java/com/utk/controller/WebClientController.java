package com.utk.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utk.model.PaymentClient;
import com.utk.proxy.WebClientProxy;

import reactor.core.publisher.Mono;

@RestController
public class WebClientController {

	private final WebClientProxy webClientProxy;

	public WebClientController(WebClientProxy webClientProxy) {
		this.webClientProxy = webClientProxy;
	}

	@PostMapping("/webClientPayment")
	public Mono<PaymentClient> webClientCreatePayment(@RequestBody PaymentClient paymentClient) {
		return webClientProxy.createWebClientPayment(paymentClient);
	}

}
