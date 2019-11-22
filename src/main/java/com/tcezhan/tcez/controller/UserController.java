package com.tcezhan.tcez.controller;


import com.tcezhan.tcez.bean.User;
import com.tcezhan.tcez.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userMapper.getUserById(id);
    }














}
