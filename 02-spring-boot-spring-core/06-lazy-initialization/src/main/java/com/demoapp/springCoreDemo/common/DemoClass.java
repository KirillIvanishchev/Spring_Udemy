package com.demoapp.springCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// Class can be initialized with @Lazy, object will be created ONLY when required with reference.
@Lazy
public class DemoClass implements DemoInterface {
    public DemoClass() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getMessage() {
        return "This is demo interface in demo class!";
    }
}
