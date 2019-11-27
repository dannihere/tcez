package com.tcezhan.tcez.service;

import com.tcezhan.tcez.bean.Banner;
import com.tcezhan.tcez.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface BannerService {
    public int insertBanner(Banner banner);
}
