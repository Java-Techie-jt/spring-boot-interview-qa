package com.javatechie.controller;

import com.javatechie.common.User;
import com.javatechie.dto.Book;
import com.javatechie.dto.UserDetails;
import com.javatechie.repository.UserDetailsRepository;
import com.javatechie.scope.RequestScopedBean;
import com.javatechie.scope.SessionScopedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

//    @Autowired
//    private RequestScopedBean requestScopedBean;
    @Autowired
    private SessionScopedBean sessionScopedBean;

    @Autowired
    private UserDetailsRepository repository;


    @GetMapping("/message")
    public String getMessage() {
        return sessionScopedBean.getMessage();
    }
    @GetMapping("/users/name")
    public String checkBodyInGET(@RequestBody UserDetails userDetails) {
        return userDetails.getName();
    }

    @PostMapping("/book")
    public String doSomeProcess(@RequestBody Book book){
        return book.getTitle()+" New book has been published on year "+book.getPublicationYear();
    }

    @PostMapping("/users")
    public UserDetails addNewUser(@RequestBody UserDetails userDetails){
        return repository.save(userDetails);
    }

    @PutMapping("/users/{id}")
    public UserDetails addAndUpdateUser(@PathVariable int id,@RequestBody UserDetails userDetails){
        UserDetails existingUserDetails = repository.findById(id).get();
        existingUserDetails.setName(userDetails.getName());
        existingUserDetails.setAge(userDetails.getAge());
        return repository.save(existingUserDetails);
    }

}
