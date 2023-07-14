package com.demoapp.springCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FourthDemoClass implements DemoInterface {
    @Override
    public String getMessage() {
        return "This is fourth demo class!";
    }

}
