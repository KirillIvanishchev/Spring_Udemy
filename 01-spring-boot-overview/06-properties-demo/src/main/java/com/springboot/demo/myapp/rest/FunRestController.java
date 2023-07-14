package com.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${owner.name}")
    private String owner;
    @Value("${team.name}")
    private String team;
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Owner: " + owner + " Team: " + team;
    }
    @GetMapping("/")
    public String sayHallo() {
        return "Hello World!";
    }
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, everything is up and running!";
    }
}
