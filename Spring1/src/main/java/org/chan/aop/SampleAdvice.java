package org.chan.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	//@Before  SampleService를 시작하기전에 밑에 메소드를 먼저 실행하는 어나테이션
	@Before("execution(* org.chan.service.SampleService*.*(..))")
	public void startLog() {
		logger.info("...................................");
		logger.info("...................................");
	
	}
	@Before("execution(* org.chan.service.SampleService*.*(..)) && args(str1,str2)")
	public void WithParam(String str1, String str2) {
		logger.info("str1 = "+str1);
		logger.info("str2 = "+str2);
	}
}
