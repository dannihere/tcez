package com.tcezhan.tcez.service;

import com.tcezhan.tcez.bean.Comment;

import java.util.List;

public interface CommentService {
    public Comment findCommentById(Integer id);

    public List<Comment> findComment();

    public int deleteComment(Integer id);

    public int insertComment(Comment comment);

    public int updateComment(Comment comment);
}
