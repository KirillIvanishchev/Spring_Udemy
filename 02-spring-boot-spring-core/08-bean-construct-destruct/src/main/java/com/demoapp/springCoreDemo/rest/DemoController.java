package com.demoapp.springCoreDemo.rest;

import com.demoapp.springCoreDemo.common.DemoClass;
import com.demoapp.springCoreDemo.common.DemoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private DemoInterface myInterface;
    @Autowired
    public DemoController (
            @Qualifier("demoClass") DemoInterface myInterface) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myInterface = myInterface;
    }

    @GetMapping("/demo")
    public String getMessageFromDemoClass() {
        return myInterface.getMessage();
    }
}
