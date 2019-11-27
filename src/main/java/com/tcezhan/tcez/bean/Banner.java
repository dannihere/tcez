package com.tcezhan.tcez.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Banner {
    private Integer id;
    private String title;
    private String description;
    private String img;
    private Integer display;
}
