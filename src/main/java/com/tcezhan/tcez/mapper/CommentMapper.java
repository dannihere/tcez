package com.tcezhan.tcez.mapper;


import com.tcezhan.tcez.bean.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from comment where id = #{id}")
    public Comment findCommentById(Integer id);

    @Select("select * from comment")
    public List<Comment> findComment();

    @Delete("delete from comment where id = #{id}")
    public int deleteComment(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into comment(id,avatar,comment_1,comment_2,display,upload_time,update_time) values(#{id},#{avatar},#{comment1},#{comment2},#{display},#{uploadTime},#{updateTime})")
    public int insertComment(Comment comment);

    @Update("update comment set avatar=#{avatar},comment_1=#{comment1},comment_2=#{comment2},display=#{display},upload_time=#{uploadTime},update_time=#{updateTime} where id = #{id}")
    public int updateComment(Comment comment);
}
