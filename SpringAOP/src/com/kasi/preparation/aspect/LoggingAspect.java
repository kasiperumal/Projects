package com.kasi.preparation.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	
	public void LoggingAdvice() {
		System.out.println("Logging Advice run");
	}
	
	@After("@annotation(com.kasi.preparation.aspect.Loggable)")
	public void LoggingAfterAdvice() {
		System.out.println("Logging After Advice run");
	}
	
}
