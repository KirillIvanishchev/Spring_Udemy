package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void loggingConrollerPackage() {

    }

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void loggingServicePackage() {

    }

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void loggingDAOPackage() {

    }

    @Pointcut("loggingConrollerPackage() || loggingServicePackage() || loggingDAOPackage()")
    private void forAppFlow() {

    }

    @Before("forAppFlow()")
    private void beforeAppFlow(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=====>>> in @Before on method: " + method);

        List<Object> args = Arrays.asList(joinPoint.getArgs());
        for (Object arg : args) {
            myLogger.info("=====>>>" + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("&&&&&&&&&>>> in @AfterReturning on method: " + method);
        myLogger.info("&&&&&&&&&>>> result: " + result);
    }
}
