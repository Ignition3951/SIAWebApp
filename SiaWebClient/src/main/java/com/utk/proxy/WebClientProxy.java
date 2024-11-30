package com.utk.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.utk.model.PaymentClient;

import reactor.core.publisher.Mono;

@Component
public class WebClientProxy {

	private final WebClient webClient;

	@Value("${name.service.url}")
	private String webClientUri;

	public WebClientProxy(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<PaymentClient> createWebClientPayment(PaymentClient paymentClient) {
		return webClient.post().uri(webClientUri + "/createPayment").header("id", UUID.randomUUID().toString())
				.body(Mono.just(paymentClient), PaymentClient.class).retrieve().bodyToMono(PaymentClient.class);
	}

}
