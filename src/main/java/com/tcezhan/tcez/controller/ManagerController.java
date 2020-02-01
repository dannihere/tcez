package com.tcezhan.tcez.controller;

import com.tcezhan.tcez.VO.ResultVO;
import com.tcezhan.tcez.bean.Manager;
import com.tcezhan.tcez.service.ManagerService;
import com.tcezhan.tcez.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    ManagerService managerService;
//
//    @PostMapping("/login")
//    public String findManagerByName(String userName,String password){
//        Manager manager=managerService.findManagerByName(userName);
//        if (manager==null){
//            return "账号不存在";
//        }
//        if (manager.getPassword()!=password){
//            return "密码或账号错误";
//        }
//
//        //TODO
//        //会话用户信息
//        return "/main";
//    }

    @GetMapping("/managers")
    public ResultVO<List<Manager>>  findManager(){
        return ResultVOUtil.success(managerService.findManager());
    }

    @GetMapping("/manager/{id}")
    public ResultVO<Manager> findManagerById(@PathVariable("id") Integer id){
        return ResultVOUtil.success(managerService.findManagerById(id));
    }

    @PostMapping("/manager")
    public ResultVO insertManager(@RequestBody Manager manager){
        System.out.printf(manager.toString());
        Integer result=managerService.insertManager(manager);
        return ResultVOUtil.success();
    }

    @PutMapping("/manager")
    public ResultVO updateManager(Manager manager){
        Integer result = managerService.updateManager(manager);
        return ResultVOUtil.success();
    }

    @DeleteMapping("/manager/{id}")
    public ResultVO deleteManager(@PathVariable("id") Integer id){
        Integer result = managerService.deleteManager(id);
        return ResultVOUtil.success();
    }

}
