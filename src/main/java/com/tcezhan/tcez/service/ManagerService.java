package com.tcezhan.tcez.service;

import com.tcezhan.tcez.bean.Manager;

import java.util.List;

public interface ManagerService {
    public Manager findManagerById(Integer id);

    public Manager findManagerByName(String userName);

    public List<Manager> findManager();

    public int deleteManager(Integer id);

    public int insertManager(Manager manager);

    public int updateManager(Manager manager);
}
