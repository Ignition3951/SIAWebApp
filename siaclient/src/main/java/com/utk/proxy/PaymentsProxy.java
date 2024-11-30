package com.utk.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.utk.model.PaymentClient;

@FeignClient(name = "paymentClient", url = "${name.service.url}")
public interface PaymentsProxy {

	@PostMapping("/createPayment")
	PaymentClient createPayment(@RequestHeader String id, @RequestBody PaymentClient paymentClient);

}
