package com.javatechie.controller;

import com.javatechie.client.UserClient;
import com.javatechie.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class UserClientController {

    @Autowired
    private RestTemplate template;

    @Autowired
    private UserClient userClient;

    @Autowired
    private WebClient webClient;

    @GetMapping("/fetchMockUsers1")
    public List<UserResponse> fetchMockUsersWithRestTemplate() {
        return template.getForObject("https://jsonplaceholder.typicode.com/users", List.class);
    }


    @GetMapping("/fetchMockUsers2")
    public List<UserResponse> fetchMockUsersWithFeignClient() {
        return userClient.getUsers();
    }

    @GetMapping("/fetchMockUsers3")
    public List<UserResponse> fetchMockUsersWithWebclient() {
        Flux<UserResponse> response = webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(UserResponse.class);
        // Block and get the result (synchronous call - for demonstration purposes only)
        return response.collectList().block();
    }
}
