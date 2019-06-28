package com.woongjin.springsi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.woongjin.springsi.service.*.*(..))")
	public void loggingWithMethodName(JoinPoint joinPoint) {
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println(className + ":" + methodName + " : 로그를 남깁니다...");
	}
}
