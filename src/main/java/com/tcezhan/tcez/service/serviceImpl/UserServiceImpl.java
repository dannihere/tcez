package com.tcezhan.tcez.service.serviceImpl;

import com.tcezhan.tcez.bean.User;
import com.tcezhan.tcez.mapper.UserMapper;
import com.tcezhan.tcez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<User> findUser() {
        return userMapper.findUser();
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }
}
