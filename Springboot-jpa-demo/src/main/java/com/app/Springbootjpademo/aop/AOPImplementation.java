package com.app.Springbootjpademo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class AOPImplementation {
@AfterReturning(pointcut = " execution(* com.app.Springbootjpademo.service.MerchantService.testAOP*(..))")
	public void afterReturningMerchant(JoinPoint point) {
	System.out.println("after returning advice is executed:::"+point.getArgs()[0]);	
	System.out.println("-*-*-*-point***-*-"+point.getSignature());
	}
}
