package com.tcezhan.tcez.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class Comment {
    private Integer id;
    private String avatar;
    private String comment_1;
    private String comment_2;
    private Integer display;
    private Date uploadTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getComment_1() {
        return comment_1;
    }

    public void setComment_1(String comment_1) {
        this.comment_1 = comment_1;
    }

    public String getComment_2() {
        return comment_2;
    }

    public void setComment_2(String comment_2) {
        this.comment_2 = comment_2;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", comment_1='" + comment_1 + '\'' +
                ", comment_2='" + comment_2 + '\'' +
                ", display=" + display +
                ", uploadTime=" + uploadTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
