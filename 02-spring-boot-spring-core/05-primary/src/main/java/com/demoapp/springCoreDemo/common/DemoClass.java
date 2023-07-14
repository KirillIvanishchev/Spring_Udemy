package com.demoapp.springCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DemoClass implements DemoInterface {
    @Override
    public String getMessage() {
        return "This is demo interface in demo class!";
    }
}
