package com.robots.bumblebee.repository.impl;

import com.google.common.collect.Sets;
import com.mongodb.client.result.UpdateResult;
import com.robots.bumblebee.entity.db.LikeEntity;
import com.robots.bumblebee.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class LikeRepositoryImpl implements LikeRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void like(String aid, String uid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("aid").is(aid));
        Update update = new Update();
        update.addToSet("uids", uid);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, LikeEntity.class);
        if (updateResult.getMatchedCount() == 0) {
            LikeEntity entity = new LikeEntity();
            entity.setAid(aid);
            entity.setUids(Sets.newHashSet(uid));
            mongoTemplate.save(entity);
        }
    }

    @Override
    public void unlike(String aid, String uid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("aid").is(aid));
        Update update = new Update();
        update.pull("uids", uid);
        mongoTemplate.updateFirst(query, update, LikeEntity.class);
    }

    @Override
    public boolean isExist(String aid, String uid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("aid").is(aid));
        query.addCriteria(Criteria.where("uids").in(uid));
        long count = mongoTemplate.count(query, LikeEntity.class);
        return count > 0;
    }

    @Override
    public LikeEntity findByAid(String aid) {
        return mongoTemplate.findOne(Query.query(Criteria.where("aid").is(aid)), LikeEntity.class);
    }
}
