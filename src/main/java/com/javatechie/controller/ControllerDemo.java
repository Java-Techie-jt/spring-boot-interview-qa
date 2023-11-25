package com.javatechie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerDemo {

    @GetMapping("/controller/welcome")
    public String welcome(){
        return "hello";
    }
}
