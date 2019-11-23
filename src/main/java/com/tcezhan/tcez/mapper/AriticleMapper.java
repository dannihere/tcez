package com.tcezhan.tcez.mapper;

import com.tcezhan.tcez.bean.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AriticleMapper {

    @Select("select * from article where id = #{id}")
    public Article findArticleById(Integer id);

    @Select("select * from article")
    public List<Article> findArticle();

    //查找活动案例
    @Select("select * from article where type = 1")
    public List<Article> findActivitiesCase();

    //查找同窗软文
    @Select("select * from article where type = 2")
    public List<Article> findAdvertorial();

    //查找同窗风采
    @Select("select * from article where type = 3")
    public List<Article> findStyle();

    @Delete("delete from article where id = #{id}")
    public int deleteArticle(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into article(id,title,description,img,type,text,upload_time,update_time) values(#{id},#{title},#{description},#{img},#{type},#{text},#{uploadTime},#{updateTime})")
    public int insertArticle(Article article);

    @Update("update article set title=#{title},description=#{description},img=#{img},type=#{type},text=#{text},upload_time=#{uploadTime},update_time=#{updateTime} where id = #{id}")
    public int updateArticle(Article article);
}
