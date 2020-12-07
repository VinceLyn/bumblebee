package com.robots.bumblebee.repository;

import com.robots.bumblebee.BaseTest;
import com.robots.bumblebee.entity.db.LikeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LikeRepositoryTest extends BaseTest {

    @Autowired
    private LikeRepository likeRepository;

    @Test
    void like() {
        String aid = "5fcd95913803f1218c431c61111";
        String uid = "1";
        likeRepository.updateOrInsert(aid,uid);
    }

    @Test
    void unLike() {
        String aid = "11111";
        String uid = "2";
        likeRepository.update(aid,uid);
    }

    @Test
    void isLike() {
        String aid = "5fcd95913803f1218c431c6e";
        String uid = "100";
        boolean like = likeRepository.isExist(aid, uid);
        assertTrue(like);
    }

    @Test
    void findByAid() {
        String aid = "5fcd95913803f1218c431c6e";
        LikeEntity result = likeRepository.findByAid(aid);
        assertNotNull(result);
    }
}