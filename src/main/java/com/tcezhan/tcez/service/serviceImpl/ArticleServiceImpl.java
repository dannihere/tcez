package com.tcezhan.tcez.service.serviceImpl;

import com.tcezhan.tcez.bean.Article;
import com.tcezhan.tcez.mapper.ArticleMapper;
import com.tcezhan.tcez.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Article findArticleById(Integer id) {
        return articleMapper.findArticleById(id);
    }

    @Override
    public List<Article> findArticle() {
        return articleMapper.findArticle();
    }

    @Override
    public List<Article> findArticleByType(Integer type) {
        return articleMapper.findArticleByType(type);
    }

//    @Override
//    public List<Article> findActivitiesCase() {
//        return articleMapper.findActivitiesCase();
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
        return articleMapper.deleteArticle(id);
    }

    @Override
    public int insertArticle(Article article) {
        return articleMapper.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }
}
