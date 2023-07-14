package com.demoapp.springCoreDemo.rest;

import com.demoapp.springCoreDemo.common.DemoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private DemoClass myClass;
    @Autowired
    public void setDemoClass(DemoClass myClass) {
        this.myClass = myClass;
    }

    @GetMapping("/DDI")
    public String getMessageFromDemoClass() {
        return myClass.getMessage();
    }
}
