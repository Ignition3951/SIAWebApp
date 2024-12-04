package com.utk.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.utk.exception.NotEnoughMoneyException;
import com.utk.model.ErrorDetails;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(NotEnoughMoneyException.class)
	public ResponseEntity<ErrorDetails> notEnoughMoneyExceptionHandler() {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage("Not enough money to make the payment!!!!!!!!");
		return ResponseEntity.badRequest().body(errorDetails);
	}
}
