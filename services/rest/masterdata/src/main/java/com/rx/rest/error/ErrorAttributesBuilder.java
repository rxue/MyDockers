package com.rx.rest.error;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

public class ErrorAttributesBuilder {
	private WebRequest webRequest;
	private boolean includeException;
	private boolean includeStackTrace;
	private Integer status;
	private String error;
	private String exception;
	private List<ObjectError> errors;
	private Object message;
	private String trace;
	
	public ErrorAttributesBuilder(WebRequest webRequest, boolean includeException,
			boolean includeStackTrace) {
		this.webRequest = webRequest;
		this.includeException = includeException;
		this.includeStackTrace = includeStackTrace;
		status = 0;
	}
	@SuppressWarnings("unchecked")
	private <T> T getAttribute(String name) {
		return (T) webRequest.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
	}
	private void setAttributes() {
		status = getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status == null) {
			error = "none";
			return;
		}
		setError();
		Throwable error = getAttribute(RequestDispatcher.ERROR_EXCEPTION);
		if (error != null) {
			while (error instanceof ServletException && error.getCause() != null) {
				error = ((ServletException) error).getCause();
			}
			if (includeException) setException(error);
			BindingResult result = extractBindingResult(error);
			if (result == null) {
				message = error.getMessage();
				return;
			}
			setErrors(result);
			setMessage(result, error);
			if (includeStackTrace) {
				setStackTrace(error);
			}
		}
	}
	private void setError() {
		try {
				error = HttpStatus.valueOf(status).getReasonPhrase();
		} catch (Exception e) {
				error = "Http status " + status;
		}	
	}
	private void setException(Throwable error) {
		exception = error.getClass().getName();
	}
	private void setErrors(BindingResult result) {
		errors = result.getAllErrors();
		
	}
	private void setMessage(BindingResult result, Throwable error) {
		if (result.hasErrors()) {
			this.message = "Validation failed for object='" + result.getObjectName()
							+ "'. Error count: " + result.getErrorCount();	
		} else this.message = "No errors";
		Object message = getAttribute(RequestDispatcher.ERROR_MESSAGE);
		if ((!StringUtils.isEmpty(message) || this.message == null)
				&& !(error instanceof BindingResult)) {
			this.message = StringUtils.isEmpty(message) ? "No message available" : message;
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
	private void setStackTrace(Throwable error) {
		StringWriter stackTrace = new StringWriter();
		error.printStackTrace(new PrintWriter(stackTrace));
		stackTrace.flush();
		trace = stackTrace.toString();
	}

	public ErrorAttributes build() {
		setAttributes();
		return new ErrorAttributes() {


			@Override
			public String getPath() {
				String path = getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
				return path;
			}
			
			@Override
			public String getTimestampe() {
				return ZonedDateTime.now().toString();
			}

			@Override
			public Integer getStatus() {
				return status;
			}

			@Override
			public String getError() {
				return error;
			}

			@Override
			public String getException() {
				return exception;
			}

			@Override
			public List<ObjectError> getErrors() {
				return errors;
			}

			@Override
			public Object getMessage() {
				return message;
			}

			@Override
			public String getStackTrace() {
				return trace;
			}
			
		};
	}
}
