package com.robots.bumblebee.service;

import com.robots.bumblebee.BaseTest;
import com.robots.bumblebee.entity.db.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest extends BaseTest {

    @Autowired
    UserService userService;

    @Test
    void getUser() {
        User user = userService.getUser(1L);
        assertNotNull(user);
    }

    @Test
    void getUserByAccount() {
    }

    @Test
    void save() {
    }
}