package com.rx.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceExistingException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7992904489502842099L;
	
	public ResourceExistingException() {
		this("Resource to be created existed already!");
	}

	public ResourceExistingException(String message) {
		this(message,null);
	}
	
	public ResourceExistingException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
