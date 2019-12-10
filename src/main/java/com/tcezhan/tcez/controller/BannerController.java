package com.tcezhan.tcez.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tcezhan.tcez.VO.ResultVO;
import com.tcezhan.tcez.bean.Banner;
import com.tcezhan.tcez.service.BannerService;
import com.tcezhan.tcez.service.serviceImpl.BannerServiceImpl;
import com.tcezhan.tcez.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController

public class BannerController {

    @Autowired
    BannerService bannerService;

//    查询所有banner
    @GetMapping("/banners")
    public ResultVO<List<Banner>> findBanner(){
        return ResultVOUtil.success(bannerService.findBanner());
    }

//    根据id查询banner
    @GetMapping("/banner/{id}")
    public ResultVO<Banner> findBannerById(@PathVariable("id") Integer id){
        return ResultVOUtil.success(bannerService.findBannerById(id));
    }

//    查询需要显示的banner
    @GetMapping("/banner/on")
    public ResultVO<List<Banner>> findOnBanner(){
        return ResultVOUtil.success(bannerService.findOnBanner());
    }

//    添加banner、上传文件
    @PostMapping(value = "/banner")
    public ResultVO insertBanner(Banner banner,MultipartFile file){

        String filename=file.getOriginalFilename();
        //String newfilename = filename.substring(0,filename.lastIndexOf("."));
        String suffix = filename.substring(filename.lastIndexOf("."));
        System.out.println(filename);
        System.out.println(suffix);
        if(!suffix.equals(".png") && !suffix.equals(".jpg")){
            return ResultVOUtil.error(1001,"格式不支持");
        }
        banner.setImg(filename);
        if(bannerService.insertBanner(banner)==0){
            return ResultVOUtil.error(1002,"插入失败");
        }

        File newfile = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\imgs\\"+filename);
        if(!newfile.getParentFile().exists()){
            newfile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultVOUtil.success();
    }

    /*删除banner*/
    @DeleteMapping(value = "/banner/{id}")
    public ResultVO deleteBanner(@PathVariable("id")Integer id){
        bannerService.deleteBanner(id);
        return ResultVOUtil.success();
    }

    /*更新 原文件未删除*/
    @PutMapping(value = "/banner")
    public ResultVO updateBanner(Banner banner,MultipartFile file){
        String filename=file.getOriginalFilename();
        //String newfilename = filename.substring(0,filename.lastIndexOf("."));
        String suffix = filename.substring(filename.lastIndexOf("."));
        System.out.println(filename);
        System.out.println(suffix);
        if(!suffix.equals(".png") && !suffix.equals(".jpg")){
            return ResultVOUtil.error(401,"格式错误");
        }
        banner.setImg(filename);
        if(bannerService.updateBanner(banner)==0){
            return ResultVOUtil.error(402,"更新失败");
        }

        File newfile = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\imgs\\"+filename);
        if(!newfile.getParentFile().exists()){
            newfile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResultVOUtil.success();
    }




}
