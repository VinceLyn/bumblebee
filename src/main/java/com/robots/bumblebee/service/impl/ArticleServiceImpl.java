package com.robots.bumblebee.service.impl;

import com.google.common.collect.Lists;
import com.robots.bumblebee.entity.db.ArticleEntity;
import com.robots.bumblebee.entity.db.User;
import com.robots.bumblebee.entity.request.Article;
import com.robots.bumblebee.entity.vo.ArticleVO;
import com.robots.bumblebee.entity.vo.SimpleUserVO;
import com.robots.bumblebee.repository.ArticleRepository;
import com.robots.bumblebee.service.ArticleService;
import com.robots.bumblebee.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<ArticleVO> getArticles(Integer pageNum, Integer pageSize, List<Long> uidList) {
        List<ArticleEntity> articleEntities = articleRepository.findByPage(pageNum, pageSize, uidList);
        List<ArticleVO> articleVOList = Lists.newArrayList();
        articleEntities.forEach(entity -> {
            articleVOList.add(assembleArticleVO(entity));
        });
        return articleVOList;
    }

    @Override
    public ArticleVO show(String id) {
        ArticleEntity entity = articleRepository.findById(id);
        return assembleArticleVO(entity);
    }

    private ArticleVO assembleArticleVO(ArticleEntity entity) {
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(entity, articleVO);
        User user = userService.getUser(entity.getUid());
        SimpleUserVO simpleUserVO = new SimpleUserVO();
        BeanUtils.copyProperties(user, simpleUserVO);
        articleVO.setSimpleUserVO(simpleUserVO);
        BeanUtils.copyProperties(entity, articleVO);
        return articleVO;
    }

    @Override
    public void publishArticle(Article article) {
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(article.getTitle());
        entity.setText(article.getText());
        entity.setUid(article.getUserId());
        entity.setSid(null);//发布时没有来源id
        entity.setCtime(System.currentTimeMillis());
        articleRepository.save(entity);
    }

    @Override
    public void repost(String id, String text) {

    }

    @Override
    public List<SimpleUserVO> getLikes(String id) {
        return null;
    }

    @Override
    public void like(String id) {

    }

    @Override
    public void unlike(String id) {

    }
}
