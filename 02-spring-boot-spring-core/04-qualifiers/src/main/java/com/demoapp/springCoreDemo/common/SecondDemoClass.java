package com.demoapp.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class SecondDemoClass implements DemoInterface{
    @Override
    public String getMessage() {
        return "This is second demo class!";
    }
}
