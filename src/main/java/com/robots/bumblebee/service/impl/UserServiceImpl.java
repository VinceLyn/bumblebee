package com.robots.bumblebee.service.impl;

import com.robots.bumblebee.entity.db.UserEntity;
import com.robots.bumblebee.repository.UserRepository;
import com.robots.bumblebee.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUser(String userId) {
        UserEntity userEntity = userRepository.findById(userId);
        if (userEntity != null) {
            return userEntity;
        }
        throw new RuntimeException("用户不存在！");
    }

    @Override
    public UserEntity getUserByAccount(String account) {
        return userRepository.findByAccount(account);
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

}
