package com.rx.rest.error;

import java.util.List;

import org.springframework.validation.ObjectError;

public interface ErrorAttributes {
	String getPath();
	String getTimestampe();
	Integer getStatus();
	String getError();
	String getException();
	List<ObjectError> getErrors();
	Object getMessage();
	String getStackTrace();
}
