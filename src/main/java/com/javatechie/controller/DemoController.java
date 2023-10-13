package com.javatechie.controller;

import com.javatechie.scope.RequestScopedBean;
import com.javatechie.scope.SessionScopedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//    @Autowired
//    private RequestScopedBean requestScopedBean;
    @Autowired
    private SessionScopedBean sessionScopedBean;


    @GetMapping("/message")
    public String getMessage() {
        return sessionScopedBean.getMessage();
    }

}
