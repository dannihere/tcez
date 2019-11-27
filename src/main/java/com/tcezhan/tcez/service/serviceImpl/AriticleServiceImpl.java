package com.tcezhan.tcez.service.serviceImpl;

import com.tcezhan.tcez.bean.Article;
import com.tcezhan.tcez.mapper.AriticleMapper;
import com.tcezhan.tcez.service.AriticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AriticleServiceImpl implements AriticleService {
    @Autowired
    AriticleMapper ariticleMapper;

    @Override
    public Article findArticleById(Integer id) {
        return ariticleMapper.findArticleById(id);
    }

    @Override
    public List<Article> findArticle() {
        return ariticleMapper.findArticle();
    }

    @Override
    public List<Article> findArticleByType(Integer type) {
        return ariticleMapper.findArticleByType(type);
    }

//    @Override
//    public List<Article> findActivitiesCase() {
//        return ariticleMapper.findActivitiesCase();
//    }
//
//    @Override
//    public List<Article> findAdvertorial() {
//        return null;
//    }
//
//    @Override
//    public List<Article> findStyle() {
//        return null;
//    }

    @Override
    public int deleteArticle(Integer id) {
        return ariticleMapper.deleteArticle(id);
    }

    @Override
    public int insertArticle(Article article) {
        return ariticleMapper.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return ariticleMapper.updateArticle(article);
    }
}
