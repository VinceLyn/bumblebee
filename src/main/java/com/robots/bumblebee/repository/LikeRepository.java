package com.robots.bumblebee.repository;

import com.robots.bumblebee.entity.db.LikeEntity;


public interface LikeRepository {

    void updateOrInsert(String aid, long uid);

    void update(String aid, long uid);

    boolean isExist(String aid, long uid);

    LikeEntity findByAid(String aid);

}
