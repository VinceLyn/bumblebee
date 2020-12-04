package com.robots.bumblebee.service;

import com.robots.bumblebee.entity.db.User;

public interface UserService {

    User getUser(long id);

    User getUserByAccount(String account);

    void save(User user);
}
