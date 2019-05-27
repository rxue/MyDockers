package com.rx.rest.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.rx.rest.error.ErrorAttributes;
import com.rx.rest.error.ErrorAttributesBuilder;

@RestController
public class ErrorController {
	
	@RequestMapping(value = "/error")
    public ErrorAttributes renderError(HttpServletRequest httpRequest, WebRequest webRequest) {
		Integer statusCode = (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
		System.out.println("DEBUG:: status code is " + statusCode);
		return new ErrorAttributesBuilder(webRequest, true, false).build();
    }
	
	
}
