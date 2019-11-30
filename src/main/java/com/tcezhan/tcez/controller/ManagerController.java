package com.tcezhan.tcez.controller;

import com.tcezhan.tcez.bean.Manager;
import com.tcezhan.tcez.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @PostMapping("/login")
    public String findManagerByName(String userName,String password){
        Manager manager=managerService.findManagerByName(userName);
        if (manager==null){
            return "账号不存在";
        }
        if (manager.getPassword()!=password){
            return "密码或账号错误";
        }

        //TODO
        //会话用户信息
        return "/main";
    }

    @GetMapping("/managers")
    public List<Manager> findManager(){
        return managerService.findManager();
    }

    @GetMapping("/manager/{id}")
    public Manager findManagerById(@PathVariable("id") Integer id){
        return managerService.findManagerById(id);
    }

    @PostMapping("/manager")
    public Integer insertManager(Manager manager){
        Integer result=managerService.insertManager(manager);
        return result;
    }

    @PutMapping("/manager")
    public Integer updateManager(Manager manager){
        Integer result = managerService.updateManager(manager);
        return result;
    }

    @DeleteMapping("/manager/{id}")
    public Integer deleteManager(@PathVariable("id") Integer id){
        Integer result = managerService.deleteManager(id);
        return result;
    }

}
