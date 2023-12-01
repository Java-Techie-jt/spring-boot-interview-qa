package com.javatechie.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerDemo {

    @GetMapping("/controller/welcome")
    //modelAndView
    public String welcome(){
        return "hello";
    }

    @GetMapping(value = "/greetingMessage",produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String message(){
        return "Welcome to javatechie";
    }
}
