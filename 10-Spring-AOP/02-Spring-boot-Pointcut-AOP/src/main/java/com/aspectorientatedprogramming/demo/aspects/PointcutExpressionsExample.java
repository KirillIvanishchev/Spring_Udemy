package com.aspectorientatedprogramming.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressionsExample {
    //Pointcut expressions allows to use same annotation for different methods/actions.
    @Pointcut("execution( * com.aspectorientatedprogramming.demo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution( * com.aspectorientatedprogramming.demo.dao.*.get*(..))")
    public void forDaoGetters() {}

    @Pointcut("execution( * com.aspectorientatedprogramming.demo.dao.*.set*(..))")
    public void forDaoSetters() {}

    @Pointcut("forDaoPackage() && !(forDaoGetters() || forDaoSetters())")
    public void forDaoExcludesGettersAndSetters() {}
}
