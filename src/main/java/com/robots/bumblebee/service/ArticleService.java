package com.robots.bumblebee.service;

import com.robots.bumblebee.entity.request.Article;
import com.robots.bumblebee.entity.vo.ArticleVO;
import com.robots.bumblebee.entity.vo.SimpleUserVO;

import java.util.List;


public interface ArticleService {


    List<ArticleVO> getArticles(Integer pageNum, Integer pageSize, List<Long> uidList);

    ArticleVO show(String id);

    void publishArticle(Article article);

    void repost(String id, String text);

    List<SimpleUserVO> getLikes(String id);

    void like(String id);

    void unlike(String id);

}
