package com.rx.rest.error;

import java.util.List;
import java.util.Map;

import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.WebRequest;

public interface ErrorAttributes {
	public String getTimestamp();
	public Integer getStatus();
	public String getError();
	public String getException();
	public List<FieldErrorWrapper> getErrors();
	public String getMessage();
	public String getPath();
}
