package com.robots.bumblebee.repository;

import com.robots.bumblebee.entity.db.UserEntity;

import java.util.List;
import java.util.Set;

public interface UserRepository {

    UserEntity findByAccount(String account);

    UserEntity findById(String userId);

    List<UserEntity> findByIds(Set<String> userIds);

    UserEntity save(UserEntity userEntity);

}
