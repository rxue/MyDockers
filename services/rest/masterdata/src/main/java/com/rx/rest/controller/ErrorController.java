package com.rx.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rx.rest.error.ErrorRest;

@RestController
@RequestMapping(value = "handler")
public class ErrorController {
	
	@RequestMapping(value = "errors")
    public ErrorRest renderErrorPage(HttpServletRequest httpRequest) {
		System.out.println("DEBUG::come to error page");
		ErrorRest er = new ErrorRest();
		er.setError("errr");
        return er;
    }
}
