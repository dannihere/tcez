package com.tcezhan.tcez;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.tcezhan.tcez.mapper")
@SpringBootApplication
public class TcezApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcezApplication.class, args);
    }

}
