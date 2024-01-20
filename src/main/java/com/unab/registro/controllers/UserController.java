package com.unab.registro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unab.registro.repository.UserRepository;

@Controller
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity<String>("pong",HttpStatus.OK);
    }
    
}
