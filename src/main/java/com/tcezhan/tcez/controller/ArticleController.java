package com.tcezhan.tcez.controller;

import com.tcezhan.tcez.VO.ResultVO;
import com.tcezhan.tcez.bean.Article;
import com.tcezhan.tcez.service.ArticleService;
import com.tcezhan.tcez.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/article/{id}")
    public ResultVO<Article> findArticleById(@PathVariable("id") Integer id) {
        Article article = articleService.findArticleById(id);
        //将富文本解析
        article.setText(HtmlUtils.htmlUnescape(article.getText()));
        return ResultVOUtil.success(article);
    }


    //TODO
    //返回不带富文本的json对象
    @GetMapping("/articles")
    public ResultVO<List<Article>> findArticle() {

        return ResultVOUtil.success(articleService.findArticle());

    }

    //TODO
    //返回不带富文本的各个json对象
    @GetMapping("/article/{type}")
    public ResultVO<List<Article>> findArticleByType(@PathVariable("type") Integer type) {

        //TODO
        //健壮性完善
        //if (type!=1)

        return ResultVOUtil.success(articleService.findArticleByType(type));
    }

    //TODO
    @DeleteMapping("/article/{id}")
    public ResultVO deleteArticle(@PathVariable("id") Integer id) {
        if (articleService.findArticleById(id).equals(null)){
            //不存在返回
        }
        articleService.deleteArticle(id);

        return ResultVOUtil.success();
    }


    @PostMapping("/article")
    public ResultVO insertArticle(Article article) {
        //解析富文本
        article.setText(HtmlUtils.htmlEscapeHex(article.getText()));
        articleService.insertArticle(article);
        return ResultVOUtil.success();
    }

    @PutMapping("/article")
    public ResultVO updateArticle(Article article) {

        article.setText(HtmlUtils.htmlEscapeHex(article.getText()));
        articleService.updateArticle(article);
        return ResultVOUtil.success();
    }

}
