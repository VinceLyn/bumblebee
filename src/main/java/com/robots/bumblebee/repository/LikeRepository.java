package com.robots.bumblebee.repository;

import com.robots.bumblebee.entity.db.LikeEntity;


public interface LikeRepository {

    void like(String aid, String uid);

    void unlike(String aid, String uid);

    boolean isExist(String aid, String uid);

    LikeEntity findByAid(String aid);

}
