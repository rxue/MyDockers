package com.rx.rest;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 *
 */
public class MyRestAPIInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletCxt) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.setConfigLocation("com.rx.rest.config");
        servletCxt.addListener(new ContextLoaderListener(ac));

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        servlet.setEnableLoggingRequestDetails(true);
        servlet.setThrowExceptionIfNoHandlerFound(true);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("dispatcher", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/rest/*");
    }
}