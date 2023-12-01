package com.javatechie.client;

import com.javatechie.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//https://jsonplaceholder.typicode.com/users
@FeignClient(url="https://jsonplaceholder.typicode.com",name = "USER-CLIENT")
public interface UserClient {

    @GetMapping("/users")
    public List<UserResponse> getUsers();
}
