package com.tcezhan.tcez.service;

import com.tcezhan.tcez.bean.Article;

import java.util.List;

public interface ArticleService {
    public Article findArticleById(Integer id);

    public List<Article> findArticle();

//    //查找活动案例
//    public List<Article> findActivitiesCase();
//
//    //查找同窗软文
//    public List<Article> findAdvertorial();
//
//    //查找同窗风采
//    public List<Article> findStyle();

    public List<Article> findArticleByType(Integer type);

    public int deleteArticle(Integer id);

    public int insertArticle(Article article);

    public int updateArticle(Article article);
}
