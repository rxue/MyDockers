package com.rx.rest.config;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.Nullable;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rx.rest")
public class WebConfiguration implements WebMvcConfigurer {
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.forEach(e -> {
			if (e instanceof MappingJackson2HttpMessageConverter) {
				configureMappingJackson2HttpMessageConverter((MappingJackson2HttpMessageConverter) e);
			}
		});
	}
	/**
	 * Refer to https://stackoverflow.com/questions/34545997/put-and-post-fail-on-unknown-properties-spring-different-behavior
	 * For PUT (update) and POST (create), in case unknown properties are 
	 * added to the JSON request body, request should fail
	 * 
	 * @param converter
	 */
	private void configureMappingJackson2HttpMessageConverter(
			MappingJackson2HttpMessageConverter converter) {
		    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		    builder.failOnUnknownProperties(true);
		converter.setObjectMapper(builder.build());
	}
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		resolvers.add(0, (request, response, handler, ex) -> null);
	}
	
	
}
