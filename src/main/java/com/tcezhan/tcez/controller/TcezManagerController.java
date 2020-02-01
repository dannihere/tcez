package com.tcezhan.tcez.controller;


import Constant.CookieConstant;
import Constant.RedisConstant;
import com.tcezhan.tcez.bean.Manager;
import com.tcezhan.tcez.enums.ResultEnum;
import com.tcezhan.tcez.service.serviceImpl.ManagerServiceImpl;
import com.tcezhan.tcez.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class TcezManagerController {

    @Autowired
    ManagerServiceImpl managerService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 登录校验
     * @param username
     * @param password
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response,
                        Map<String,Object> map){
        Manager manager = managerService.findManagerByName(username);
        if (manager == null){
            map.put("msg", ResultEnum.USER_NOT_EXIT.getMessage());
            return "/login";
        }

        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), String.valueOf(manager.getId()), expire, TimeUnit.SECONDS);

        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        return "/main";
    }


    @GetMapping("logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response,
                         Map<String,Object> map){
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if (cookie != null){
            //清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getName()));

            //清除cookie直接将过期时间设置为0
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGINOUT_SUCCESS.getMessage());

        return "/login";

    }







}
