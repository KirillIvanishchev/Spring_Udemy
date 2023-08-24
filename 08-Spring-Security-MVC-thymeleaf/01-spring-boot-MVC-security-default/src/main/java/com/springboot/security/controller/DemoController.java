package com.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String returnHome(){
        return "home";
    }

    //RequestMapping for Developers
    @GetMapping("/developers")
    public String showDevelopers(){
        return "developers";
    }

    @GetMapping("/admins")
    public String showAdmins(){
        return "admins";
    }
}
