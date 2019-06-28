package com.woongjin.springsi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfomanceEstimationAspect {
	
	@Around("execution(* com.woongjin.springsi.dao.*.*(..))")
	public Object estimateRunningTime(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object result = pjp.proceed();
		
		long estimated = System.currentTimeMillis() - start;
		
		System.out.println(pjp.getSignature().getName() + " : " + estimated);
		
		return result;
	}

}
