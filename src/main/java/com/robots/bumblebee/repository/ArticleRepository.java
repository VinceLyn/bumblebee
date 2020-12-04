package com.robots.bumblebee.repository;

import com.robots.bumblebee.entity.db.ArticleEntity;

import java.util.List;


public interface ArticleRepository {

    void save(ArticleEntity entity);

    ArticleEntity findById(String id);

    List<ArticleEntity> findByPage(int pageNum, int pageSize, List<Long> uidList);

}
