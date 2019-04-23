package com.rx.rest.aop;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import com.rx.rest.error.DefaultErrorAttributes;

@RestControllerAdvice
public class RestExceptionsHandler extends ResponseEntityExceptionHandler {
	
//	@ExceptionHandler
//	public void handleConstraintViolationException(
//			ConstraintViolationException ex) {
//		System.out.println("DEBUG:: ConstraintViolationException found");
//	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		DefaultErrorAttributes errorAttributes = new DefaultErrorAttributes();
		request.setAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE, status.value(), RequestAttributes.SCOPE_REQUEST);
		//request.setAttribute(DefaultErrorAttributes.ERROR_ATTRIBUTE, ex, RequestAttributes.SCOPE_REQUEST);
		System.out.println("come");
		return new ResponseEntity<>(errorAttributes.getErrorAttributes(request, false), headers, status);
	}
}
