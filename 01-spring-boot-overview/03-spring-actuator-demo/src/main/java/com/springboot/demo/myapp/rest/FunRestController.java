package com.springboot.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHallo() {
        return "Hello World!";
    }
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, everything is up and running!";
    }
}
