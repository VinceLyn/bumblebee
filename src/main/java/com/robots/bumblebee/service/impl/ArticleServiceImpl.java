package com.robots.bumblebee.service.impl;

import com.google.common.collect.Lists;
import com.robots.bumblebee.entity.db.ArticleEntity;
import com.robots.bumblebee.entity.db.LikeEntity;
import com.robots.bumblebee.entity.db.UserEntity;
import com.robots.bumblebee.entity.request.Article;
import com.robots.bumblebee.entity.vo.ArticleVO;
import com.robots.bumblebee.entity.vo.SimpleUserVO;
import com.robots.bumblebee.repository.ArticleRepository;
import com.robots.bumblebee.repository.LikeRepository;
import com.robots.bumblebee.repository.UserRepository;
import com.robots.bumblebee.service.ArticleService;
import com.robots.bumblebee.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<ArticleVO> getArticles(Integer pageNum, Integer pageSize, List<String> uidList) {
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
        SimpleUserVO simpleUserVO = new SimpleUserVO();
        BeanUtils.copyProperties(entity.getUser(), simpleUserVO);
        articleVO.setSimpleUserVO(simpleUserVO);
        return articleVO;
    }

    @Override
    public void publishArticle(Article article, UserEntity userEntity) {
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(article.getTitle());
        entity.setText(article.getText());
        entity.setSid(null);//发布时没有来源id
        entity.setUser(userEntity);
        articleRepository.save(entity);
    }

    @Override
    public void repost(String sourceId, String text, UserEntity userEntity) {
        ArticleEntity entity = new ArticleEntity();
        entity.setText(text);
        entity.setSid(sourceId);//发布时没有来源id
        entity.setUser(userEntity);
        articleRepository.save(entity);
    }

    @Override
    public List<SimpleUserVO> getLikes(String id) {
        LikeEntity likeEntity = likeRepository.findByAid(id);
        Set<String> userIdSet = likeEntity.getUids();
        List<UserEntity> userEntityList = userRepository.findByIds(userIdSet);
        return userEntityList.stream().map(userEntity -> {
            SimpleUserVO simpleUserVO = new SimpleUserVO();
            BeanUtils.copyProperties(userEntity, simpleUserVO);
            return simpleUserVO;
        }).collect(Collectors.toList());
    }

    @Override
    public void like(String aid, String curUserId) {
        likeRepository.like(aid, curUserId);
    }

    @Override
    public void unlike(String aid, String curUserId) {
        likeRepository.unlike(aid, curUserId);
    }
}
