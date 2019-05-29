package com.rx.rest.aop;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;
import com.rx.rest.error.ErrorAttributesBuilder;

/**
 * @author dingding
 *
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		request.setAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE, status.value(), RequestAttributes.SCOPE_REQUEST);
		request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, RequestAttributes.SCOPE_REQUEST);
		request.setAttribute(RequestDispatcher.ERROR_REQUEST_URI, getPath(request), RequestAttributes.SCOPE_REQUEST);
		ErrorAttributesBuilder errorAttributesBuilder = new ErrorAttributesBuilder(request, true, false);
		return new ResponseEntity<>(errorAttributesBuilder.build(), headers, status);
	}

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {		
//		request.setAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE, status.value(), RequestAttributes.SCOPE_REQUEST);
//		request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, RequestAttributes.SCOPE_REQUEST);
//		request.setAttribute(RequestDispatcher.ERROR_REQUEST_URI, getPath(request), RequestAttributes.SCOPE_REQUEST);
//		ErrorAttributesBuilder errorAttributesBuilder = new ErrorAttributesBuilder(request, true, false);
//		
//		//BindingResult re = ((MethodArgumentNotValidException) ex).getBindingResult();
//		return new ResponseEntity<>(errorAttributesBuilder.build(), headers, status);
//	}
	
	private String getPath(WebRequest servletWebRequest) {
		if (servletWebRequest instanceof ServletWebRequest) {
			HttpServletRequest request = ((ServletWebRequest) servletWebRequest).getRequest();
			return request.getRequestURI(); 
		}
		return null;
	}
}
