package com.aspectorientatedprogramming.demo.aspects;

import com.aspectorientatedprogramming.demo.entities.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(1)
public class MyThirdAspectExample {
    @Before("com.aspectorientatedprogramming.demo.aspects.PointcutExpressionsExample.forDaoExcludesGettersAndSetters()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("----------->>>> third Aspect triggered");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);

        List<Object> args = Arrays.stream(joinPoint.getArgs()).toList();
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account)
            {
                if (((Account) arg).getLogin() != null) {
                    System.out.println(((Account) arg).getLogin());
                }
                if (((Account) arg).getPassword() != null) {
                    System.out.println(((Account) arg).getPassword());
                }
                else {
                    System.out.println("No login or password");
                }
            }
        }
    }

    @Around("execution( * com.aspectorientatedprogramming.demo.service.DemoService.getService(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + sign.toShortString() + " in %%%%%%%%%%%%%>>>>>> Around Advice");

        long timeBegin = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = "Exception thrown!";
            throw e;
        }
        long timeEnd = System.currentTimeMillis();
        long duration = timeEnd - timeBegin;
        System.out.println("%%%%%%%%%%%%%>>>>>> Method duration:" + duration/1000.0 + " s");
        return result;
    }
}
