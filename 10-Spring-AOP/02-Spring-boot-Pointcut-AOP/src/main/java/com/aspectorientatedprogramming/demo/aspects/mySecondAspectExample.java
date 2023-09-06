package com.aspectorientatedprogramming.demo.aspects;

import com.aspectorientatedprogramming.demo.entities.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(2)
public class mySecondAspectExample {
    @Before("com.aspectorientatedprogramming.demo.aspects.PointcutExpressionsExample.forDaoExcludesGettersAndSetters()")
    public void beforeAddAccount() {
        System.out.println("----------->>>> second Aspect triggered");
    }

    @AfterReturning(pointcut = "execution( * com.aspectorientatedprogramming.demo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterFindingAccount(JoinPoint joinPoint, List<Account> result) {

        System.out.println("==========>>>> AfterReturning Aspect triggered");

        System.out.println("Method: " + joinPoint.getSignature().toShortString());
        System.out.println("Accounts found in Main method: " + result);
        ResultInterceptor.convertAccountsToUpperCase(result);

        System.out.println("Result is: " + result);
    }
}
