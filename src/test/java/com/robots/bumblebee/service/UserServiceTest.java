package com.robots.bumblebee.service;

import com.robots.bumblebee.BaseTest;
import com.robots.bumblebee.entity.db.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserServiceTest extends BaseTest {

    @Autowired
    UserService userService;

    @Test
    void getUser() {
        UserEntity userEntity = userService.getUser("1212");
        assertNotNull(userEntity);
    }

    @Test
    void getUserByAccount() {
    }

    @Test
    void save() {
    }
}