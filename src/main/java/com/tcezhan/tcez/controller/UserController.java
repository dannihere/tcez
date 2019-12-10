package com.tcezhan.tcez.controller;


import com.tcezhan.tcez.VO.ResultVO;
import com.tcezhan.tcez.bean.User;
import com.tcezhan.tcez.service.UserService;
import com.tcezhan.tcez.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResultVO<List<User>> findUser(){
        return ResultVOUtil.success(userService.findUser());
    }

    @GetMapping("/user/{id}")
    public ResultVO<User> getUserById(@PathVariable("id") Integer id){
        return ResultVOUtil.success(userService.findUserById(id));
    }

    @PostMapping("/user")
    public ResultVO<Integer> insertUser(User user){
//        if (bindingResult.hasErrors()){
//            return bindingResult.getFieldError().getDefaultMessage();
//        }
        //TODO
        //防止重复添加

        Integer result = userService.insertUser(user);
        Map<String,Integer> map = new HashMap<>();
        map.put("id",user.getId());
        return ResultVOUtil.success(map);
    }

    @PutMapping("/user")
    public ResultVO update(User user){
        Integer result = userService.update(user);
        return ResultVOUtil.success();
    }

    @DeleteMapping("/user/{id}")
    public ResultVO deleteUserById(Integer id){
        Integer result = userService.deleteUserById(id);
        return ResultVOUtil.success();
    }
}
