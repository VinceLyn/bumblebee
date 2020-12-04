package com.robots.bumblebee.repository;

import com.robots.bumblebee.BaseTest;
import com.robots.bumblebee.entity.db.ArticleEntity;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yichengdong
 * @date 2020/12/4
 */
class ArticleRepositoryTest extends BaseTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void save() {
        ArticleEntity entity = new ArticleEntity();
        entity.setUid(12L);
        entity.setTitle("test");
        entity.setText("text");
        articleRepository.save(entity);
        System.out.println(entity);

        ArticleEntity result = articleRepository.findById(entity.getId());
        assertNotNull(result);
    }



    @Test
    public void findById(){
        String id = "5fc9e920ea65be03b57e4a5f";
        ArticleEntity result = articleRepository.findById(id);
        assertNotNull(result);
    }

    @Test
    public void findByPage(){
        List<Long> uidList = Lists.newArrayList();
        uidList.add(11L);
        uidList.add(12L);
        List<ArticleEntity> result = articleRepository.findByPage(1, 2,uidList);
        assertNotEquals(result.size(),0);
    }


}