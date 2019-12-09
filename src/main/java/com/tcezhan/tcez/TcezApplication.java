package com.tcezhan.tcez;

import com.tcezhan.tcez.interceptor.CorsInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@MapperScan(value = "com.tcezhan.tcez.mapper")
@SpringBootApplication
public class TcezApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(TcezApplication.class, args);
    }

//允许接收浏览器跨域请求
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new CorsInterceptor()).addPathPatterns("/**");
    }
}
