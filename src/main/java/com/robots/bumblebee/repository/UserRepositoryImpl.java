package com.robots.bumblebee.repository;

import com.robots.bumblebee.entity.db.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserEntity findByAccount(String account) {
        Query query = Query.query(Criteria.where("account").is(account));
        return mongoTemplate.findOne(query, UserEntity.class);
    }

    @Override
    public UserEntity findById(String userId) {
        return mongoTemplate.findById(userId, UserEntity.class);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return mongoTemplate.save(userEntity);
    }
}
