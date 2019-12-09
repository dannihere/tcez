package com.tcezhan.tcez.service.serviceImpl;

import com.tcezhan.tcez.bean.Manager;
import com.tcezhan.tcez.mapper.ManagerMapper;
import com.tcezhan.tcez.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Manager findManagerById(Integer id) {
        return managerMapper.findManagerById(id);
    }

    @Override
    public Manager findManagerByName(String userName) {
        return managerMapper.findManagerByName(userName);
    }

    @Override
    public List<Manager> findManager() {
        return managerMapper.findManager();
    }

    @Override
    public int deleteManager(Integer id) {
        return managerMapper.deleteManager(id);
    }

    @Override
    public int insertManager(Manager manager) {
        //用户名存在，返回错误
        if (managerMapper.findManagerByName(manager.getName())!=null){
            return -1;
        }
        //通过BCryptPasswordEncoder中的encode方法对密码进行处理。
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        manager.setPassword(encoder.encode(manager.getPassword()));
        return managerMapper.insertManager(manager);
    }

    @Override
    public int updateManager(Manager manager) {
        return managerMapper.updateManager(manager);
    }
}
