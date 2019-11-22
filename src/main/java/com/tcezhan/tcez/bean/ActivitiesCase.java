package com.tcezhan.tcez.bean;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class ActivitiesCase {
    private Integer id;
    private String title;
    private String img;
    private Integer type;
    private Date uploadTime;
    private Date updateTime;
}
