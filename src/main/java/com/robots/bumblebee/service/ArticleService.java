package com.robots.bumblebee.service;

import com.robots.bumblebee.entity.vo.ArticleVO;

import java.util.List;


public interface ArticleService {


    List<ArticleVO> getArticles(Integer pageNum, Integer pageSize, List<Long> uidList);

    ArticleVO show(Integer id);
}
