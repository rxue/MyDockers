package com.rx.rest.controller;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class AbstractExceptionHandlingController {
//	@ExceptionHandler
//	@ResponseStatus(value=HttpStatus.NOT_FOUND)
//	protected String handleResourceNotFound(ResourceNotFoundException e) {
//		return e.getMessage();
//	}
}
