package com.tcezhan.tcez;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(value = "com.tcezhan.tcez.mapper")
@SpringBootApplication
public class TcezApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcezApplication.class, args);
    }

}
