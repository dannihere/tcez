package com.tcezhan.tcez.controller;


import com.tcezhan.tcez.bean.User;
import com.tcezhan.tcez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> findUser(){
        return userService.findUser();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @PostMapping("/user")
    public Integer insertUser(User user){
//        if (bindingResult.hasErrors()){
//            return bindingResult.getFieldError().getDefaultMessage();
//        }
         Integer result = userService.insertUser(user);
        return result;
    }

    @PutMapping("/user")
    public Integer update(User user){
        Integer result = userService.update(user);
        return result;
    }

    @DeleteMapping("/user/{id}")
    public Integer deleteUserById(Integer id){
        Integer result = userService.deleteUserById(id);
        return result;
    }
}
