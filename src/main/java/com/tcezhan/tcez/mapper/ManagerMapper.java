package com.tcezhan.tcez.mapper;

import com.tcezhan.tcez.bean.Manager;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ManagerMapper {

    @Select("select * from manager where id = #{id}")
    public Manager findManagerById(Integer id);

    @Select("select * from manager where user_name=#{userName}")
    public Manager findManagerByName(String userName);

    @Select("select * from manager")
    public List<Manager> findManager();

    @Delete("delete from manager where id = #{id}")
    public int deleteManager(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into manager(id,user_name,password,name,role) values(#{id},#{userName},#{password},#{name},#{role})")
    public int insertManager(Manager manager);

    @Update("update manager set user_name=#{userName},password=#{password},name=#{name},role=#{role} where id = #{id}")
    public int updateManager(Manager manager);
}
