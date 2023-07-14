package com.demoapp.springCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// By default, only ALL created objects will have ONE reference, so ONE Object will be created.
// So @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) will be initialized without ANY Scope annotations.
// To create multiple objects, use @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation.
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DemoClass implements DemoInterface {
    //Construct annotation. Before initialization, method after annotation will be called.
    @PostConstruct
    public void init() {
        System.out.println("In init: " + getClass().getSimpleName());
    }
    //Destroy annotation. Before destruction, method after annotation will be called.
    @PreDestroy
    public void destroy() {
        System.out.println("In destroy: " + getClass().getSimpleName());
    }
    public DemoClass() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getMessage() {
        return "This is demo interface in demo class!";
    }
}
