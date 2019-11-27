package com.tcezhan.tcez.bean;


import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.Date;

@Data
@Component
public class Article {
    private Integer id;
    private String title;
    private String description;
    private String img;
    private Integer type;
    private String text;
    private Integer display;
    private Date uploadTime;
    private Date updateTime;
}
