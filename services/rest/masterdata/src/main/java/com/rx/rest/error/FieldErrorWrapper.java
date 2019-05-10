package com.rx.rest.error;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.FieldError;

public class FieldErrorWrapper {//implements MessageSourceResolvable

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
	public Object[] getArguments() {
		MyDefaultMessageSourceResolvable[] args = new MyDefaultMessageSourceResolvable[fieldError.getArguments().length];
		int i = 0;
		for (Object o : fieldError.getArguments()) {
			DefaultMessageSourceResolvable d = (DefaultMessageSourceResolvable) o;
			args[i++] = (new MyDefaultMessageSourceResolvable(d));
		}
		System.out.println("DEBUG::" + args);
		return fieldError.getArguments();
	}
	
	public String[] getCodes() {
		return fieldError.getCodes();
	}
	public boolean getBindingFailure() {
		return fieldError.isBindingFailure();
	}
	public String getCode() {
		return fieldError.getCode();
	}

}
