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
import com.rx.rest.error.ErrorAttributesBuilder;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {		request.setAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE, status.value(), RequestAttributes.SCOPE_REQUEST);
		String[] attrs = request.getAttributeNames(RequestAttributes.SCOPE_REQUEST);
		for (String a : attrs)
			System.out.println("DEBUG::" + a + " = " + request.getAttribute(a, RequestAttributes.SCOPE_REQUEST));
		request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, RequestAttributes.SCOPE_REQUEST);
		ErrorAttributesBuilder errorAttributesBuilder = new ErrorAttributesBuilder(request, true, false);
		//BindingResult re = ((MethodArgumentNotValidException) ex).getBindingResult();
		return new ResponseEntity<>(errorAttributesBuilder.build(), headers, status);
	}
}
