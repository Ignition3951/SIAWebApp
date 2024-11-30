package com.utk.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.utk.model.PaymentClient;

@Component
public class RestClientPaymentProxy {

	private final RestTemplate restTemplate;

	@Value("${name.service.url}")
	private String restTemplateUri;

	public RestClientPaymentProxy(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public PaymentClient createPayment(PaymentClient paymentClient) {
		String postPaymentUrl = restTemplateUri + "/createPayment";
		HttpHeaders headers = new HttpHeaders();
		headers.add("id", UUID.randomUUID().toString());
		HttpEntity<PaymentClient> entity = new HttpEntity<>(paymentClient, headers);

		ResponseEntity<PaymentClient> response = restTemplate.exchange(postPaymentUrl, HttpMethod.POST, entity,
				PaymentClient.class);

		return response.getBody();

	}

}
