package com.tcezhan.tcez.service.serviceImpl;

import com.tcezhan.tcez.bean.Banner;
import com.tcezhan.tcez.mapper.BannerMapper;
import com.tcezhan.tcez.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public Banner findBannerById(Integer id) {
        return bannerMapper.findBannerById(id);
    }

    @Override
    public List<Banner> findBanner() {
        return bannerMapper.findBanner();
    }

    @Override
    public int deleteBanner(Integer id) {
        return bannerMapper.deleteBanner(id);
    }

    @Override
    public int insertBanner(Banner banner) {
        return bannerMapper.insertBanner(banner);
    }

    @Override
    public int updateBanner(Banner banner) {
        return bannerMapper.updateBanner(banner);
    }
}
