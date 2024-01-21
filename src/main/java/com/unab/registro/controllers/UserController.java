package com.unab.registro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.unab.registro.entitys.User;
import com.unab.registro.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<String>("pong", HttpStatus.OK);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void createUser(@Valid @RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/email")
    public ResponseEntity<User> fetchByEmail(@RequestParam String email) {
        return new ResponseEntity<User>(this.userService.fetchByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> fetchAll() {
        return new ResponseEntity<List<User>>(this.userService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateEmail(@PathVariable String id, @Valid @RequestBody User user) {
        return new ResponseEntity<User>(this.userService.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String id) {
        this.userService.deleteUser(id);
    }

}
