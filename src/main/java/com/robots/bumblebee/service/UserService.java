package com.robots.bumblebee.service;

import com.robots.bumblebee.entity.db.UserEntity;

public interface UserService  {

    UserEntity getUser(String id);

    UserEntity getUserByAccount(String account);

    void save(UserEntity userEntity);
}
