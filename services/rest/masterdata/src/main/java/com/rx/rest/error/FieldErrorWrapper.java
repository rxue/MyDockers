package com.rx.rest.error;


import org.springframework.validation.FieldError;

public class FieldErrorWrapper {
	private FieldError fieldError;
	public FieldErrorWrapper(FieldError fieldError) {
		this.fieldError = fieldError;
	}
	public String getObjectName() {
		return fieldError.getObjectName();
	}
	public String getField() {
		return fieldError.getField();
	}
	public Object getRejectedValue() {
		return fieldError.getRejectedValue();
	}
	public String getDefaultMessage() {
		return fieldError.getDefaultMessage();
	}

}
