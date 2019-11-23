package com.tcezhan.tcez.controller;


import com.tcezhan.tcez.bean.User;
import com.tcezhan.tcez.mapper.UserMapper;
import com.tcezhan.tcez.service.UserService;
import com.tcezhan.tcez.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }














}
