package com.tcezhan.tcez.service.serviceImpl;

import com.tcezhan.tcez.bean.Comment;
import com.tcezhan.tcez.mapper.CommentMapper;
import com.tcezhan.tcez.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Comment findCommentById(Integer id) {
        return commentMapper.findCommentById(id);
    }

    @Override
    public List<Comment> findComment() {
        return commentMapper.findComment();
    }

    @Override
    public int deleteComment(Integer id) {
        return commentMapper.deleteComment(id);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }
}
