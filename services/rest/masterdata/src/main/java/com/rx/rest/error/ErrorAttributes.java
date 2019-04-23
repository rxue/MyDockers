package com.rx.rest.error;

import java.util.Map;

import org.springframework.web.context.request.WebRequest;

public interface ErrorAttributes {
	Throwable getError(WebRequest request);
	Map<String,Object> getErrorAttributes(WebRequest request,
            boolean includeStackTrace);
}
