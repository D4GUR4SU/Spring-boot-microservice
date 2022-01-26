package com.dagurasu.padroesapi.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.RetryableException;

@ControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity invalidName() {
		ErrorMessage msg = new ErrorMessage();
		msg.setErrorCode(400);
		msg.setMsg("The name is longer than 10 characters");

		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RetryableException.class)
	public ResponseEntity handleFeignStatusException(RetryableException e, HttpServletResponse response) {
		ErrorMessage msg = new ErrorMessage();
		msg.setErrorCode(500);
		msg.setMsg("error feign");

		return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
