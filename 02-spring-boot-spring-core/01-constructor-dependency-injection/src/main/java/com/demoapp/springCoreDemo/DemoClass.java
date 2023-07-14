package com.demoapp.springCoreDemo;

import org.springframework.stereotype.Component;

@Component
public class DemoClass implements DemoInterface {
    @Override
    public String getMessage() {
        return "This is demo interface in demo class!";
    }
}
