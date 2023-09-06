package com.aspectorientatedprogramming.demo.service;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getService() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Service called";
    }

    @Override
    public String getService(boolean tripWire) {
        if (tripWire) {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            throw new RuntimeException("Excepton thrown: " + methodName);
        }
        return "Service called";
    }
}
