package com.demoapp.springCoreDemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// By default, only ALL created objects will have ONE reference, so ONE Object will be created.
// So @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) will be initialized without ANY Scope annotations.
// To create multiple objects, use @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation.
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DemoClass implements DemoInterface {
    public DemoClass() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getMessage() {
        return "This is demo interface in demo class!";
    }
}
