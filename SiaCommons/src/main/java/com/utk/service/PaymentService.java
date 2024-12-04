package com.utk.service;

import org.springframework.stereotype.Service;

import com.utk.exception.NotEnoughMoneyException;
import com.utk.model.PaymentDetails;

@Service
public class PaymentService {

	public PaymentDetails processMoney() {
		throw new NotEnoughMoneyException();
	}

}
