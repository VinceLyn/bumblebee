package com.robots.bumblebee.service.impl;

import com.robots.bumblebee.entity.db.User;
import com.robots.bumblebee.repository.UserRepository;
import com.robots.bumblebee.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("用户不存在！");
    }

    @Override
    public User getUserByAccount(String account){
        return userRepository.findByAccount(account);
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }

}
