package com.robots.bumblebee.service.impl;

import com.robots.bumblebee.entity.vo.ArticleVO;
import com.robots.bumblebee.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {


    @Override
    public List<ArticleVO> getArticles(Integer pageNum, Integer pageSize, List<Long> uidList) {
        return null;
    }

    @Override
    public ArticleVO show(Integer id) {
        return null;
    }
}
