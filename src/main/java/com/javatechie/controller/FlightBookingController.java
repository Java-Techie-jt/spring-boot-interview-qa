package com.javatechie.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightBookingController {


    @PostMapping("/v1/bookNow")
    public ResponseEntity<String> bookingTicket(@RequestBody Object request) {
        //execute actual logic
        return ResponseEntity.ok("Flight booking successfully completed !");
    }

    @PostMapping("/v2/bookNow")
    @Hidden
    public ResponseEntity<String> bookingTicket2(@RequestBody Object request) {
        //latestLogic
        return ResponseEntity.ok("New Flight booking approach successfully completed !");
    }


    @PostMapping("/bookingNow")
    public ResponseEntity<String> bookTicketVersionWithRequestParam(@RequestBody Object request, @RequestParam(name = "version") int version) {
        //execute actual logic
        if (version == 1) {
            return ResponseEntity.ok("This is version 1 of the resource");
        } else {
            return ResponseEntity.ok("This is version 2 of the resource");
        }
    }

    @PostMapping("/bookingNow2")
    public ResponseEntity<String> bookTicketVersionWithHeaderParam(@RequestBody Object request, @RequestHeader(name = "Api-Version") int version) {
        //execute actual logic
        if (version == 1) {
            return ResponseEntity.ok("This is version 1 of the resource");//old
        } else {
            return ResponseEntity.ok("This is version 2 of the resource");//new
        }
    }
}
