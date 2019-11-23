package com.tcezhan.tcez.mapper;

import com.tcezhan.tcez.bean.Banner;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BannerMapper {

    @Select("select * from banner where id = #{id}")
    public Banner findBannerById(Integer id);

    @Select("select * from banner")
    public List<Banner> findBanner();

    @Delete("delete from banner where id = #{id}")
    public int deleteBanner(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into banner(id,title,description,img,display) values(#{id},#{title},#{description},#{img},#{display})")
    public int insertBanner(Banner banner);

    @Update("update banner set title=#{title},description=#{description},img=#{img},display=#{display} where id = #{id}")
    public int updateBanner(Banner banner);
    
}
