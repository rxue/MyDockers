package com.rx.rest.error;

import org.springframework.context.support.DefaultMessageSourceResolvable;

public class MyDefaultMessageSourceResolvable {
	private DefaultMessageSourceResolvable defaultMessageSourceResolvable;
	public MyDefaultMessageSourceResolvable(DefaultMessageSourceResolvable defaultMessageSourceResolvable) {
		this.defaultMessageSourceResolvable = defaultMessageSourceResolvable;
	}
	public String getCode() {
		return defaultMessageSourceResolvable.getCode();
	}

	public String[] getCodes() {
		return defaultMessageSourceResolvable.getCodes();
	}
	
	public Object[] getArguments() {
		return defaultMessageSourceResolvable.getArguments();
	}
	
	public String getDefaultMessage() {
		return defaultMessageSourceResolvable.getDefaultMessage();
	}

}
