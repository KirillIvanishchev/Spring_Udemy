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
    private DemoInterface anotherInterface;
    @Autowired
    public DemoController (
            @Qualifier("demoClass") DemoInterface myInterface,
            @Qualifier("demoClass") DemoInterface anotherInterface) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myInterface = myInterface;
        this.anotherInterface = anotherInterface;
    }

    @GetMapping("/DDI")
    public String getMessageFromDemoClass() {
        return myInterface.getMessage();
    }

    @GetMapping("/check")
    public String getCheckedBeanScopes() {
        return "Comparing Beans myInterface == anotherInterface: " + (myInterface == anotherInterface);
    }
}
