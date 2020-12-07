package com.robots.bumblebee.repository.impl;

import com.google.common.collect.Lists;
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
    public void like(String aid, long uid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("aid").is(aid));
        Update update = new Update();
        update.addToSet("uids", uid);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, LikeEntity.class);
        if (updateResult.getMatchedCount() < 0) {
            LikeEntity e = new LikeEntity();
            e.setAid(aid);
            e.setUids(Lists.newArrayList(uid));
            LikeEntity entity = mongoTemplate.save(e);
            if (entity == null) {
                mongoTemplate.updateFirst(query, update, LikeEntity.class)
            }
        }
    }

    @Override
    public void unLike(String aid, long uid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("aid").is(aid));
        Update update = new Update();update
        update.push("uids", uid);
        mongoTemplate.updateFirst(query, update, LikeEntity.class);
    }

    @Override
    public boolean isLike(String aid, long uid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("aid").is(aid));
        query.addCriteria(Criteria.where("uids").elemMatch(Criteria.where("")));
        mongoTemplate.count(query,)
        return false;
    }

    @Override
    public LikeEntity findByAid(String aid) {
        LikeEntity likeEntityList = mongoTemplate.findOne(Query.query(Criteria.where("aid").is(aid)), LikeEntity.class);
        return likeEntityList;
    }
}
