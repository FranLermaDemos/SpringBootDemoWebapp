package com.fralermo.springbootNgDemo.infra.rest.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Component
@Slf4j
public class PricesRestLogRequestsAspect {
	
	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	
	@AfterReturning(value = ("within(com.fralermo.springbootNgDemo.infra.rest.controller..*)"), returning = "returnValue")
    public void endpointAfterReturning(JoinPoint p, Object returnValue) {
		
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            log.debug("\nResponse object: \n" + mapper.writeValueAsString(returnValue));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }
	
}
