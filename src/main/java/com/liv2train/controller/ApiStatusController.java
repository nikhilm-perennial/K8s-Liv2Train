package com.liv2train.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiStatusController {

    @GetMapping("/api/status")
    public ResponseEntity<String> getStatus(){
        return new ResponseEntity<>("OK, Api is Accessible...!!!",HttpStatus.OK);
    }
}
