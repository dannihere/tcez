package com.tcezhan.tcez.controller;


import com.tcezhan.tcez.bean.Comment;
import com.tcezhan.tcez.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    /*查询所有*/
    @GetMapping(value = "comments")
    public List<Comment> findComment(){
        return commentService.findComment();
    }

    /*查询某个*/
    @GetMapping("/comment/{id}")
    public Comment findCommentById(@PathVariable("id") Integer id){
        return commentService.findCommentById(id);
    }

    /*@删除comment*/
    @DeleteMapping("/comment/{id}")
    public Integer deleteComment(@PathVariable("id")Integer id){
        return commentService.deleteComment(id);
    }

    /*添加comment*/
    @PostMapping("/comment")
    public Integer insertComment(Comment comment, MultipartFile file){
        //System.out.println("aaaaaaaaaaaaaaaa");
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        if(!suffix.equals(".png") && !suffix.equals(".jpg")){
            return 401;
        }
        comment.setAvatar(filename);
        comment.setUploadTime(new Date());
        comment.setUpdateTime(new Date());
        String path = System.getProperty("user.dir");
        //System.out.println(path);
        File newfile = new File(path+"\\src\\main\\resources\\avatar\\"+filename);
        if(!newfile.getParentFile().exists()){
            newfile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commentService.insertComment(comment);
    }

    /*修改comment*/
    @PutMapping("/comment")
    public Integer updateComment(Comment comment,MultipartFile file){
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        if(!suffix.equals(".png") && !suffix.equals(".jpg")){
            return 401;
        }
        comment.setAvatar(filename);
        comment.setUpdateTime(new Date());
        comment.setUploadTime(commentService.findCommentById(comment.getId()).getUploadTime());
        File newfile = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\avatar\\"+filename);
        if(!newfile.getParentFile().exists()){
            newfile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commentService.updateComment(comment);
    }

    @GetMapping("/aa")
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        String a="adasdsadas";
        String b="adasdsadas";
        System.out.println(a==b);
    }

}
