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
}
