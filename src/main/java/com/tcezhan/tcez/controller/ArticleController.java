package com.tcezhan.tcez.controller;

import com.tcezhan.tcez.bean.Article;
import com.tcezhan.tcez.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/article/{id}")
    public Article findArticleById(@PathVariable("id") Integer id) {
        Article article = articleService.findArticleById(id);
        //将富文本解析
        article.setText(HtmlUtils.htmlUnescape(article.getText()));
        return article;
    }


    //TODO
    //返回不带富文本的json对象
    @GetMapping("/articles")
    public List<Article> findArticle() {

        return articleService.findArticle();

    }

    //TODO
    //返回不带富文本的各个json对象
    @GetMapping("/article/{type}")
    public List<Article> findArticleByType(@PathVariable("type") Integer type) {

        //TODO
        //健壮性完善
        //if (type!=1)

        return articleService.findArticleByType(type);
    }

    //TODO
    @DeleteMapping("/article/{id}")
    public int deleteArticle(@PathVariable("id") Integer id) {
        if (articleService.findArticleById(id).equals(null)){
            //不存在返回
        }
        return articleService.deleteArticle(id);
    }


    @PostMapping("/article")
    public int insertArticle(Article article) {
        //解析富文本
        article.setText(HtmlUtils.htmlEscapeHex(article.getText()));

        return articleService.insertArticle(article);
    }

    @PostMapping("/article")
    public int updateArticle(Article article) {

        article.setText(HtmlUtils.htmlEscapeHex(article.getText()));

        return articleService.updateArticle(article);
    }

}
