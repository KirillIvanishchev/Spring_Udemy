package com.aspectorientatedprogramming.demo.aspects;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class myLoggingAspect {
    //One specific class, no arguments
    //@Before("execution (public void addAccount())")

    //Specific class in package, no arguments
    //@Before("execution (public void com.aspectorientatedprogramming.demo.dao.AccountDAO.addAccount())")

    //Any class that begins with add with no arguments
    //@Before("execution(public void add*())")

    //Any class that begins with add with no arguments with any return type
    //@Before("execution(public * add*())")

    //Any class that begins with add with no arguments with any return type in a specific folder
    //@Before("execution(public * add*(com.aspectorientatedprogramming.demo.dao))")

    //Class in package that begins with add with no arguments with any return type
    //@Before("execution(public * add*(com.aspectorientatedprogramming.demo.entities.Account))")

    //Any method return type and any number of arguments. Class name begins with add.
    //@Before("execution(public * add*(..))")

    @Before("execution( * com.aspectorientatedprogramming.demo.dao.*.*(..))")
    public void beforeAddAccount() {
        System.out.println("beforeAddAccount");
    }
}
