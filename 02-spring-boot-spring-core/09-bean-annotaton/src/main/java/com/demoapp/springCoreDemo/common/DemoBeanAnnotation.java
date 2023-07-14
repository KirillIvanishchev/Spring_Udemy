package com.demoapp.springCoreDemo.common;

public class DemoBeanAnnotation implements DemoInterface {
    public DemoBeanAnnotation() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getMessage() {
        return "This is demo Bean Annotation class impl. Demo Interface!";
    }
}
