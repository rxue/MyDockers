package com.rx.rest.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.rx.rest.error.DefaultErrorAttributes;

@RestController
public class ErrorController {
	
	@RequestMapping(value = "/error")
    public Map<String,Object> renderError(HttpServletRequest httpRequest, WebRequest webRequest) {
		return new DefaultErrorAttributes().getErrorAttributes(webRequest, false);
    }
	
	
}
