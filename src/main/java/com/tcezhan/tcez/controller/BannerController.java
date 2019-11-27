package com.tcezhan.tcez.controller;

import com.tcezhan.tcez.bean.Banner;
import com.tcezhan.tcez.mapper.BannerMapper;
import com.tcezhan.tcez.service.BannerService;
import com.tcezhan.tcez.service.serviceImpl.BannerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController

public class BannerController {

    @Autowired
    BannerService bannerService;

    @PostMapping(value = "/addBanner")
    public String insertBanner(Banner banner,MultipartFile file){

        String filename=file.getOriginalFilename();
        String newfilename = filename.substring(0,filename.lastIndexOf("."));
        String suffix = filename.substring(filename.lastIndexOf("."));
        System.out.println(filename);
        System.out.println(suffix);
        if(suffix.equals(".png")==false && suffix.equals(".jpg")==false){
            return "格式不支持";
        }
        banner.setImg(filename);
        if(bannerService.insertBanner(banner)==0){
            return "插入失败";
        }

        File newfile = new File("D://imgs//"+filename);
        if(!newfile.getParentFile().exists()){
            newfile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "success";
    }

}
