package com.robots.bumblebee.repository;

import com.robots.bumblebee.entity.db.UserEntity;

public interface UserRepository{
    UserEntity findByAccount(String account);

    UserEntity findById(String userId);

    UserEntity save(UserEntity userEntity);
}
