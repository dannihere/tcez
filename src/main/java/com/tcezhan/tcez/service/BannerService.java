package com.tcezhan.tcez.service;

import com.tcezhan.tcez.bean.Banner;

import java.util.List;

public interface BannerService {
    public Banner findBannerById(Integer id);

    public List<Banner> findBanner();

    public int deleteBanner(Integer id);

    public int insertBanner(Banner banner);

    public int updateBanner(Banner banner);
}
