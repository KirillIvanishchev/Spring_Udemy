package com.demoapp.springCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class ThirdDemoClass implements  DemoInterface {
    @Override
    public String getMessage() {
        return "This is third demo class!";
    }
}
