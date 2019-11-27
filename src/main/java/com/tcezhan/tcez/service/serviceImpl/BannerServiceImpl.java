package com.tcezhan.tcez.service.serviceImpl;

import com.tcezhan.tcez.bean.Banner;
import com.tcezhan.tcez.mapper.BannerMapper;
import com.tcezhan.tcez.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public int insertBanner(Banner banner) {
        return bannerMapper.insertBanner(banner);
    }
}
