package com.robots.bumblebee.repository;

import com.robots.bumblebee.entity.db.LikeEntity;


public interface LikeRepository {

    void updateOrInsert(String aid, String uid);

    void update(String aid, String uid);

    boolean isExist(String aid, String uid);

    LikeEntity findByAid(String aid);

}
