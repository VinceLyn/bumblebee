package com.robots.bumblebee.repository;

import com.robots.bumblebee.entity.db.LikeEntity;


public interface LikeRepository {

    void like(String aid, long uid);

    void unLike(String aid, long uid);

    boolean isLike(String aid, long uid);

    LikeEntity findByAid(String aid);

}
