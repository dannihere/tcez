package com.tcezhan.tcez.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
public class User {
    private Integer id;
    private String name;
    private String phone;
    private String message;
}
