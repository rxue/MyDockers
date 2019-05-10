package com.rx.rest.error;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

public class ErrorAttributesBuilder {
	private WebRequest webRequest;
	boolean includeStackTrace;
	private static String NONE = "None";
	private static int NO_ERROR_STATUS_CODE = 999;
	private Integer status;
	private String errorString;
	private String exception;
	public ErrorAttributesBuilder(WebRequest webRequest, boolean includeStackTrace) {
		this.webRequest = webRequest;
		this.includeStackTrace = includeStackTrace;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getAttribute(String name) {
		return (T) webRequest.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
	}
	
	private void setStatus() {
		status = getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
		if (status == null) status = NO_ERROR_STATUS_CODE;
	}
	private void setErrorString() {
		if (status == NO_ERROR_STATUS_CODE)
			errorString = NONE;
		try {
			errorString = HttpStatus.valueOf(status).getReasonPhrase();
		}
		catch (Exception ex) {
			// Unable to obtain a reason
			errorString = "Http Status " + status;
		}
	}
	private BindingResult extractBindingResult(Throwable error) {
		if (error instanceof BindingResult) {
			return (BindingResult) error;
		}
		if (error instanceof MethodArgumentNotValidException) {
			return ((MethodArgumentNotValidException) error).getBindingResult();
		}
		return null;
	}
	
	public ErrorAttributes build() {
		setStatus();
		setErrorString();
		Throwable error = getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE);
		BindingResult bindingResult = extractBindingResult(error);
		return new ErrorAttributes() {
			@Override
			public String getTimestamp() {
				return ZonedDateTime.now().toString();
			}
			@Override
			public Integer getStatus() {
				return status;
			}
			@Override
			public String getError() {
				return errorString;
			}
			@Override
			public String getException() {
				Throwable localError = error;
				if (localError != null) {
					while (localError instanceof ServletException && localError.getCause() != null) {
						localError = ((ServletException) localError).getCause();
					}
					return localError.getClass().getName();
				}
				return null;
			}
			@Override
			public List<FieldErrorWrapper> getErrors() {
				List<ObjectError> errors = bindingResult.getAllErrors();
				List<FieldErrorWrapper> errorWrappers = new ArrayList<>();
				for (ObjectError e : errors) {
					errorWrappers.add(new FieldErrorWrapper((FieldError)e));
				}
				return errorWrappers;
			}
			@Override
			public String getMessage() {
				String errorMessage = null;
				if (bindingResult == null) {
					errorMessage = error.getMessage();
				}
				else if (bindingResult.hasErrors()) 
					errorMessage = "Validation failed for object='" + bindingResult.getObjectName()
					+ "'. Error count: " + bindingResult.getErrorCount();
				else errorMessage = "No errors";
				String message = getAttribute(WebUtils.ERROR_MESSAGE_ATTRIBUTE);
				if ((!StringUtils.isEmpty(message) || errorMessage == null)
						&& !(error instanceof BindingResult)) {
					errorMessage =
							StringUtils.isEmpty(message) ? "No message available" : message;
				}
				return errorMessage;
			}
			@Override
			public String getPath() {
				return getAttribute(WebUtils.ERROR_REQUEST_URI_ATTRIBUTE);
			}
		};
	}

}
