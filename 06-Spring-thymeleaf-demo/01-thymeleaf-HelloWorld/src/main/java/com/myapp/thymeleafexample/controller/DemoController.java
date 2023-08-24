package com.myapp.thymeleafexample.controller;

// Just a basic controller for "Hello World" example with thymeleaf.
// This is @Controller, unlike @RestController this annotation is a key for retrieving
// a Model, View or String data types. Uses for MVC APPLICATIONS!

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @RestController is a key for retrieving a JSON/XML data type, for REST APIs.
@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }
}
