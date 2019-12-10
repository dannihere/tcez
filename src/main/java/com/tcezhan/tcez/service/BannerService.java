package com.tcezhan.tcez.service;

import com.tcezhan.tcez.bean.Banner;
import com.tcezhan.tcez.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import java.util.List;

public interface BannerService {
    public int insertBanner(Banner banner);
    public List<Banner> findOnBanner();
    public List<Banner> findBanner();
    public Banner findBannerById(Integer id);
    public Integer deleteBanner(Integer id);
    public int updateBanner(Banner banner);

}
