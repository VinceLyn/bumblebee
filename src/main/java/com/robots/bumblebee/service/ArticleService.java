package com.robots.bumblebee.service;

import com.robots.bumblebee.entity.db.UserEntity;
import com.robots.bumblebee.entity.request.Article;
import com.robots.bumblebee.entity.vo.ArticleVO;
import com.robots.bumblebee.entity.vo.SimpleUserVO;

import java.util.List;


public interface ArticleService {


    List<ArticleVO> getArticles(Integer pageNum, Integer pageSize, List<String> uidList);

    ArticleVO show(String id);

    void publishArticle(Article article, UserEntity curUserEntity);

    void repost(String sourceId, String text, UserEntity userEntity);

    List<SimpleUserVO> getLikes(String id);

    void like(String aid, String curUserId);

    void unlike(String aid, String curUserId);

}
