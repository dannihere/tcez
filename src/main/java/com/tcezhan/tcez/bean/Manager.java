package com.tcezhan.tcez.bean;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Manager {
    private Integer id;
    private String userName;
    private String password;
    private String name;
    private String role;
}
