package com.example.demo.controller;


import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserEntity> login(@RequestBody Map<String, String> request) {

        String email = request.get("email");
        String password = request.get("password");

        UserEntity user = userService.validateUser(email, password);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser(){
        List<UserEntity> userEntities = userService.findAllUser();
        if (userEntities != null) {
            return new ResponseEntity<>(userEntities, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @PostMapping
    public ResponseEntity<Long> registerUser(@RequestBody UserEntity user){
        UserEntity userEntity = userService.save(user);
        if(user == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return  ResponseEntity.ok(userEntity.getId());
    }





}


