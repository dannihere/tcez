package com.tcezhan.tcez.mapper;


import com.tcezhan.tcez.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    public User findUserById(Integer id);

    @Select("select * from user")
    public List<User> findUser();

    @Delete("delete from user where id=#{id}")
    public int deleteUserById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(name,phone,message) values(#{name},#{phone},#{message})")
    public int insertUser(User user);

    @Update("update user set name=#{name},phone=#{phone},message=#{message} where id=#{id}")
    public int update(User user);

}
