package com.javatechie.controller;

import com.javatechie.dto.Book;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControllerDemo {

    @GetMapping("/restController/welcome")
    public String welcome(){
        return "hello";
    }

    @PostMapping("/books")
    public String processBook(@RequestBody Book book){
       return book.getTitle()+" New book has been published on year "+book.getPublicationYear();
    }
}
