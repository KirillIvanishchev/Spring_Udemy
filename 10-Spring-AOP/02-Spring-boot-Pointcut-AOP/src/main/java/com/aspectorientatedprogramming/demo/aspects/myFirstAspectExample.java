package com.aspectorientatedprogramming.demo.aspects;
import com.aspectorientatedprogramming.demo.entities.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.AccessFlag;
import java.util.List;

@Aspect
@Component
@Order(3)
public class ThrowingmyFirstAspectExample {
    @Before("com.aspectorientatedprogramming.demo.aspects.PointcutExpressionsExample.forDaoExcludesGettersAndSetters()")
    public void beforeAddAccount() {
        System.out.println("----------->>>> first Aspect triggered");
    }

    @AfterThrowing(pointcut = "execution( * com.aspectorientatedprogramming.demo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {

        System.out.println("???????????>>>> AfterThrowing Aspect triggered");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);
    }

    @After("execution( * com.aspectorientatedprogramming.demo.dao.AccountDAO.findAccounts(..))")
    public void afterExecution(JoinPoint joinPoint) {
        System.out.println("***********>>>> After Aspect triggered");
    }
}
