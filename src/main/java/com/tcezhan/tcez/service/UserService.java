package com.tcezhan.tcez.service;

import com.tcezhan.tcez.bean.User;

import java.util.List;

public interface UserService {
    public User findUserById(Integer id);

    public List<User> findUser();

    public int deleteUserById(Integer id);

    public int insertUser(User user);

    public int update(User user);
}
